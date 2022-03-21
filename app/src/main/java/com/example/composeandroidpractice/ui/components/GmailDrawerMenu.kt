package com.example.composeandroidpractice.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeandroidpractice.data.DrawerMenuData
import com.example.composeandroidpractice.data.listOfDrawerMenu
import com.example.composeandroidpractice.helper.sdp

@Preview
@Composable
fun DrawerContentAndroid(){
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Text(text = "Gmail", modifier = Modifier.padding(start = 8.dp, top = 8.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        listOfDrawerMenu.forEach{it.EachMenuImpl()}
    }
}

@Composable
fun DrawerMenuData.EachMenuImpl(){
    Row {
        when(isDivider){
            true->{
                Divider(modifier = Modifier.padding(8.dp))
            }
            else->{
                Image(imageVector = icon!!, contentDescription = "", modifier = Modifier
                    .size(40.sdp)
                    .padding(8.dp))
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Light, modifier = Modifier.padding(top=12.dp))
            }
        }
    }
}