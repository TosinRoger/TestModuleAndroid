package com.test.tosin.stardardresouces.models

import com.google.gson.annotations.*

class Friend {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}