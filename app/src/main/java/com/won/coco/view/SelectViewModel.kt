package com.won.coco.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.won.coco.model.CurrentPriceItem
import com.won.coco.model.CurrentPriceItemResult
import com.won.coco.repository.NetworkRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class SelectViewModel : ViewModel() {

    private var _resultList = MutableLiveData<ArrayList<CurrentPriceItemResult>>()
    val resultList: LiveData<ArrayList<CurrentPriceItemResult>>
        get() = _resultList

    private val networkRepository = NetworkRepository()

    private var priceItemList = ArrayList<CurrentPriceItemResult>()

    fun getAllCoinList() = viewModelScope.launch {
        val result = networkRepository.getCurrentCoinList()

        for (coin in result.data) {
            try {
                val gson = Gson()
                val gsonToJson = gson.toJson(result.data.get(coin.key))
                val gsonFromJson = gson.fromJson(gsonToJson, CurrentPriceItem::class.java)
                val currentPriceItemResult = CurrentPriceItemResult(coin.key, gsonFromJson)

                Timber.d(currentPriceItemResult.toString())
                priceItemList.add(currentPriceItemResult)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }

        _resultList.value = priceItemList
    }
}

