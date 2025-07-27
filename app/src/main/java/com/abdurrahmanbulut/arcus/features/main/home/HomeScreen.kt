package com.abdurrahmanbulut.arcus.features.main.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abdurrahmanbulut.arcus.app.LocalNavigator
import com.abdurrahmanbulut.arcus.app.navigation.LocalInsets
import com.abdurrahmanbulut.arcus.core.constants.SecureStorage
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun HomeScreen(storage: SecureStorage = koinInject()) {
    val viewModel: HomeScreenVM = koinViewModel()

    val navigator = LocalNavigator.current
    val insets = LocalInsets.current
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(top = insets.statusBarHeight)
                .clickable { navigator.pop() },
    ) {
        Text(
            text = viewModel.test,
            color = Color.Blue,
            modifier = Modifier.padding(bottom = 20.dp),
        )
    }
}
