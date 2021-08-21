package com.example.recapscenes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recapscenes.ui.theme.*


var currentDay = ""
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val blah = Modifier.clickable(enabled = true, onClick = {} )

            val contextShit = this@MainActivity

            val scrollStateV = rememberScrollState()

            val scrollStateH = rememberScrollState()

            val navControllerShit = rememberNavController()

            //Add if selectedChipIndex and change colour
            var selectedChipIndex by remember {
                mutableStateOf(0)
            }


            //Or add WeekDays at the last to >>>> accessibility 



            //Outer Layout Column
            Column() {
                

                //Greetings
                Text(
                    modifier = Modifier
                    .padding(10.dp),
                    text = "Good Morning Bitch!",
                    color = Purple500,
                    fontSize = 35.sp
                )


                //Circle Links Here
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp)
                        .horizontalScroll(scrollStateH)
                ) {
                    CircleLink(subject = "ss", context = contextShit)
                    CircleLink(subject = "cam", context = contextShit)
                    CircleLink(subject = "ac", context = contextShit)
                    CircleLink(subject = "pe", context = contextShit)
                    CircleLink(subject = "se", context = contextShit)
                    CircleLink(subject = "mat", context = contextShit)
                    CircleLink(subject = "min", context = contextShit)
                }


                //Weekdays Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp, 10.dp, 0.dp),
                ) {
                    WeekdaySelectionShit(day = "Monday", route = "monday", navController = navControllerShit)
                    WeekdaySelectionShit(day = "Tuesday", route = "tuesday", navController = navControllerShit)
                    WeekdaySelectionShit(day = "Wednesday", route = "wednesday", navController = navControllerShit)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp, 0.dp, 10.dp, 5.dp),
                ) {
                    WeekdaySelectionShit(day = "Thursday", route = "thursday", navController = navControllerShit)
                    WeekdaySelectionShit(day = "Friday", route = "friday", navController = navControllerShit)
                }



                //Fragment Starts here

                Box(
                    modifier = Modifier
                        .padding(25.dp, 0.dp, 25.dp, 25.dp)
                        .background(color = PrimaryPurple, shape = RoundedCornerShape(25.dp))
                        .padding(25.dp)

                ) {

                    //Column for Day Title and BoxLayout Composables

                    Column(
                        modifier = Modifier
                            .verticalScroll(scrollStateV)
                    ) {

                        NavHost(navController = navControllerShit, startDestination = "monday") {

                            composable(route = "monday") {
                                Monday(navController = navControllerShit, context = contextShit)
                            }
                            composable(route = "tuesday") {
                                Tuesday(navController = navControllerShit, context = contextShit)
                            }

                            composable(route = "wednesday") {
                                Wednesday(navController = navControllerShit, context = contextShit)
                            }

                            composable(route = "thursday") {
                                Thursday(navController = navControllerShit, context = contextShit)
                            }

                            composable(route = "friday") {
                                Friday(navController = navControllerShit, context = contextShit)
                            }

                        }



                    }



                }


                //Fragment Ends here


            }


        }
    }
}



/*
@Composable
fun Profile(navController: NavController) {
    /*...*/
    Button(onClick = { navController.navigate("friendslist") }) {
        Text(text = "Navigate next")
    }
    /*...*/
}

@Composable
fun FriendsList(navController: NavController) {
    /*...*/
    Button(onClick = { navController.navigate("profile") }) {
        Text(text = "Navigate shit")
    }
    /*...*/
}

 */


@Composable
fun CircleLink(subject: String, context: Context) {
    var shittyIntent: Intent = ss

    when (subject) {
        "cam" -> shittyIntent = cam
        "ss" -> shittyIntent = ss
        "ac" -> shittyIntent = ac
        "pe" -> shittyIntent = pe
        "mat" -> shittyIntent = mat
    }

    Button(
        modifier = Modifier
            .padding(5.dp)
            .height(65.dp)
            .width(65.dp),
        onClick = {
            startActivity(context, shittyIntent, null)
                  },
        shape = RoundedCornerShape(100.dp)
    ) {
        Text(text = subject)
    }
}



@Composable
fun WeekdaySelectionShit(day: String, route: String, navController: NavController) {
    Button(
        modifier = Modifier
            .padding(5.dp),
        onClick = { navController.navigate(route) },
        shape = RoundedCornerShape(25.dp)
    ) {
        Text(text = day)
    }
}

@Composable
fun Monday(navController: NavController, context: Context) {
    Column(
        modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "cam",context = context, time = "9.30 - 10.30")
        SubjectBoxGridShit(subject = "ac",context = context, time = "10.30 - 10.30")
        SubjectBoxGridShit(subject = "ss",context = context, time = "11.30 - 10.30")
        SubjectBoxGridShit(subject = "pe",context = context, time = "12.30 - 10.30")
        SubjectBoxGridShit(subject = "mat",context = context, time = "1.30 - 10.30")
    }
}

@Composable
fun Tuesday(navController: NavController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "shit",context = context, time = "9.30 - 10.30")
        SubjectBoxGridShit(subject = "bitch",context = context, time = "10.30 - 10.30")
        SubjectBoxGridShit(subject = "its",context = context, time = "11.30 - 10.30")
        SubjectBoxGridShit(subject = "working",context = context, time = "12.30 - 10.30")
        SubjectBoxGridShit(subject = "hohoho",context = context, time = "1.30 - 10.30")
    }
}

@Composable
fun Wednesday(navController: NavController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "shit",context = context, time = "9.30 - 10.30")
        SubjectBoxGridShit(subject = "bitch",context = context, time = "10.30 - 10.30")
        SubjectBoxGridShit(subject = "its",context = context, time = "11.30 - 10.30")
        SubjectBoxGridShit(subject = "working",context = context, time = "12.30 - 10.30")
        SubjectBoxGridShit(subject = "lol fk",context = context, time = "1.30 - 10.30")
    }
}

@Composable
fun Thursday(navController: NavController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "cam",context = context, time = "9.30 - 10.30")
        SubjectBoxGridShit(subject = "ac",context = context, time = "10.30 - 10.30")
        SubjectBoxGridShit(subject = "ss",context = context, time = "11.30 - 10.30")
        SubjectBoxGridShit(subject = "pe",context = context, time = "12.30 - 10.30")
        SubjectBoxGridShit(subject = "mat",context = context, time = "1.30 - 10.30")
    }
}

@Composable
fun Friday(navController: NavController, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubjectBoxGridShit(subject = "cam",context = context, time = "9.30 - 10.30")
        SubjectBoxGridShit(subject = "ac",context = context, time = "10.30 - 10.30")
        SubjectBoxGridShit(subject = "ss",context = context, time = "11.30 - 10.30")
        SubjectBoxGridShit(subject = "pe",context = context, time = "12.30 - 10.30")
        SubjectBoxGridShit(subject = "mat",context = context, time = "1.30 - 10.30")
    }
}



@Composable
fun SubjectBoxGridShit(subject: String, context: Context, time: String) {
    var shitIntent: Intent = ss

    when (subject) {
        "cam" -> shitIntent = cam
        "ss" -> shitIntent = ss
        "ac" -> shitIntent = ac
        "pe" -> shitIntent = pe
        "mat" -> shitIntent = mat
    }

    Row() {

        Button(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .size(0.dp, 110.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(25.dp),
            //colors = ButtonDefaults.buttonColors(backgroundColor = Purple700)
        ) {
            Text(text = time)
        }

        Spacer(modifier = Modifier.padding(5.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth(1f)
                .size(0.dp, 110.dp),
            onClick = {
                startActivity(context, shitIntent, null)
            },
            shape = RoundedCornerShape(25.dp),
            //colors = ButtonDefaults.buttonColors(backgroundColor = Purple700)
        ) {
            Text(
                text = subject,
                fontSize = 25.sp
            )
        }

    }

    Spacer(modifier = Modifier.padding(5.dp))
}


/*
fun uriParser(context: Context, intent: Intent) {
    startActivity(context,intent, null)
}

 */

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecapScenesTheme {



    }
}