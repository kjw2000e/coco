package com.won.coco.repository

import com.won.coco.network.Api
import com.won.coco.network.RetrofitInstance

class NetworkRepository {

    private val client = RetrofitInstance.getInstance().create(Api::class.java)

    suspend fun getCurrentCoinList() = client.getCurrentCoinList()
}