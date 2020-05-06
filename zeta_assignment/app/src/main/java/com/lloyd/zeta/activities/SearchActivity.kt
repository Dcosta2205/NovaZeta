package com.lloyd.zeta.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lloyd.zeta.R
import com.lloyd.zeta.Utils.BUNDLE_PAGEMAP
import com.lloyd.zeta.models.ImageUIModel
import com.lloyd.zeta.models.Item
import com.lloyd.zeta.viewmodels.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity() {

    private lateinit var searchViewModel: SearchViewModel
    private var searchQuery: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
        searchViewModel.liveData.observe(this, Observer { imageUiModel ->
            when (imageUiModel) {
                is ImageUIModel.OnSuccess -> {
                    val itemsList = ArrayList<Item>()
                    imageUiModel.itemsList?.forEach { item ->
                        item?.let { it -> itemsList.add(it) }
                    }

                    val intent = Intent(this@SearchActivity, ImageListActivity::class.java)
                    intent.putExtra(BUNDLE_PAGEMAP, itemsList)
                    startActivity(intent)
                }

                is ImageUIModel.OnFailure -> {
                    Toast.makeText(this, imageUiModel.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_search
    }

    override fun initListeners() {
        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchQuery = s.toString()
            }
        })

        btn_search.setOnClickListener {
            if (et_search.text.isEmpty()) {
                et_search.error = getString(R.string.error_text)
            } else if (searchQuery.isNullOrEmpty().not()) {
                searchViewModel.searchImageQuery(searchQuery!!)
            }
        }
    }
}
