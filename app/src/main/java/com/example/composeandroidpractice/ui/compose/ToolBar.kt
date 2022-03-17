package com.example.composeandroidpractice.ui.compose


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.composeandroidpractice.R
import com.example.composeandroidpractice.helper.sdp
import com.example.composeandroidpractice.helper.textSdp


@Preview(showBackground = true)
@Composable
fun ArtistCard() {
    MyApp()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyApp() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize(),
    ) {

        Card(
            backgroundColor = Color.White, modifier = Modifier
                .padding(top = 40.sdp, bottom = 40.sdp, start = 16.sdp, end = 16.sdp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            BoxWithConstraints {
                // val constraintSet= portraitConstraint(16.dp)
                val dynamicConstraints = if (minWidth<600.dp) {
                    portraitConstraint(16.dp)
                } else {
                    landScapeConstraint(16.dp)
                }
              // val dynamicConstraints = portraitConstraint(16.dp)
                ConstraintLayout(
                    constraintSet = dynamicConstraints
                    //                horizontalAlignment = Alignment.CenterHorizontally,
                    //                verticalArrangement = Arrangement.Center
                ) {
//                    val (imgRef,txtRefName,txtRefCount,rowStats,rowBtn)= createRefs()
//                    val topGuideline=createGuidelineFromTop(0.1f)
                    Image(
                        painter = painterResource(id = R.drawable.man),
                        contentDescription = "hello this is me ",
                        modifier = Modifier
                            .size(100.sdp)
                            .clip(CircleShape)
                            .border(1.sdp, Color.Red, CircleShape)
                            .layoutId("imgRef")
                    )
                    Text(
                        text = "Umer Bilal",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.textSdp,
                        modifier = Modifier.layoutId("txtRefName")
                    )
                    Text(
                        text = "Android Developer (Pakistan)",
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = 16.textSdp,
                        modifier = Modifier.layoutId("txtRefCount")
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("rowStats")

                    ) {
                        addColumnItem(textNo = "100", text = "Follower")
                        addColumnItem(textNo = "123", text = "Following")
                        addColumnItem(textNo = "80", text = "Posts")
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("rowBtn")
                    ) {
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Create Post")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Direct Messge")
                        }
                    }
                }
            }
        }
    }

}


@Composable
fun addColumnItem(textNo: String, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = textNo, fontWeight = FontWeight.ExtraBold, fontSize = 12.textSdp)
        Text(text = text, fontSize = 12.textSdp)
    }
}


private fun portraitConstraint(marginReq: Dp): ConstraintSet {
    return ConstraintSet {
        val imgRef = createRefFor("imgRef")
        val txtRefName = createRefFor("txtRefName")
        val txtRefCount = createRefFor("txtRefCount")
        val rowStats = createRefFor("rowStats")
        val rowBtn = createRefFor("rowBtn")
        val topGuideline = createGuidelineFromTop(0.2f)
        constrain(imgRef) {
            top.linkTo(topGuideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(txtRefName) {
            top.linkTo(imgRef.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(txtRefCount) {
            top.linkTo(txtRefName.bottom, margin = marginReq)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats) {
            top.linkTo(txtRefCount.bottom, margin = marginReq)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowBtn) {
            top.linkTo(rowStats.bottom, margin = marginReq)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
    }
}

private fun landScapeConstraint(marginReq: Dp): ConstraintSet {
    return ConstraintSet {
        val imgRef = createRefFor("imgRef")
        val txtRefName = createRefFor("txtRefName")
        val txtRefCount = createRefFor("txtRefCount")
        val rowStats = createRefFor("rowStats")
        val rowBtn = createRefFor("rowBtn")
        val topGuideline = createGuidelineFromTop(0.2f)
        val bottomGuideline = createGuidelineFromBottom(0.2f)
        constrain(imgRef) {
            top.linkTo(topGuideline)
            start.linkTo(parent.start)
            //end.linkTo(txtRefName.start)
        }
        constrain(txtRefName) {
            top.linkTo(imgRef.top)
            start.linkTo(imgRef.end)
            bottom.linkTo(txtRefCount.top)

        }
        constrain(txtRefCount) {
            top.linkTo(txtRefName.bottom, margin = marginReq)
            start.linkTo(imgRef.end)

            top.linkTo(txtRefName.bottom)
            bottom.linkTo(imgRef.bottom)
        }
        constrain(rowStats) {
            top.linkTo(imgRef.bottom, margin = marginReq)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowBtn) {
            top.linkTo(rowStats.bottom, margin = marginReq)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(bottomGuideline)
        }
        createHorizontalChain(imgRef,txtRefName, chainStyle = ChainStyle.Packed)
        createHorizontalChain(imgRef,txtRefCount, chainStyle = ChainStyle.Packed)
       /// createVerticalChain(imgRef,txtRefName, chainStyle = ChainStyle.Packed)
    }
}

