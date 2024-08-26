package com.won.coco.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.won.coco.model.CurrentPriceItem
import com.won.coco.model.CurrentPriceItemResult
import com.won.coco.repository.NetworkRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class SelectViewModel() : ViewModel() {

    private lateinit var resultList: ArrayList<CurrentPriceItemResult>
    val networkRepository = NetworkRepository()

    fun getAllCoinList() = viewModelScope.launch {
        val result = networkRepository.getCurrentCoinList()
        resultList = ArrayList()

        for (coin in result.data) {

            try {
                val gson = Gson()
                val gsonToJson = gson.toJson(result.data.get(coin.key))
                val gsonFromJson = gson.fromJson(gsonToJson, CurrentPriceItem::class.java)
                val currentPriceItemResult = CurrentPriceItemResult(coin.key, gsonFromJson)

                Timber.d(currentPriceItemResult.toString())
                resultList.add(currentPriceItemResult)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }
}

