package com.example.littlelemonexcercise

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UpperPanel(){

    var context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xC92EC2C2))) {
        Text(
            text = stringResource(id = R.string.title), fontSize = 32.sp,
            color = Color(0xFFE9DC48),
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        )
        Text(
            text = stringResource(id = R.string.chicago), fontSize = 24.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(start = 20.dp)
        )
        Row(
            modifier = Modifier.padding(start = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier.width(200.dp).padding(top = 20.dp, end = 15.dp),
                color = Color(0xFFFFFFFF),
                fontSize = 21.sp
            )
            Image(
                painter = painterResource(id = R.drawable.restaurant), contentDescription = "",
                Modifier.height(260.dp).padding(top = 20.dp).clip(RoundedCornerShape(20.dp))
            )
        }
        Button(onClick = {
            Toast.makeText(context, "Order Successful!",
                Toast.LENGTH_SHORT).show()
        },
            modifier = Modifier.padding(20.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFE9DC48))) {
            Text(text = stringResource(id = R.string.btn),
                color = Color(0xFF000000)
            )
        }
    }
}