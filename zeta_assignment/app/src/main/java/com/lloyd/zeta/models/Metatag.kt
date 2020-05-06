package com.lloyd.zeta.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Metatag(
    @SerializedName("apple-itunes-app")
    val appleItunesApp: String?,
    @SerializedName("og:description")
    val ogDescription: String?,
    @SerializedName("og:image")
    val ogImage: String?,
    @SerializedName("og:title")
    val ogTitle: String?,
    @SerializedName("og:type")
    val ogType: String?,
    @SerializedName("og:url")
    val ogUrl: String?,
    @SerializedName("twitter:card")
    val twitterCard: String?,
    @SerializedName("twitter:description")
    val twitterDescription: String?,
    @SerializedName("twitter:image:src")
    val twitterImageSrc: String?,
    @SerializedName("twitter:title")
    val twitterTitle: String?,
    @SerializedName("viewport")
    val viewport: String?
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
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(appleItunesApp)
        parcel.writeString(ogDescription)
        parcel.writeString(ogImage)
        parcel.writeString(ogTitle)
        parcel.writeString(ogType)
        parcel.writeString(ogUrl)
        parcel.writeString(twitterCard)
        parcel.writeString(twitterDescription)
        parcel.writeString(twitterImageSrc)
        parcel.writeString(twitterTitle)
        parcel.writeString(viewport)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Metatag> {
        override fun createFromParcel(parcel: Parcel): Metatag {
            return Metatag(parcel)
        }

        override fun newArray(size: Int): Array<Metatag?> {
            return arrayOfNulls(size)
        }
    }
}