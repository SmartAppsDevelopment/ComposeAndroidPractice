package com.example.composeandroidpractice.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.composeandroidpractice.R
import com.example.composeandroidpractice.data.EmailListItem
import com.example.composeandroidpractice.helper.sdp
import com.example.composeandroidpractice.ui.compose.DeploySimpleMainItem


@Composable
fun AccountDialog(openDialog: MutableState<Boolean>) {
    val emailItem = EmailListItem(
        "Umer Bilal",
        "This is middle title for list item sd fas df asf asf",
        "Hello my name is john and i am calling on behalf ",
        Icons.Default.Facebook
    )
    Dialog(onDismissRequest = { openDialog.value = false }) {
        AccountDialogUI(gmailAccountRef = emailItem)
    }
}

@Composable
fun AccountDialogUI(gmailAccountRef: EmailListItem) {
    val modifier = Modifier
    Card(backgroundColor = White) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(White)
                .padding(8.sdp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = (Icons.Filled.Close),
                    contentDescription = ""
                )
                Image(
                    painter = painterResource(id = R.drawable.googletrans), modifier = modifier
                        .size(30.sdp)
                        .weight(2f), contentDescription = ""
                )
            }
            gmailAccountRef.DeploySimpleMainItem()

            OutlinedButton(
                modifier = modifier
                    .padding(end = 100.sdp)
                    .wrapContentWidth(CenterHorizontally)
                    .align(Alignment.CenterHorizontally)
                    ,
                onClick = { /*TODO*/ }, border = BorderStroke(1.dp, Red),
                shape = RoundedCornerShape(50), // = 50%
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Gray)
            ) {
                Text(text = "Google Account", color = Black)
            }
        }
    }
}

@Preview
@Composable
fun showUI() {
    val emailItem = EmailListItem(
        "Umer Bilal",
        "This is middle title for list item sd fas df asf asf",
        "Hello my name is john and i am calling on behalf ",
        Icons.Default.Facebook
    )
    AccountDialogUI(gmailAccountRef = emailItem)
}