package com.example.composeandroidpractice.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Vibration
import androidx.compose.ui.graphics.vector.ImageVector

val listOfBottomNavMenu= mutableListOf(BottomNavDataModel.item1,BottomNavDataModel.item2)
sealed class BottomNavDataModel(val img:ImageVector,val text:String,val isSelected:Boolean=false) {
    object item1:BottomNavDataModel(Icons.Filled.Phone,"Phone", isSelected = true)
    object item2:BottomNavDataModel(Icons.Filled.Vibration,"Vibration")
}