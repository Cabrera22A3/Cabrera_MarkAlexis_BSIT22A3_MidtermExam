package com.example.cabrera_markalexis_bsit22a3_midtermexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cabrera_markalexis_bsit22a3_midtermexam.ui.theme.Cabrera_MarkAlexis_BSIT22A3_MidtermExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cabrera_MarkAlexis_BSIT22A3_MidtermExamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}

@Composable
fun MainApp(){

    var QuestionOpen by remember { mutableStateOf(0) }
    var score by remember{ mutableStateOf(0) }

    Column {
        Row (
            modifier = Modifier
                .background(color = Color.Blue)
                .height(100.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            HeaderBackground()
        }
        Row (
            modifier = Modifier
                .background(color = Color.DarkGray)
                .padding(all = 8.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            BodyContent()
        }
        Row (
            modifier = Modifier
                .background(color = Color.DarkGray)
                .padding(all = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            TryFooter()
        }
    }





}

@Composable
fun HeaderBackground(){
    Row {
        Column {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "pokeball-1",
                modifier = Modifier
                    .height(80.dp)
                    .align(Alignment.Start)
                    .padding(vertical = 8.dp)
            )
        }
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.pokemon),
                    contentDescription = "pokemon",
                    modifier = Modifier
                        .height(80.dp)
                        .align(Alignment.CenterVertically)
                        .padding(start = 35.dp)
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.quiz_game),
                    contentDescription = "quiz_game",
                    modifier = Modifier
                        .width(200.dp)
                        .align(Alignment.CenterVertically)
                )
            }
        }
        Column {
            Image(
                painter = painterResource(id = R.drawable.pokeball),
                contentDescription = "pokeball-2",
                modifier = Modifier
                    .height(80.dp)
                    .align(Alignment.End)
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun BodyContent(){
    var QuizDone by remember{mutableStateOf(false)}
    if(!QuizDone){
        RandomImageWithButton()
    }
}

@Composable
fun TryFooter(){
    Column {
        Row {
            Text(
                text = "Name: Mark Alexis Jaudian Cabrera",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter)
                    .padding(bottom = 60.dp)
            )
        }
        Row {
            Text(
                text = "Section: BSIT-22A3",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter)
                    .padding(bottom = 60.dp)
            )
        }
    }
}

@Composable//dito nangyayari yung pagdisplay ng dice image
fun RandomImageWithButton(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(3) }
    val imageResource = when (result) {
        1 -> R.drawable.pikachu
        2 -> R.drawable.bulbasaur
        //3 -> R.drawable.dice_3
        //4 -> R.drawable.dice_4
        //5 -> R.drawable.dice_5
        else -> R.drawable.squirtle
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxHeight(.3f)
                .fillMaxWidth(.8f)
        ){
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = result.toString()
            )
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(20.dp)
            )
        }
        Row {
            val answer = remember { mutableStateOf("") }
            TextField(
                value = answer.value, // Set the current value from the state variable
                onValueChange = { answer.value = it }, // Update state on value change
                label = { Text("Enter your answer:") },
                modifier = Modifier
                    .fillMaxWidth(.8f)
                    .padding(top = 10.dp, bottom = 10.dp)
            )
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(16.dp)
            )
        }
        Row {
            Button(//dito nangyayari yung pagbigay ng randomise numbers from 1-6
                onClick = {
                    result = (1..6).random()
                }
            ) {//since naglagay ng button ung text yung nagsisilbi kung para saan yung button
                Text(stringResource(R.string.confirm_btn))
            }
            Spacer(//para siyang margin para sa button
                modifier = Modifier
                    .height(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Cabrera_MarkAlexis_BSIT22A3_MidtermExamTheme {
        MainApp()
    }
}