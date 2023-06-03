package com.dev.anirban.chartlibrary.library.circular.colorconvention

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface

/**
 * This class is the implementation of [CircularColorConventionInterface] which provides the
 * implementations for drawing the color conventions in the canvas
 */
class GridColorConvention : CircularColorConventionInterface {

    /**
     * This function draws the individual chart details or we can say the color codes along with
     * the text.
     *
     * @param text This is the text that would be shown before the value
     * @param value This is the value
     * @param color to be shown for this color convention
     */
    @Composable
    fun ChartDetail(
        text: String = "Normal - 7.5 hrs",
        value: Float,
        color: Color = Color.Blue
    ) {

        Row(
            modifier = Modifier
                .padding(bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Drawing the small circles(color codes)
            Canvas(
                modifier = Modifier
                    .padding(4.dp)
                    .size(20.dp)
            ) {

                drawRoundRect(
                    color = color,
                    cornerRadius = CornerRadius(12f)
                )
            }

            Spacer(modifier = Modifier.width(4.dp))

            // This is the output to be shown to the users
            val textToShow = "$text - " + if (value >= 60) {
                "${value / 60.0f} hrs"
            } else {
                "$value min"
            }

            // Item Value
            Text(
                text = textToShow,

                // Text Features
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
        }
    }


    /**
     * This function draws the color conventions in the canvas
     *
     * @param circularData This object contains the data of the graph
     * @param decoration THis object contains the decorations of the graph
     */
    @Composable
    override fun DrawColorConventions(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    ) {

        // This contains the Color Conventions in the left side
        Column(
            modifier = Modifier
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {

            // Drawing Left column with the conventions
            for (index in circularData.itemsList.indices step 2) {

                // This function draws one of the color code Item details
                ChartDetail(
                    text = circularData.itemsList[index].first,
                    value = circularData.itemsList[index].second,
                    color = decoration.colorList[index]
                )
            }
        }

        // This contains the Color Conventions in the right side
        Column(
            modifier = Modifier
                .padding(4.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {

            // Drawing Right column with the conventions
            for (index in 1 until circularData.itemsList.size step 2) {

                // This function draws one of the color code Item details
                ChartDetail(
                    text = circularData.itemsList[index].first,
                    value = circularData.itemsList[index].second,
                    color = decoration.colorList[index]
                )
            }
        }
    }
}