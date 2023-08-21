package com.dev.anirban.chartlibrary.other.bmi.margins

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiDataInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiMarginInterface


/**
 * This is one of the implementations of the [BmiMarginInterface] and it provides with a
 * implementation of how we should draw the Margin for this chart
 *
 * @see [BmiMarginInterface]
 */
class BmiMargin : BmiMarginInterface {


    /**
     * This is the function which contains the actual margin implementation
     *
     * @param bmiData This is the data of the Chart
     * @param decoration THis is the decoration of the function
     */
    override fun DrawScope.drawMargin(
        bmiData: BmiDataInterface,
        decoration: BmiDecorations
    ) {

        // This draws the Linear Horizontal gradient bar which acts as a reading margin for the graph
        drawRoundRect(
            brush = Brush.horizontalGradient(decoration.barGradientColors),
            topLeft = Offset(
                x = bmiData.xAxisPointers[0].xCoordinate,
                y = bmiData.xAxisPointers[0].yCoordinate - 90f
            ),
            size = Size(
                width = size.width,
                height = 35f
            ),
            cornerRadius = CornerRadius(12f)
        )


        // This Draws the Y Markers below the Graph
        bmiData.xAxisPointers.forEach { currentMarker ->

            // This draws the String Marker
            drawContext.canvas.nativeCanvas.drawText(
                currentMarker.value.toString(),
                currentMarker.xCoordinate,
                currentMarker.yCoordinate,
                Paint().apply {
                    color = decoration.textColor.toArgb()
                    textSize = 12.sp.toPx()
                    textAlign = Paint.Align.CENTER
                    typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
                }
            )
        }
    }
}