package com.dev.anirban.chartlibrary.library.circular.colorconvention

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.center
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
class ListColorConvention : CircularColorConventionInterface {

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

        // This contains the Color Conventions
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Drawing the Color Code and writing the Text of the UI
            circularData.itemsList.forEachIndexed { index, pair ->
                DrawConvention(
                    index = index,
                    pair = pair,
                    decoration = decoration
                )
            }
        }
    }

    /**
     * This function draws individual Color Convention
     */
    @Composable
    private fun DrawConvention(
        index: Int,
        pair: Pair<String, Float>,
        decoration: CircularDecoration
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Drawing the small circles(color codes)
            Canvas(
                modifier = Modifier
                    .padding(4.dp)
                    .size(20.dp)
            ) {

                // This function draws the Color codes circles
                drawCircle(
                    decoration.colorList[index],
                    radius = 20f,
                    center = size.center
                )
            }

            // Checking if the data should be displayed in SI unit or Cgs
            val value =
                if (pair.second >= 1000) pair.second / 1000.0f else pair.second.toInt()
            val reconsideredUnit = if (pair.second >= 1000) "L" else "unit"

            // Item Value
            Text(
                text = "${pair.first} - $value $reconsideredUnit",

                // Text Features
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500
            )
        }
    }
}