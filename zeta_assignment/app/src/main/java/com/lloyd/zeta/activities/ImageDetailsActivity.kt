package com.lloyd.zeta.activities

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.lloyd.zeta.R
import com.lloyd.zeta.Utils.BUNDLE_PAGEMAP
import com.lloyd.zeta.models.Item
import kotlinx.android.synthetic.main.activity_image_details.*

class ImageDetailsActivity : BaseActivity() {

    private lateinit var item: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromIntents()
        bindDataToUI()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun bindDataToUI() {
        Glide.with(this)
            .load(item.pagemap?.cseImage?.first()?.src)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(iv_image_cse_thumbnail)
        tv_title.text = "Title : " + "\n" + item.title
        tv_more_info.text =
            item.htmlSnippet?.let { HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY) }
        item.pagemap?.metatags?.first().apply {
            if (this?.ogDescription != null) {
                tv_description.visibility = View.VISIBLE
                tv_description.text =
                    "Description : " + "\n" + item.pagemap?.metatags?.first()?.ogDescription
            } else {
                tv_description.visibility = View.GONE
            }
        }
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_image_details
    }

    override fun initListeners() {
        // Not required here
    }

    private fun getDataFromIntents() {
        item = intent.extras?.get(BUNDLE_PAGEMAP) as Item
    }
}
