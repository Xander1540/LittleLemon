package com.example.littlelemonexcercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemonexcercise.ui.theme.LittleLemonExcerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonExcerciseTheme {
                AppScreen()
            }
        }
    }

    @Composable
    fun AppScreen(){
        var count by rememberSaveable{
            mutableStateOf(0)
        }

        ItemOrder(count, {count++}, {count--})
    }

    @Composable
    private fun ItemOrder(count: Int, onIncrement: ()-> Unit, onDecrement: ()-> Unit){

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Greek Salad",
                        fontSize = 30.sp
                    )
                    Row (
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(onClick = { onDecrement() }) {
                            Icon(imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Remove"
                            )
                        }
                        Text(text = "$count",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(10.dp)
                        )

                        IconButton(onClick = { onIncrement() }) {
                            Icon(imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = "Add")
                        }
                }
                    Button(onClick = { /*TODO*/ },
                        Modifier.fillMaxWidth()) {
                        Text(text = "Add")
                    }
            }
            }
        }
    }
}

