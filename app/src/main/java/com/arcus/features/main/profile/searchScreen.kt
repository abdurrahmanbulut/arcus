package com.arcus.features.main.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arcus.app.navigator

@Composable
fun ProfileScreen() {
    val navigator = navigator()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Content()
    }
}

@Composable
fun Content() {
    Text("profile")
}
