package com.dev.anirban.chartlibrary.chartsprototypes.ringchart

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun DefaultPreview() {
    RingChart()
}

// Chart Item List
private const val itemValues = 500

// Chart Color List
private val colorList = listOf(
    Color.Blue,
    Color.Yellow,
    Color.Green,
    Color.Blue
)

/**
 * This function draws the Ring chart and is the starting point of the Chart
 */
@Composable
fun RingChart() {

    // Main UI for the Donut Chart
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier,
            contentAlignment = Alignment.Center
        ) {

            // Center Texts are being shown like this
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "AQI",
                    fontSize = 14.sp
                )
                Text(
                    "193",
                    fontSize = 14.sp
                )
                Text(
                    "Moderate",
                    fontSize = 14.sp
                )
            }

            // Canvas which contains the Donut chart
            Canvas(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp)
            ) {

                // Component Size or the size of the part of canvas where we can draw the donut chart
                val componentSize = size / 1.2f

                // These functions draws the Ring Chart and its readings
                drawBackground(componentSize = componentSize)
                drawRing(componentSize = componentSize)
                drawOthers(componentSize = componentSize)
            }
        }
    }
}

/**
 * THis function draws the Ring Chart foreground
 */
fun DrawScope.drawRing(
    componentSize: Size
) {

    // This is the angle by which the chart shall be filled
    val sweepAngle = (itemValues.toFloat() / 500f) * 300f

    //This function draws the Arc
    drawArc(
        brush = Brush.sweepGradient(colors = colorList),
        startAngle = 120f,
        sweepAngle = sweepAngle,
        useCenter = false,
        size = componentSize,
        style = Stroke(
            width = 30f,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )

}

/**
 * This is the function which draws a Gray Background in the chart to denote unfilled portion
 */
fun DrawScope.drawBackground(
    componentSize: Size
) {

    //This function draws the Arc
    drawArc(
        color = Color.Gray,
        startAngle = 120f,
        sweepAngle = 300f,
        useCenter = false,
        size = componentSize,
        style = Stroke(
            width = 30f,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

/**
 * This function draws the reading texts of starting reading and the ending reading
 */
fun DrawScope.drawOthers(
    componentSize: Size
) {

    // padding or we can say these are the origin points of the component
    val xPadding = (size.width - componentSize.width) / 2f
    val yPadding = (size.height - componentSize.height) / 2f

    // This draws the Left String Reading
    drawContext.canvas.nativeCanvas.drawText(
        "0",
        xPadding,
        size.height - yPadding,
        Paint().apply {
            color = Color.White.toArgb()
            textSize = 12.sp.toPx()
            textAlign = Paint.Align.LEFT
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        }
    )

    // This draws the Right String Reading
    drawContext.canvas.nativeCanvas.drawText(
        "500",
        size.width - xPadding - 32f,
        size.height - yPadding,
        Paint().apply {
            color = Color.White.toArgb()
            textSize = 12.sp.toPx()
            textAlign = Paint.Align.LEFT
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
        }
    )
}