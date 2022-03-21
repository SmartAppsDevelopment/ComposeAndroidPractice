package com.example.composeandroidpractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeandroidpractice.ui.theme.ComposeAndroidPracticeTheme

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidPracticeTheme {
                Surface(
                    color = Color.LightGray, modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.man),
                                contentDescription = "This is sample practice",
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(
                                        CircleShape
                                    )
                            )
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceAround
                            ) {
                                Text(text = "Umer Bilal", fontSize = 22.sp, modifier = getFillWidthSpace())
                                Spacer(modifier = Modifier.size(6.dp))
                                Text(
                                    modifier = getFillWidthSpace(),
                                    text = "Android Developer",
                                    fontSize = 16.sp
                                )
                            }
                        }
                        AddTitle(title = "About")

                        Text(
                            fontSize = 16.sp,
                            text = (stringResource(R.string.aboutself)).repeat(6),
                            modifier = getFillWidthSpace()
                        )

                        AddTitle(title = "Education ")

                        AddColumnCouple(rtext = "Matric", ltext = "From Rawalpindi")

                        AddColumnCouple(rtext = "Inter", ltext = "From Rawalpindi")

                        AddColumnCouple(rtext = "Graduation", ltext = "From Islamabad")

                        AddTitle(title = "Skill Set ")

                        LazyRowItemsDemo()
                        Button(onClick = { startActivity(Intent(this@StartActivity,SelfBioActivity::class.java)) }) {
                            Text(text = "Click To Go ")
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showDefaultPreview() {
    ComposeAndroidPracticeTheme {
        Surface(
            color = Color.LightGray, modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.man),
                        contentDescription = "This is sample practice",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(
                                CircleShape
                            )
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        Text(text = "Umer Bilal", fontSize = 22.sp, modifier = getFillWidthSpace())
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            modifier = getFillWidthSpace(),
                            text = "Android Developer",
                            fontSize = 16.sp
                        )
                    }
                }
                AddTitle(title = "About")

                Text(
                    fontSize = 16.sp,
                    text = (stringResource(R.string.aboutself)).repeat(6),
                    modifier = getFillWidthSpace()
                )

                AddTitle(title = "Education ")

                AddColumnCouple(rtext = "Matric", ltext = "From Rawalpindi")

                AddColumnCouple(rtext = "Inter", ltext = "From Rawalpindi")

                AddColumnCouple(rtext = "Graduation", ltext = "From Islamabad")

                AddTitle(title = "Skill Set ")

                LazyRowItemsDemo()
            }

        }
    }
}

