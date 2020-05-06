package com.lloyd.zeta.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lloyd.zeta.R
import com.lloyd.zeta.Utils.BUNDLE_PAGEMAP
import com.lloyd.zeta.adapter.ImageListAdapter
import com.lloyd.zeta.interfaces.ImageClickListener
import com.lloyd.zeta.models.Item
import kotlinx.android.synthetic.main.activity_image_list.*

class ImageListActivity : BaseActivity(), ImageClickListener {

    private lateinit var itemsList: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getItemsListFromSearch()
        setRecyclerViewAdapter()
    }

    private fun setRecyclerViewAdapter() {
        rv_recyclerview.layoutManager = LinearLayoutManager(this)
        if (::itemsList.isInitialized && itemsList.isNullOrEmpty().not()) {
            val imageListAdapter = ImageListAdapter(this, itemsList)
            rv_recyclerview.adapter = imageListAdapter
        }
    }

    private fun getItemsListFromSearch() {
        itemsList = intent.getParcelableArrayListExtra<Item>(BUNDLE_PAGEMAP) as ArrayList<Item>
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_image_list;
    }

    override fun initListeners() {
        // Not required here
    }

    override fun onImageClicked(position: Int, item: Item) {
        val intent = Intent(this@ImageListActivity, ImageDetailsActivity::class.java)
        intent.putExtra(BUNDLE_PAGEMAP, item)
        startActivity(intent)
    }
}
