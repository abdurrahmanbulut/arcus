package com.abdurrahmanbulut.arcus.features.main.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.abdurrahmanbulut.arcus.app.navigator

@Composable
fun InboxScreen() {
    val navigator = navigator()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Content()
    }
}

@Composable
fun Content() {
    Text("settings")
}
