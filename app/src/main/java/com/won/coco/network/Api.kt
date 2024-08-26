package com.won.coco.network

import com.won.coco.model.CurrentPriceList
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {

    @Headers("Accept: application/json")
    @GET("public/ticker/ALL_KRW")
    suspend fun getCurrentCoinList(): CurrentPriceList
}