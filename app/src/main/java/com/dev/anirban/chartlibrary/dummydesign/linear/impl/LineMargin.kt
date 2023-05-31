package com.dev.anirban.chartlibrary.dummydesign.linear.impl

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartDecoration
import com.dev.anirban.chartlibrary.dummydesign.linear.LinearData
import com.dev.anirban.chartlibrary.dummydesign.linear.MarginInterface

class LineMargin<T> : MarginInterface<T> {


    override fun DrawScope.drawMargins(
        linearData: LinearData<T>,
        lineChartDecoration: LineChartDecoration
    ) {


        for (i in 1..linearData.numOfYMarkers) {

            // This is the value of the current Y Axis Marker
            val currentYMarker = linearData.yUpperReading - (i - 1) * linearData.yDividend

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                currentYMarker.toString(),
                linearData.xOrigin - 24f,
                (linearData.yScale * i) + 12f,
                Paint().apply {
                    color = lineChartDecoration.textColor
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
                currentMarker.toString(),
                linearData.xScale * (index + 1),
                linearData.yScale * (linearData.numOfYMarkers + 1),
                Paint().apply {
                    color = lineChartDecoration.textColor
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.LEFT
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )
        }
    }
}