package com.example.composeandroidpractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeandroidpractice.ui.compose.GmailCloneActivity
import com.example.composeandroidpractice.ui.compose.MyApp
import com.example.composeandroidpractice.ui.theme.ComposeAndroidPracticeTheme

class SelfBioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MyApp { startActivity(Intent(this, GmailCloneActivity::class.java)) }
        }
//        setContent {
//            ComposeAndroidPracticeTheme {
//                Surface(
//                    color = Color.LightGray, modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(8.dp)
//                    ) {
//
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Image(
//                                painter = painterResource(id = R.drawable.man),
//                                contentDescription = "This is sample practice",
//                                modifier = Modifier
//                                    .size(100.dp)
//                                    .clip(
//                                        CircleShape
//                                    )
//                            )
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally,
//                                verticalArrangement = Arrangement.SpaceAround
//                            ) {
//                                Text(
//                                    text = "Umer Bilal",
//                                    fontSize = 22.sp,
//                                    modifier = getFillWidthSpace()
//                                )
//                                Spacer(modifier = Modifier.size(6.dp))
//                                Text(
//                                    modifier = getFillWidthSpace(),
//                                    text = "Android Developer",
//                                    fontSize = 16.sp
//                                )
//                            }
//                        }
//                        AddTitle(title = "About")
//
//                        Text(
//                            fontSize = 16.sp,
//                            text = (stringResource(R.string.aboutself)).repeat(6),
//                            modifier = getFillWidthSpace()
//                        )
//
//                        AddTitle(title = "Education ")
//
//                        AddColumnCouple(rtext = "Matric", ltext = "From Rawalpindi")
//
//                        AddColumnCouple(rtext = "Inter", ltext = "From Rawalpindi")
//
//                        AddColumnCouple(rtext = "Graduation", ltext = "From Islamabad")
//
//                        AddTitle(title = "Skill Set ")
//
//                        LazyRowItemsDemo()
//                    }
//
//                }
//            }
//
//        }
    }
}



fun getFillWidthSpace(): Modifier {
    return Modifier.fillMaxWidth()
}

fun getWrapWidthSpace(): Modifier {
    return Modifier.wrapContentWidth()
}

@Composable
fun AddTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.h1,
        fontSize = 22.sp,
        modifier = getFillWidthSpace(),
        fontStyle = FontStyle.Italic,
        color = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
fun CheckSingleComponent() {
    AddColumnCouple("Umer ", "Bilal")
    LazyRowItemsDemo()
}

@Composable
fun AddColumnCouple(rtext: String, ltext: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = rtext,
            style = MaterialTheme.typography.h5,
            modifier = getWrapWidthSpace().weight(1.5f),
            fontStyle = FontStyle.Italic,
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .width(12.dp)
                .wrapContentHeight()
        )
        Text(
            text = ltext,
            style = MaterialTheme.typography.h5,
            modifier = getWrapWidthSpace().weight(2f),
            fontStyle = FontStyle.Italic,
            color = Color.Black
        )
    }
}

@Composable
fun LazyRowItemsDemo() {

    val skills = remember { listOfSkills }

    LazyRow {
        items(items = skills, itemContent = { sfd ->
            Text(
                text = sfd,
                modifier = Modifier
                    .border(1.dp, Color.Black, CircleShape)
                    .background(
                        Color.White
                    )
                    .width(100.dp)
                    .padding(5.dp), textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(4.dp))
        })

    }
}

val listOfSkills = listOf("Android", "XML", "HTML", "WEB", "Koltin", "Java", "GSON", "Json", ".Net")

@Preview
@Composable
fun ArtistCard() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .background(
                Color.LightGray
            )
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.man),
            contentDescription = "This is sample practice",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Column {
            Text("artist.name")
            Text("artist.lastSeenOnline")
        }
    }
}


@Preview
@Composable
fun OverLapView(){
    Box {
        Image(painter = painterResource(id = R.drawable.man),contentDescription = null,modifier = Modifier.size(100.dp))
        Icon(painter = painterResource(id = R.drawable.ic_baseline_check_circle_outline_24),contentDescription = null)
    }
}



