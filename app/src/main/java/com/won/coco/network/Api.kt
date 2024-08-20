package com.won.coco.network

import com.won.coco.model.CurrentPriceItem
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @Headers("Accept: application/json")
    @GET("v1/ticker")
    suspend fun getCurrentCoinList(@Query("markets") markets: String): List<CurrentPriceItem>
}