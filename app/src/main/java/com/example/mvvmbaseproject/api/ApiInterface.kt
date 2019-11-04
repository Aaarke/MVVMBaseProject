package com.example.mvvmbaseproject.api

import com.example.mvvmbaseproject.model.Example
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @get:GET(ApiInventory.DATA_END_POINT)
    val dataFromServer: Single<Example>
}