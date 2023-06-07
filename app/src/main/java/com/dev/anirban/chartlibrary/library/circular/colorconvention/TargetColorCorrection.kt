package com.dev.anirban.chartlibrary.library.circular.colorconvention

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
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface

/**
 * This class is the implementation of [CircularColorConventionInterface] which provides the
 * implementations for drawing the color conventions in the canvas
 */
class TargetColorCorrection : CircularColorConventionInterface {

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

            listOf(
                Pair("Target", circularData.target),
                Pair("Achieved", circularData.achieved)
            ).forEach {

                // This is the converted Value which is to be shown for SI Unit
                val convertedValue = circularData.conversionRate(it.second)

                // This is the output to be shown to the user
                val textToShow = "${it.first} - " + if (convertedValue < 1f)
                    "${it.second} ${circularData.cgsUnit}"
                else
                    "$convertedValue ${circularData.siUnit}"

                // Item and Value
                Text(
                    text = textToShow,

                    modifier = Modifier
                        .padding(vertical = 4.dp),

                    // Text Features
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = decoration.textColor
                )
            }
        }
    }
}