package com.example.recapscenes

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.recapscenes.ui.theme.Blue1
import com.example.recapscenes.ui.theme.SecondaryColor
import com.example.recapscenes.ui.theme.WeekDayColor

@Composable
fun CircleLink(subject: String) {
    var shittyIntent: Intent = ss
    val context = LocalContext.current

    when (subject) {
        "CAM" -> shittyIntent = cam
        "SS" -> shittyIntent = ss
        "AC" -> shittyIntent = ac
        "PE" -> shittyIntent = pe
        "MAT" -> shittyIntent = mat
    }

    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(25.dp))
            .clickable {
                ContextCompat.startActivity(context, shittyIntent, null)
            }
            .background(color = Color.White)
    ) {
        Text(text = subject, Modifier.padding(20.dp))
    }

}



@Composable
fun WeekdaySelectionShit(day: String, route: String, navController: NavController) {
    Button(
        modifier = Modifier
            .height(40.dp)
            .width(40.dp),
        onClick = { navController.navigate(route) },
        shape = RoundedCornerShape(25.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(
            text = day,
            fontSize = 10.sp,
            color = SecondaryColor
        )
    }
}


@Composable
fun Monday(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "CAM", time = "9.30")
        SubjectBoxGridShit(subject = "AC", time = "10.30")
        SubjectBoxGridShit(subject = "SS", time = "11.30")
        SubjectBoxGridShit(subject = "PE", time = "12.30")
        SubjectBoxGridShit(subject = "MAT", time = "1.30")
    }
}

@Composable
fun Tuesday(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "shit", time = "9.30")
        SubjectBoxGridShit(subject = "bitch", time = "10.30")
        SubjectBoxGridShit(subject = "its", time = "11.30")
        SubjectBoxGridShit(subject = "working", time = "12.30")
        SubjectBoxGridShit(subject = "hohoho", time = "1.30")
    }
}

@Composable
fun Wednesday(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "shit", time = "9.30")
        SubjectBoxGridShit(subject = "bitch", time = "10.30")
        SubjectBoxGridShit(subject = "its", time = "11.30")
        SubjectBoxGridShit(subject = "working", time = "12.30")
        SubjectBoxGridShit(subject = "lol fk", time = "1.30")
    }
}

@Composable
fun Thursday(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "CAM", time = "9.30")
        SubjectBoxGridShit(subject = "AC", time = "10.30")
        SubjectBoxGridShit(subject = "SS", time = "11.30")
        SubjectBoxGridShit(subject = "PE", time = "12.30")
        SubjectBoxGridShit(subject = "MAT", time = "1.30")
    }
}

@Composable
fun Friday(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "CAM", time = "9.30")
        SubjectBoxGridShit(subject = "AC", time = "10.30")
        SubjectBoxGridShit(subject = "SS", time = "11.30")
        SubjectBoxGridShit(subject = "PE", time = "12.30")
        SubjectBoxGridShit(subject = "MAT", time = "1.30")
    }
}



@Composable
fun SubjectBoxGridShit(subject: String, time: String) {
    var shitIntent: Intent = ss
    var handledBy = "bitch"
    val context = LocalContext.current

    when (subject) {
        "CAM" -> {
            shitIntent = cam
            handledBy = "Vijitha Khan Myr"
        }
        "SS" -> {
            shitIntent = ss
            handledBy = "Krishna Kumar"
        }
        "AC" -> {
            shitIntent = ac
            handledBy = "Santhosh"
        }
        "PE" -> {
            shitIntent = pe
            handledBy = "Kili"
        }
        "MAT" -> {
            shitIntent = mat
            handledBy = "Prabha Miss"
        }
    }


    Row() {

        Button(
            modifier = Modifier
                .weight(0.1f)
                .size(0.dp, 75.dp)
                .alpha(0.8f),
            onClick = {  },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = WeekDayColor)
        ) {
            Text(
                text = time,
                fontSize = 25.sp,
                color = Blue1
            )
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            modifier = Modifier
                .weight(0.2f)
                .size(0.dp, 75.dp)
                .alpha(0.9f),
            onClick = {
                ContextCompat.startActivity(context, shitIntent, null)
            },
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = WeekDayColor)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = subject,
                    fontSize = 25.sp,
                    color = Blue1
                )
                Text(
                    text = handledBy,
                    fontSize = 10.sp,
                    color = Blue1
                )

            }

        }



    }

    Spacer(modifier = Modifier.padding(5.dp))
}