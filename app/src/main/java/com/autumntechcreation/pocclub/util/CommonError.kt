package com.gamut.fvcustomerorder.util

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class CommonError {
    @SerializedName("error")
    @Expose
    var error: String? = null
    @SerializedName("error_description")
    @Expose
    var errorDescription: String? = null
}