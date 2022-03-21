package com.example.composeandroidpractice.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

data class EmailListItem(
    val topTitle: String,
    val midTitle: String,
    val bottomDisc: String,
    val icon: ImageVector,
    val itemClick: ((EmailListItem) -> Unit)? = null
)


fun getEmailListItemData() = listOf(
    EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    ),
    EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.GppMaybe
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.FlashOff
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.FlashOn
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Light
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Lightbulb
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.LightMode
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    ), EmailListItem(
        "This is Sample Email",
        "Scamming User is Prohabit in nature environment",
        "Sample Email from unknown user is found suspected",
        Icons.Rounded.Email
    )
)