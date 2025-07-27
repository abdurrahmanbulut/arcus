package com.arcus.features.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcus.model.CatFact
import com.arcus.network.repository.SplashRepository

class HomeScreenVM(
    private val splashRepository: SplashRepository,
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
