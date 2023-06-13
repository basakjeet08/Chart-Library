package com.dev.anirban.screens.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.R
import com.dev.anirban.ui.theme.ChartLibraryTheme
import com.dev.anirban.ui.theme.InterFontFamily

// Preview Composable Function
@Preview("Light")
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        Surface {
            WaterOverHydrationNote(labelIcon = R.drawable.image_note)
        }
    }
}


@OptIn(ExperimentalUnitApi::class)
@Composable
fun WaterOverHydrationNote(
    modifier: Modifier = Modifier,
    labelIcon: Int
) {
    Column {

        Row(
            modifier = modifier
                .padding(start = 12.dp, bottom = 4.dp, end = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = labelIcon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "Over hydration",

                // Text and Font Properties
                textAlign = TextAlign.Start,
                color = Color.Red,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.W600,
                fontSize = 14.sp
            )
        }

        Text(
            text = "You have crossed your daily intake",

            // Modifications
            modifier = Modifier
                .padding(start = 44.dp, bottom = 2.dp),

            // Text and Font Properties
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onSurface,
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp
        )

        Text(
            text = "Over hydration can lead to water intoxication. This occurs when " +
                    "the amount of salt and other electrolytes in your body become too diluted.",

            // Modifications
            modifier = Modifier
                .padding(start = 44.dp, bottom = 12.dp, end = 6.dp),

            // Text and Font Properties
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f),
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = TextUnit(
                value = 18f,
                TextUnitType.Sp
            )
        )
    }
}