package com.sazcode.movierating

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MovieItemScreen() {
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Column {
            Image(
                modifier = Modifier.clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                ),
                painter = painterResource(id = R.drawable.movieimgtest),
                contentDescription = null
            )
            Text(

                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = "Madame Web",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Text(
                modifier = Modifier.padding(horizontal = 2.dp, vertical = 1.dp),
                text = "14 de feb 2024",
                fontSize = 12.sp
            )
        }
    }
}