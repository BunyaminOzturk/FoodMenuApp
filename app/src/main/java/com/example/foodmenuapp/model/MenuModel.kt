package com.example.foodmenuapp.model

import android.os.Parcel
import android.os.Parcelable

sealed class MenuModel {
    data class Header(
        val menuTitle: String
    ) : MenuModel()

    data class MenuItems(
        val menuName: String,
        val menuDesc: String,
        val amount: String,
        val imageResource: Int
    ) : MenuModel(), Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readString().toString(),
            parcel.readInt()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(menuName)
            parcel.writeString(menuDesc)
            parcel.writeString(amount)
            parcel.writeInt(imageResource)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<MenuItems> {
            override fun createFromParcel(parcel: Parcel): MenuItems {
                return MenuItems(parcel)
            }

            override fun newArray(size: Int): Array<MenuItems?> {
                return arrayOfNulls(size)
            }
        }
    }
}

