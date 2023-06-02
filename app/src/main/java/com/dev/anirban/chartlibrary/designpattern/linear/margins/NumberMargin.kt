package com.dev.anirban.chartlibrary.designpattern.linear.margins

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.designpattern.linear.data.LinearData
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
        if (linearData !is LinearData)
            return

        linearData.yMarkerList.forEach { point ->

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                point.value.toString(),
                point.xCoordinate,
                point.yCoordinate,
                Paint().apply {
                    color = decoration.textColor.toArgb()
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.LEFT
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )

            // This draws the Lines for the readings parallel to X Axis
            drawLine(
                start = Offset(
                    x = 24f,
                    y = point.yCoordinate - 12f
                ),
                color = decoration.textColor.copy(alpha = 0.8f),
                end = Offset(
                    x = size.width,
                    y = point.yCoordinate - 12f
                ),
                strokeWidth = 1f
            )
        }

        // This Draws the Y Markers below the Graph
        linearData.xAxisReadings.forEach { currentMarker ->

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                currentMarker.value,
                currentMarker.xCoordinate,
                currentMarker.yCoordinate,
                Paint().apply {
                    color = decoration.textColor.toArgb()
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.LEFT
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )
        }
    }
}