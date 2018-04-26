package com.test.tosin.stardardresouces.models

import com.google.gson.annotations.*

class Name {

    @SerializedName("first")
    @Expose
    var first: String? = null
    @SerializedName("last")
    @Expose
    var last: String? = null

}