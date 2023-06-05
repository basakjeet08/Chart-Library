package com.dev.anirban.chartlibrary.library.circular.foreground

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularForegroundInterface

/**
 * This class implements the [CircularForegroundInterface] which is responsible for making the
 * foreground reading of the chart
 *
 */
class RingChartForeground : CircularForegroundInterface {

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
        val radius = (size.width / 4).coerceAtMost(size.height / 4) * 1.5f

        val arcRect = Rect(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius
        )

        //This function draws the Background Arc
        drawArc(
            color = Color.LightGray.copy(alpha = .2f),
            startAngle = 120f,
            sweepAngle = 300f,
            useCenter = false,
            size = arcRect.size,
            style = Stroke(
                width = 30f,
                cap = StrokeCap.Round
            ),
            topLeft = arcRect.topLeft
        )

        // This is used to define the sweep angle of each and every Floating Data
        val startingAngle = 120f

        //This function draws the Foreground Arc
        drawArc(
            brush = Brush.sweepGradient(colors = decoration.colorList),
            startAngle = startingAngle,
            sweepAngle = circularData.sweepAngles.first(),
            useCenter = false,
            size = arcRect.size,
            style = Stroke(
                width = 30f,
                cap = StrokeCap.Round
            ),
            topLeft = arcRect.topLeft
        )
    }
}