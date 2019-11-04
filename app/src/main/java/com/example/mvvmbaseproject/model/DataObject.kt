package com.example.mvvmbaseproject.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DataObject : Serializable {
    @SerializedName("id")
    @Expose
    val id: String? = null
    @SerializedName("text")
    @Expose
    val text: String? = null
}