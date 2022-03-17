package com.example.composeandroidpractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeandroidpractice.ui.theme.ComposeAndroidPracticeTheme
import com.example.composeandroidpractice.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndroidPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAndroidPracticeTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Surface(
                modifier = Modifier
                    .width(100.dp)
                    .height(200.dp), color = MaterialTheme.colors.primary
            ) {
                Greeting("Android")
                CustomText(txt = "Bila Tiger")
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "sdlfkjlds",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.primary, CircleShape)
                )
                Spacer(modifier = Modifier.size(20.dp))
                Column {
                    Text(text = "Umer Bilal", color = MaterialTheme.colors.primary)
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "Android Developer",
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(8.dp)
                    )
                }

            }
            UserIntroText(name = "Umer Bilal")
            Greeting(name = "Umer Bilal")
        }

    }
}

@Composable
fun UserIntroText(name: String) {
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp
//    val expanded by remember {
//        mutableStateOf(false)
//    }
    Surface(
        color = MaterialTheme.colors.primary, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = extraPadding)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(fontSize = 30.sp, text = name)
            Button(onClick = { }) {
                Text(text = "Click Me")
            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }
            ) {
                Text(if (expanded.value) "Show less" else "Show more")
            }
        }
    }
}
@Composable
private fun Greetings(names: List<String> = List(1000) { "$it" } ) {
//    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
//        items(items = names) { name ->
//            Greeting(name = name)
//        }
//    }
}
@Composable
fun CustomText(txt: String) {
    Text(text = txt, style = Typography.h5)
}