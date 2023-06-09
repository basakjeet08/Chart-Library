package com.dev.anirban.chartlibrary.circular.foreground

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularForegroundInterface

/**
 * This class implements the [CircularForegroundInterface] which is responsible for making the
 * foreground reading of the chart
 *
 */
class DonutTargetChartForeground : CircularForegroundInterface {

    /**
     * This is the function which draws all the readings
     *
     * @param circularData This is the data of the chart
     * @param decoration This is the decoration of the chart
     */
    override fun DrawScope.drawForeground(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    ) {

        val centerX = size.width / 2
        val centerY = size.height / 2
        val radius = (size.width / 4).coerceAtMost(size.height / 4) * 1.2f

        val arcRect = Rect(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius
        )

        //This function draws the Background Arc
        drawArc(
            color = Color.LightGray.copy(alpha = .2f),
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            size = arcRect.size,
            style = Stroke(
                width = 45f
            ),
            topLeft = arcRect.topLeft
        )

        // This is used to define the sweep angle of each and every Floating Data
        var currentSweepAngle = 270f

        // Drawing all the arcs
        circularData.sweepAngles.forEachIndexed { index, fl ->

            //This function draws the Foreground Arc
            drawArc(
                color = decoration.colorList[index],
                startAngle = currentSweepAngle,
                sweepAngle = fl,
                useCenter = false,
                size = arcRect.size,
                style = Stroke(
                    width = 45f
                ),
                topLeft = arcRect.topLeft
            )

            // Marking the sweep angle for the next Floating Item
            currentSweepAngle += fl + 4f
        }
    }
}