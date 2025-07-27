package com.arcus.network.repository

import com.arcus.network.ApiCall
import com.arcus.network.NetworkService
import com.arcus.network.api.StockApi
import kotlinx.coroutines.CoroutineScope

class StockRepository(
    private val api: StockApi,
) {
    fun getStockPrice(
        scope: CoroutineScope,
        symbol: String,
    ): ApiCall<Any> =
        NetworkService.call(scope) {
            api.getStockPrice(
                function = "GLOBAL_QUOTE",
                symbol = symbol,
                apiKey = "GUUGH1WRKYZZD4GF",
            )
        }
}
