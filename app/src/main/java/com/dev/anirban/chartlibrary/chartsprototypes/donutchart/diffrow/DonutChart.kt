package com.dev.anirban.chartlibrary.chartsprototypes.donutchart.diffrow

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Default Preview for the Chart
@Preview
@Composable
private fun DefaultPreview() {
    DifferentRowDonutChart()
}

// Chart Item List
private val itemValues = listOf(
    450,
    180,
    30,
    60
)

private val itemNames = listOf(
    "Normal",
    "Deep",
    "Delay",
    "Distributed"
)

// Chart Color List
private val colorList = listOf(
    Color.Blue,
    Color.Green,
    Color.Yellow,
    Color.Red
)

// List of sweep angles which will be calculated
private val sweepAngles: MutableList<Float> = mutableListOf()

/**
 * This function makes the Donut Chart with the chart details below it
 */
@Composable
fun DifferentRowDonutChart() {

    // This function calculates the sweep angles of the points and stores them in sweepAngles List
    calculate()

    // Main UI for the Donut Chart
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Canvas which contains the Donut chart
        Canvas(
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        ) {

            // Component Size or the size of the part of canvas where we can draw the donut chart
            val componentSize = size / 1.7f

            // This function draws the Donut Chart
            drawCircle(
                componentSize = componentSize,
                sweepAngles = sweepAngles,
                colorList = colorList
            )
        }

        // This function draws the chart Color Codes
        ChartColorCode()
    }
}

/**
 * This function calculates the sweep angles of the points and stores them in sweepAngles List
 */
fun calculate() {

    // Total of the Data
    var total = 0f

    // Calculating Total
    itemValues.forEach {
        total += it
    }

    // Calculating the SweepAngles
    itemValues.forEach { fl ->

        val percentage = (fl / total)

        /**
         * some value is subtracted because according to the UI there shall be some free space
         * between each graph.
         *
         * Free Space = Some Angles shall be subtracted so that
         *
         * We are taking a 4f minus between each and every Floating Data
         */
        val angle = percentage * (360f - (itemValues.size * 4f))
        sweepAngles.add(angle)
    }

}

/**
 * This function draws the circle/ Donut Chart to be shown according to the sweep angles
 */
fun DrawScope.drawCircle(
    componentSize: Size,
    sweepAngles: List<Float>,
    colorList: List<Color>
) {
    // This is used to define the sweep angle of each and every Floating Data
    var currentSweepAngle = 270f

    // Drawing all the arcs
    sweepAngles.forEachIndexed { index, fl ->

        //This function draws the Arc
        drawArc(
            color = colorList[index],
            startAngle = currentSweepAngle,
            sweepAngle = fl,
            useCenter = false,
            size = componentSize,
            style = Stroke(
                width = 45f
            ),
            topLeft = Offset(
                x = (size.width - componentSize.width) / 2f,
                y = (size.height - componentSize.height) / 2f
            )
        )

        // Marking the sweep angle for the next Floating Item
        currentSweepAngle += fl + 4f
    }
}

/**
 * This function draws the Chart Color Codes
 */
@Composable
fun ChartColorCode() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {

            for (i in itemNames.indices step 2) {

                // This function draws one of the color code Item details
                ChartDetail(
                    text = itemNames[i],
                    value = itemValues[i],
                    color = colorList[i]
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(4.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {

            for (i in 1 until itemNames.size step 2) {

                // This function draws one of the color code Item details
                ChartDetail(
                    text = itemNames[i],
                    value = itemValues[i],
                    color = colorList[i]
                )
            }
        }
    }
}


/**
 * This function draws the individual chart details or we can say the color codes along with the text
 */
@Composable
fun ChartDetail(
    text: String = "Normal - 7.5 hrs",
    value: Int = 20,
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

            // This function draws the Color codes circles
            drawCircle(
                color,
                radius = 20f,
                center = size.center
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        // This is the output to be shown to the users
        val textToShow = "$text - " + if (value >= 60) {
            "${value.toFloat() / 60.0f} hrs"
        } else {
            "$value min"
        }

        Text(
            text = textToShow,
            fontSize = 14.sp
        )
    }
}