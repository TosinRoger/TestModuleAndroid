package com.test.tosin.stardardresouces.models

import com.google.gson.annotations.*
import java.io.Serializable

class Friend: Serializable {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null

}