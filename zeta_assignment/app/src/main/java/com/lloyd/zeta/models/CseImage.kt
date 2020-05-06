package com.lloyd.zeta.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CseImage(
    @SerializedName("src")
    val src: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(src)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CseImage> {
        override fun createFromParcel(parcel: Parcel): CseImage {
            return CseImage(parcel)
        }

        override fun newArray(size: Int): Array<CseImage?> {
            return arrayOfNulls(size)
        }
    }
}