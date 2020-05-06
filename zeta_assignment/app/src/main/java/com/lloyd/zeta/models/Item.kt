package com.lloyd.zeta.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("cacheId")
    val cacheId: String?,
    @SerializedName("displayLink")
    val displayLink: String?,
    @SerializedName("formattedUrl")
    val formattedUrl: String?,
    @SerializedName("htmlFormattedUrl")
    val htmlFormattedUrl: String?,
    @SerializedName("htmlSnippet")
    val htmlSnippet: String?,
    @SerializedName("htmlTitle")
    val htmlTitle: String?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("pagemap")
    val pagemap: Pagemap?,
    @SerializedName("snippet")
    val snippet: String?,
    @SerializedName("title")
    val title: String?
) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Pagemap::class.java.classLoader),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cacheId)
        parcel.writeString(displayLink)
        parcel.writeString(formattedUrl)
        parcel.writeString(htmlFormattedUrl)
        parcel.writeString(htmlSnippet)
        parcel.writeString(htmlTitle)
        parcel.writeString(kind)
        parcel.writeString(link)
        parcel.writeParcelable(pagemap, flags)
        parcel.writeString(snippet)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}