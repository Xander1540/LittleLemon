package com.example.littlelemonexcercise

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(drawerState: DrawerState? = null, scope: CoroutineScope?= null){
    Row(horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)),
        verticalAlignment = Alignment.CenterVertically
        ){

        IconButton(onClick = { scope?.launch {drawerState?.open()} }) {
            Image(
                painter = painterResource(id = R.drawable.ham),
                contentDescription = "Menu Icon",
                modifier = Modifier.size(30.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.fillMaxWidth(0.5F)
                .padding(start = 0.1.dp)
                .size(30.dp)
        )
        IconButton(onClick = {  }) {
            Image(painter = painterResource(id = R.drawable.cart),
                contentDescription = "Cart",
                modifier = Modifier.size(25.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TopAppBarPreview(){
    TopAppBar()
}