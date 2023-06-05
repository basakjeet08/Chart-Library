package com.dev.anirban.chartlibrary.library.circular.center

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface

/**
 * This class is the implementation of [CircularCenterInterface] which focuses on providing an
 * implementation to draw 3 texts in the center of the Ring Chart
 *
 * This Class in particular is the implementation to draw texts
 */
class RingChartTextCenter : CircularCenterInterface {

    /**
     * This function does nothing which is fine since we want the default Circle Center to be nothing
     */
    @Composable
    override fun DrawCenter(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    ) {

        // Holds all the texts composable
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Title
            Text(
                text = "Heart Rate",

                modifier = Modifier
                    .padding(vertical = 2.dp),

                // Text Features
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = decoration.textColor
            )

            // Item and Value
            Text(
                text = "120/80 mmhg",

                modifier = Modifier
                    .padding(vertical = 2.dp),

                // Text Features
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.W800,
                color = decoration.textColor
            )

            // Item and Value
            Text(
                text = "Normal",

                modifier = Modifier
                    .padding(vertical = 2.dp),

                // Text Features
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = decoration.textColor
            )
        }
    }
}