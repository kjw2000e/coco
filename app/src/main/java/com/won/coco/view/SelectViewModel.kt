package com.won.coco.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.won.coco.repository.NetworkRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class SelectViewModel() : ViewModel() {

    val networkRepository = NetworkRepository()

    fun getAllCoinList() = viewModelScope.launch {
        val result = networkRepository.getCurrentCoinList()

        Timber.d(result.toString())
    }
}

