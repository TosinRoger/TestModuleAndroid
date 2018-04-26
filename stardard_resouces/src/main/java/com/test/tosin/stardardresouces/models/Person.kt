package com.test.tosin.stardardresouces.models

import com.google.gson.annotations.*
import java.io.Serializable


class Person: Serializable {

    @SerializedName("_id")
    @Expose
    var id: String? = null
    @SerializedName("index")
    @Expose
    var index: Int? = null
    @SerializedName("guid")
    @Expose
    var guid: String? = null
    @SerializedName("isActive")
    @Expose
    var isActive: Boolean? = null
    @SerializedName("balance")
    @Expose
    var balance: String? = null
    @SerializedName("picture")
    @Expose
    var picture: String? = null
    @SerializedName("age")
    @Expose
    var age: Int? = null
    @SerializedName("eyeColor")
    @Expose
    var eyeColor: String? = null
    @SerializedName("name")
    @Expose
    var name: Name? = null
    @SerializedName("company")
    @Expose
    var company: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null
    @SerializedName("about")
    @Expose
    var about: String? = null
    @SerializedName("registered")
    @Expose
    var registered: String? = null
    @SerializedName("latitude")
    @Expose
    var latitude: String? = null
    @SerializedName("longitude")
    @Expose
    var longitude: String? = null
    @SerializedName("tags")
    @Expose
    var tags: List<String>? = null
    @SerializedName("range")
    @Expose
    var range: List<Int>? = null
    @SerializedName("friends")
    @Expose
    var friends: List<Friend>? = null
    @SerializedName("greeting")
    @Expose
    var greeting: String? = null
    @SerializedName("favoriteFruit")
    @Expose
    var favoriteFruit: String? = null


    var completeName: String = ""
        get() {
            return if (name == null)
                ""
            else {
                val temp = name
                "${temp?.first} ${temp?.last}"
            }
        }
}