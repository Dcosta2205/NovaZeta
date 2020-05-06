package com.lloyd.zeta.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.lloyd.zeta.R
import com.lloyd.zeta.models.ImageUIModel
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
                    imageUiModel.pageMap?.cseThumbnail?.forEach {
                        Log.d("Lloyd", " Image url is " + it?.width)
                    }
                }

                is ImageUIModel.OnFailure -> {
                    Log.d("Lloyd ", " Error occurred while searching ${imageUiModel.errorMessage}")
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
