package com.example.mvvmbaseproject.model

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Example:Serializable {
    @SerializedName("data")
    @Expose
    val data: List<DataObject>? = null
}