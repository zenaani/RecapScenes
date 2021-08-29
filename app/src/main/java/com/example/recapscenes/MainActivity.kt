package com.example.recapscenes

import android.app.*
import android.content.Context
import android.content.Intent
import android.icu.number.NumberRangeFormatter.with
import android.os.Build
import android.os.Bundle
import android.os.Parcel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recapscenes.ui.theme.*
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerScheduler
import java.security.AccessController.getContext
import java.text.SimpleDateFormat
import java.util.*


var currentDay = ""
class MainActivity : ComponentActivity() {


    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val scrollStateV = rememberScrollState()
            val navControllerShit = rememberNavController()


            //implement for loop in composables for time constraint


            //Use AlarmManager or WorkManafger
            //Refer YT video with keyword AlarmManger






            //Fix the bugs regarding selected chip index
            //listOf

            //Add if selectedChipIndex and change colour for Sure


            //Play with Opacity
            //Implement motionlayput



            //Change background opacity continuously like breathing (using Motion Layout)

            //For Background
            Box(
                modifier = Modifier
                        .fillMaxSize()
            ) {

                /*
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.cool),
                    contentDescription = "spidey",
                    contentScale = ContentScale.Crop,
                )

                 */


                //For Seperating Top and Bottom Section
                Column(
                    modifier = Modifier
                        .background(color = Color.White)
                        .fillMaxSize()
                ) {



                    //Top Section First Layer
                    Column(
                        modifier = Modifier
                            .background(
                                color = SecondaryColor,
                                shape = RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp)
                            )
                    ) {

                        //Top Section Second Layer
                        Column(
                            modifier = Modifier
                                .background(
                                    color = PrimaryColor,
                                    //brush = Brush.verticalGradient(colors = mutableStateListOf(Blue1, Blue2)),
                                    shape = RoundedCornerShape(0.dp, 0.dp, 50.dp, 50.dp)

                                )
                        ) {

                            Button(onClick = {





                                setAlarm(this@MainActivity,3000)






                            }) {
                                Text(text = "Show / Schedule Notification")
                            }

                            Spacer(modifier = Modifier.padding(50.dp))

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                text = "Greetings Bitches",
                                fontSize = 40.sp,
                                textAlign = TextAlign.Center,
                                color = Blue1
                            )

                            Spacer(modifier = Modifier.padding(10.dp))


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center

                            ) {
                                CircleLink(subject = "SS")
                                CircleLink(subject = "CAM")
                                CircleLink(subject = "AC")
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center

                            ) {
                                CircleLink(subject = "PE")
                                CircleLink(subject = "SE")
                                CircleLink(subject = "MAT")
                                CircleLink(subject = "MIN")
                            }

                            Spacer(modifier = Modifier.padding(15.dp))

                        }
                        //Top Section Second Layer End

                        Spacer(modifier = Modifier.padding(10.dp))


                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(60.dp, 0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            WeekdaySelectionShit(day = "M",
                                route = "monday",
                                navController = navControllerShit
                            )
                            WeekdaySelectionShit(day = "T",
                                route = "tuesday",
                                navController = navControllerShit
                            )
                            WeekdaySelectionShit(day = "W",
                                route = "wednesday",
                                navController = navControllerShit
                            )
                            WeekdaySelectionShit(day = "T",
                                route = "thursday",
                                navController = navControllerShit
                            )
                            WeekdaySelectionShit(day = "F",
                                route = "friday",
                                navController = navControllerShit
                            )
                        }

                        Spacer(modifier = Modifier.padding(10.dp))

                    }
                    //Top Section First Layer End


                    //Bottom Section

                    Box(
                        modifier = Modifier
                            .padding(30.dp)
                        //.background(color = PrimaryPurple, shape = RoundedCornerShape(25.dp))
                        //.padding(25.dp)

                    ) {

                        //Column for Day Title and BoxLayout Composables

                        Column(
                            modifier = Modifier
                                .verticalScroll(scrollStateV)
                        ) {

                            NavHost(navController = navControllerShit, startDestination = "monday") {

                                composable(route = "monday") {
                                    Monday(navController = navControllerShit)
                                }
                                composable(route = "tuesday") {
                                    Tuesday(navController = navControllerShit)
                                }

                                composable(route = "wednesday") {
                                    Wednesday(navController = navControllerShit)
                                }

                                composable(route = "thursday") {
                                    Thursday(navController = navControllerShit)
                                }

                                composable(route = "friday") {
                                    Friday(navController = navControllerShit)
                                }

                            }


                        }


                    }


                }

            }

        }
    }

    fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val mChannel = NotificationChannel("asd", CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH)

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(mChannel)


        }

    }

    fun setAlarm(context: Context, timeOfAlarm: Long) {

        // Intent to start the Broadcast Receiver
        val broadcastIntent = Intent(context, NotificationReceiver::class.java)

        val pIntent = PendingIntent.getBroadcast(
            context,
            0,
            broadcastIntent,
            0
        )

        // Setting up AlarmManager
        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmMgr.set(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + 1000,
            pIntent
        )

        /*

        if (System.currentTimeMillis() < timeOfAlarm) {

        }

         */
    }


}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecapScenesTheme {










    }
}