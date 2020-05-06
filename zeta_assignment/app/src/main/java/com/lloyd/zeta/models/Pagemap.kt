package com.lloyd.zeta.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Pagemap(
    @SerializedName("cse_image")
    val cseImage: List<CseImage?>?,
    @SerializedName("cse_thumbnail")
    val cseThumbnail: List<CseThumbnail?>?,
    @SerializedName("metatags")
    val metatags: List<Metatag?>?,
    @SerializedName("website")
    val website: List<Website?>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(CseImage),
        parcel.createTypedArrayList(CseThumbnail),
        parcel.createTypedArrayList(Metatag),
        parcel.createTypedArrayList(Website)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(cseImage)
        parcel.writeTypedList(cseThumbnail)
        parcel.writeTypedList(metatags)
        parcel.writeTypedList(website)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pagemap> {
        override fun createFromParcel(parcel: Parcel): Pagemap {
            return Pagemap(parcel)
        }

        override fun newArray(size: Int): Array<Pagemap?> {
            return arrayOfNulls(size)
        }
    }
}