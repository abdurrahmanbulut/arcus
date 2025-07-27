package com.arcus.features.main

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arcus.app.navigation.screen
import com.arcus.app.navigation.screen.Screen
import com.arcus.app.navigator
import com.arcus.core.navigation.Navigation
import com.arcus.core.navigation.Navigator
import com.arcus.features.main.home.HomeScreen
import com.arcus.features.main.profile.ProfileScreen
import com.arcus.features.main.settings.SettingsScreen
import com.arcus.features.search.SearchScreen
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.mainScreen(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit,
) {
    screen(
        route = route,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() },
        content = content,
    )
}

fun NavGraphBuilder.mainNavGraph(mainScreenVM: MainScreenVM) {
    mainScreen(Screen.Main.Home.route) { HomeScreen(mainScreenVM) }
    mainScreen(Screen.Main.Profile.route) { ProfileScreen() }
    mainScreen(Screen.Main.Settings.route) { SettingsScreen() }
    mainScreen(Screen.Main.Search.route) { SearchScreen() }
}

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MainScreenVM>()
    val navController = rememberNavController()

    Observe(viewModel)
    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet =
            ConstraintSet {
                val navHost = createRefFor("navHost")
                val navigationBar = createRefFor("navigationBar")

                constrain(navHost) {
                    top.linkTo(parent.top)
                    bottom.linkTo(navigationBar.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                constrain(navigationBar) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
            },
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Main.Home.route,
            enterTransition = Navigation.enterTransition,
            exitTransition = Navigation.exitTransition,
            popEnterTransition = Navigation.popEnterTransition,
            popExitTransition = Navigation.popExitTransition,
            modifier = Modifier.layoutId("navHost"),
        ) {
            viewModel.navigator = Navigator(navController)
            mainNavGraph(viewModel)
        }
        NavigationBar(
            viewModel,
            currentRoute = navController.currentBackStackEntry?.destination?.route,
            Modifier.layoutId("navigationBar"),
        )
    }
}

@Composable
fun Observe(viewmodel: MainScreenVM) {
}

@Composable
fun NavigationBar(
    viewModel: MainScreenVM,
    currentRoute: String?,
    modifier: Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .height(64.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        NavBarItem(
            icon = Icons.Default.Home,
            label = "Home",
            isSelected = currentRoute == Screen.Main.Home.route,
            onClick = { viewModel.onClickHome() },
        )
        NavBarItem(
            icon = Icons.Default.Search,
            label = "Search",
            isSelected = currentRoute == Screen.Main.Search.route,
            onClick = { viewModel.onClickSearch() },
        )
        NavBarItem(
            icon = Icons.Default.Person,
            label = "Profile",
            isSelected = currentRoute == Screen.Main.Profile.route,
            onClick = { viewModel.onClickProfile() },
        )
        NavBarItem(
            icon = Icons.Default.Settings,
            label = "Settings",
            isSelected = currentRoute == Screen.Main.Settings.route,
            onClick = { viewModel.onClickSettings() },
        )
    }
}

@Composable
fun NavBarItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .clickable { onClick() }
                .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface,
        )
    }
}
