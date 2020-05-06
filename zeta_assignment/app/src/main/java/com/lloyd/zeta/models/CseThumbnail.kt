package com.lloyd.zeta.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class CseThumbnail(
    @SerializedName("height")
    val height: String?,
    @SerializedName("src")
    val src: String?,
    @SerializedName("width")
    val width: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(height)
        parcel.writeString(src)
        parcel.writeString(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CseThumbnail> {
        override fun createFromParcel(parcel: Parcel): CseThumbnail {
            return CseThumbnail(parcel)
        }

        override fun newArray(size: Int): Array<CseThumbnail?> {
            return arrayOfNulls(size)
        }
    }
}