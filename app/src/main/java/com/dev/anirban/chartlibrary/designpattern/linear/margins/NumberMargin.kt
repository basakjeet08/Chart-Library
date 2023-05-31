package com.dev.anirban.chartlibrary.designpattern.linear.margins

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.designpattern.linear.data.LineData
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearDecorationInterface
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.MarginInterface

/**
 * This is one of the implementations of the [MarginInterface] and it provides with a implementation
 * of how we should draw the Margin
 */
class NumberMargin : MarginInterface {

    /**
     * This is the function which contains the actual margin implementation
     *
     * @param linearData This is the data of the Line Chart
     * @param decoration THis is the decoration of the function
     */
    override fun DrawScope.drawMargin(
        linearData: LinearDataInterface,
        decoration: LinearDecorationInterface
    ) {

        // Checking if the passed object is a LineData
        if (linearData !is LineData)
            return

        for (i in 1..linearData.numOfYMarkers) {

            // This is the value of the current Y Axis Marker
            val currentYMarker = linearData.yUpperReading - (i - 1) * linearData.yDividend

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                currentYMarker.toString(),
                linearData.xOrigin - 24f,
                (linearData.yScale * i) + 12f,
                Paint().apply {
                    color = decoration.textColor
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.LEFT
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )

            // This draws the Lines for the readings parallel to X Axis
            drawLine(
                start = Offset(
                    x = linearData.xOrigin + 24f,
                    y = linearData.yScale * i
                ),
                color = Color.Gray,
                end = Offset(
                    x = linearData.xMax,
                    y = linearData.yScale * i
                ),
                strokeWidth = 1f
            )
        }

        // This Draws the Y Markers below the Graph
        linearData.xAxisReadings.forEachIndexed { index, currentMarker ->

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                currentMarker,
                linearData.xScale * (index + 1),
                linearData.yScale * (linearData.numOfYMarkers + 1),
                Paint().apply {
                    color = decoration.textColor
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.LEFT
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )
        }
    }
}