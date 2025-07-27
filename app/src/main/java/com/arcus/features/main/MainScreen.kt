package com.arcus.features.main

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arcus.app.navigation.LocalInsets
import com.arcus.app.navigation.screen
import com.arcus.app.navigation.screen.Screen
import com.arcus.core.navigation.Navigation
import com.arcus.core.navigation.Navigator
import com.arcus.core.theme.colors
import com.arcus.features.main.home.HomeScreen
import com.arcus.features.main.profile.ProfileScreen
import com.arcus.features.main.settings.InboxScreen
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
    mainScreen(Screen.Main.Home.route) { HomeScreen() }
    mainScreen(Screen.Main.Inbox.route) { InboxScreen() }
    mainScreen(Screen.Main.Search.route) { SearchScreen() }
    mainScreen(Screen.Main.Profile.route) { ProfileScreen() }
}

@Composable
fun MainScreen() {
    val viewModel = koinViewModel<MainScreenVM>()
    val navController = rememberNavController()
    val insets = LocalInsets.current

    Observe(viewModel)
    Column(
        modifier = Modifier.fillMaxSize().background(color = colors.background1)
    ) {
        TitleBar(
            title = viewModel.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = insets.statusBarHeight)
        )

        NavHost(
            navController = navController,
            startDestination = Screen.Main.Home.route,
            enterTransition = Navigation.enterTransition,
            exitTransition = Navigation.exitTransition,
            popEnterTransition = Navigation.popEnterTransition,
            popExitTransition = Navigation.popExitTransition,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            viewModel.navigator = Navigator(navController)
            mainNavGraph(viewModel)
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = colors.divider
        )
        LaunchedEffect(navController.currentBackStackEntry) {
            println("navController.currentBackStackEntry")
            println(navController.currentBackStackEntry)
        }
        NavigationBar(
            viewModel,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colors.navbar)
                .padding(bottom = insets.navigationBarHeight)
        )
    }
}

@Composable
fun Observe(viewmodel: MainScreenVM) {}

@Composable
private fun NavigationBar(
    viewModel: MainScreenVM,
    modifier: Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .background(colors.navbar)
                .height(64.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        NavBarItem(
            icon = Icons.Default.Home,
            label = "Home",
            isSelected = viewModel.activeItem == 0,
            onClick = { viewModel.onClickHome() },
        )
        NavBarItem(
            icon = Icons.Default.MailOutline,
            label = "Gelen Kutusu",
            isSelected = viewModel.activeItem == 1,
            onClick = { viewModel.onClickInbox() },
        )
        NavBarItem(
            icon = Icons.Default.Search,
            label = "Search",
            isSelected = viewModel.activeItem == 2,
            onClick = { viewModel.onClickSearch() },
        )

        NavBarItem(
            icon = Icons.Default.Person,
            label = "Profile",
            isSelected = viewModel.activeItem == 3,
            onClick = { viewModel.onClickProfile() },
        )
    }
}

@Composable
private fun NavBarItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    bounded = false,
                    radius = 32.dp,
                    color = colors.navbar
                )
            ) { onClick() }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier.size(24.dp, 32.dp),
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) colors.white else colors.asphalt3,
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) colors.white else colors.asphalt3,
        )
    }
}

@Composable
fun TitleBar(
    title: String,
    modifier: Modifier = Modifier,
    leftIcon: ImageVector? = null,
    leftIconContentDescription: String? = null,
    onLeftIconClick: (() -> Unit)? = null,
    rightIcon: ImageVector? = null,
    rightIconContentDescription: String? = null,
    onRightIconClick: (() -> Unit)? = null,
) {
    val constraintSet = ConstraintSet {
        val leftIconRef = createRefFor("leftIcon")
        val titleRef = createRefFor("title")
        val rightIconRef = createRefFor("rightIcon")

        // Title
        constrain(titleRef) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        // Left Icon
        if (leftIcon != null && onLeftIconClick != null) {
            constrain(leftIconRef) {
                start.linkTo(parent.start, margin = 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        }

        // Right Icon
        if (rightIcon != null && onRightIconClick != null) {
            constrain(rightIconRef) {
                end.linkTo(parent.end, margin = 16.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        // Title
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colors.white,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = Modifier.layoutId("title")
        )

        // Left Icon
        if (leftIcon != null && onLeftIconClick != null) {
            Icon(
                imageVector = leftIcon,
                contentDescription = leftIconContentDescription,
                tint = colors.white,
                modifier = Modifier
                    .layoutId("leftIcon")
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(
                            bounded = false,
                            radius = 24.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) { onLeftIconClick() }
                    .padding(8.dp)
            )
        }

        // Right Icon
        if (rightIcon != null && onRightIconClick != null) {
            Icon(
                imageVector = rightIcon,
                contentDescription = rightIconContentDescription,
                tint = colors.white,
                modifier = Modifier
                    .layoutId("rightIcon")
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(
                            bounded = false,
                            radius = 24.dp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) { onRightIconClick() }
                    .padding(8.dp)
            )
        }
    }
}