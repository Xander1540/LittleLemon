package com.example.littlelemonexcercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

    @Composable
    private fun HomeScreen() {

        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerPanel(drawerState = drawerState, scope = scope)
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(drawerState = drawerState, scope = scope)
                }
            ) { paddingValues ->Column(modifier = Modifier.padding(paddingValues)) {
                UpperPanel()
                LowerPanel()
            }
            }
        }
    }


    /*

    @Composable
    fun AppScreen(){
        var count by rememberSavable{
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

    */

