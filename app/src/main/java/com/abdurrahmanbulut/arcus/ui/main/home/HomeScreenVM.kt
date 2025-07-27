package com.abdurrahmanbulut.arcus.ui.main.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdurrahmanbulut.arcus.model.CatFact
import com.abdurrahmanbulut.arcus.network.repository.SplashRepository

class HomeScreenVM(private val splashRepository: SplashRepository) : ViewModel() {
    val test = "Home Screen"

    val catFact: MutableState<CatFact?> = mutableStateOf(null)

    init {
        getFacts()
    }

    private fun getFacts() {
        splashRepository.getFacts(viewModelScope)
            .success {
            }
            .failure {
            }
    }
}
