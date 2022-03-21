package com.example.composeandroidpractice.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

val listOfDrawerMenu = mutableListOf(
    DrawerMenuData.opt1,
    DrawerMenuData.opt2,
    DrawerMenuData.opt3,
    DrawerMenuData.divider,
    DrawerMenuData.AllInbox,
    DrawerMenuData.support,
    DrawerMenuData.onlinepred,
    DrawerMenuData.opt2,
    DrawerMenuData.divider,
    DrawerMenuData.AllInbox,
    DrawerMenuData.support,
    DrawerMenuData.onlinepred,
    DrawerMenuData.divider,
    DrawerMenuData.AllInbox,
    DrawerMenuData.support,
    DrawerMenuData.onlinepred,
    DrawerMenuData.divider,
    DrawerMenuData.AllInbox,
    DrawerMenuData.support,
    DrawerMenuData.onlinepred,)

sealed class DrawerMenuData(
    var icon: ImageVector?,
    val title: String,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false
) {
    object opt3 : DrawerMenuData(Icons.Outlined.AllInbox, "All Inbox")
    object opt2 : DrawerMenuData(Icons.Outlined.Inbox, "Inbox")
    object opt1 : DrawerMenuData(Icons.Outlined.RestartAlt, "Restart")
    object divider :
        DrawerMenuData(isDivider = true, isHeader = true, title = "Resemblacnce", icon = null)

    object AllInbox : DrawerMenuData(Icons.Outlined.Rule, "All Inbox")
    object support : DrawerMenuData(Icons.Outlined.Support, "All Inbox")
    object onlinepred : DrawerMenuData(Icons.Outlined.OnlinePrediction, "All Inbox")
}