package com.won.coco.repository

import com.won.coco.network.Api
import com.won.coco.network.RetrofitInstance
import retrofit2.Retrofit

class NetworkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getCurrentCoinList() = client.getCurrentCoinList("KRW-BTC")
}