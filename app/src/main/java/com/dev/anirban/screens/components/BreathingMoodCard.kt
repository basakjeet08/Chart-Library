package com.dev.anirban.screens.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.R
import com.dev.anirban.ui.theme.ChartLibraryTheme

// Preview Composable Function
@Preview(
    "Light",
    showBackground = true
)
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        Surface {
            BreathingMoodCard()
        }
    }
}

@Composable
fun BreathingMoodCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Your Mood",

                // Text Features
                textAlign = TextAlign.Start,
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f),
            )

            Image(
                painter = painterResource(id = R.drawable.image_happy_face),
                contentDescription = "Happy Face",
                modifier = Modifier
                    .size(58.dp)
                    .padding(top = 8.dp)
            )
        }

        Text(
            text = "I feel Happy Today",

            modifier = Modifier
                .weight(1f),

            // Text Features
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.W600,
            color = Color.Blue,
        )

    }
}