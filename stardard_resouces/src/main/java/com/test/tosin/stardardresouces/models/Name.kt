package com.test.tosin.stardardresouces.models

import com.google.gson.annotations.*
import java.io.Serializable

class Name: Serializable {

    @SerializedName("first")
    @Expose
    var first: String? = null
    @SerializedName("last")
    @Expose
    var last: String? = null

}