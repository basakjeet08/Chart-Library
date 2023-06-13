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
            DetailsCard(
                imageList = listOf(
                    R.drawable.image_inhaled_quantity,
                    R.drawable.image_total_breathes,
                    R.drawable.image_calories
                ),
                headerTextList = listOf(
                    "Inhaled Quantity",
                    "Total Breathes",
                    "Calories"
                ),
                valueList = listOf(
                    "11,000 litres",
                    "6620",
                    "258 kcal"
                )
            )
        }
    }
}

@Composable
fun DetailsCard(
    imageList: List<Int>,
    headerTextList: List<String>,
    valueList: List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        imageList.forEachIndexed { index, image ->

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Inhaled quantity",
                    modifier = Modifier
                        .size(34.dp)
                )

                Text(
                    text = headerTextList[index],

                    modifier = Modifier
                        .padding(top = 8.dp),

                    // Text Features
                    textAlign = TextAlign.Start,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f),
                )

                Text(
                    text = valueList[index],

                    modifier = Modifier
                        .padding(top = 8.dp),

                    // Text Features
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}