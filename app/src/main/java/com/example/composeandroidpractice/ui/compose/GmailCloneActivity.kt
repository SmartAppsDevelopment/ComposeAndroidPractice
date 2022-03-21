package com.example.composeandroidpractice.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeandroidpractice.data.EmailListItem
import com.example.composeandroidpractice.data.getEmailListItemData
import com.example.composeandroidpractice.ui.components.ComposeNavigation
import com.example.composeandroidpractice.ui.components.DrawerContentAndroid
import com.example.composeandroidpractice.ui.components.GoogleBottomNavigation
import com.example.composeandroidpractice.ui.components.MyAppBar
import com.example.composeandroidpractice.ui.compose.ui.theme.ComposeAndroidPracticeTheme

class GmailCloneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          ///  GmailAppContent()
            ComposeNavigation()
        }
    }
}

@Preview
@Composable
fun PreviewActivity() {
    GmailAppContent(rememberNavController())
   /// ComposeNavigation()
}

@Composable
fun GmailAppContent(navController: NavController) {
    ComposeAndroidPracticeTheme {
        // A surface container using the 'background' color from the theme
        val state = rememberScaffoldState()
        val stateCoroutines = rememberCoroutineScope()
        val openDialog = remember {
            mutableStateOf(false)
        }
        Scaffold(
            scaffoldState = state,
            topBar = { MyAppBar(state, stateCoroutines, openDialog) },
            bottomBar = { GoogleBottomNavigation() },
            drawerContent = {
                DrawerContentAndroid()
            }) {
            MailsList(navController)
        }
    }
}

@Composable
fun MailsList(navController: NavController) {
    Box {
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            items(getEmailListItemData()) { listItem ->
                listItem.DeployMainItem{
                    navController.navigate("first_screen")
                }
            }
        }
    }
}

@Composable
fun EmailListItem.DeployMainItem(itemClickListener:()->Unit) {
    Row(modifier = Modifier
        .padding(8.dp)
        .clickable {
itemClickListener.invoke()
        }) {
        Card(elevation = 12.dp, contentColor = Color.Black) {
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .border(
                            1.dp,
                            Color.Red,
                            CircleShape
                        )
                        .padding(6.dp)
                )
                Column {
                    Text(text = topTitle, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                    Text(text = midTitle, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = bottomDisc, fontSize = 12.sp, fontWeight = FontWeight.Normal)
                }
            }
        }
    }
}


@Preview
@Composable
fun EmailListItem.DeploySimpleMainItem() {
    Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Card(elevation = 0.dp, contentColor = Color.Black) {
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .border(
                            1.dp,
                            Color.Red,
                            CircleShape
                        )
                        .padding(6.dp)
                )
                Column {
                    Text(text = topTitle, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                    Text(text = midTitle, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(text = bottomDisc, fontSize = 12.sp, fontWeight = FontWeight.Normal)
                }
            }
        }
    }
}



