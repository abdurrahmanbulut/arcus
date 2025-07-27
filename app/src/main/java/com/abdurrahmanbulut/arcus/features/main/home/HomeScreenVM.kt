package com.abdurrahmanbulut.arcus.features.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.arcus.core.constants.SecureStorage
import com.abdurrahmanbulut.arcus.core.model.CatFact
import com.abdurrahmanbulut.arcus.core.network.repository.SplashRepository

class HomeScreenVM(
    private val splashRepository: SplashRepository,
    private val storage: SecureStorage,
) : ViewModel() {
    var test by mutableStateOf("Home Screen")

    val catFact: MutableState<CatFact?> = mutableStateOf(null)

    init {
        getFacts()
    }

    private fun getFacts() {
        splashRepository
            .getFacts(viewModelScope)
            .loading {
                test = "yükleniyor"
            }.success {
                test = it.fact ?: ""
            }.failure {
                test = "boş"
            }
    }
}
