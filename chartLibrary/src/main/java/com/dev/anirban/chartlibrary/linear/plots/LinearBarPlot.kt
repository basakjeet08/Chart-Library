package com.dev.anirban.chartlibrary.linear.plots

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.linear.interfaces.LinearPlotInterface

/**
 * This is the Line Plot class which implements the [LinearPlotInterface] Interface and makes a bar
 * Chart
 *
 * @param barWidth This defines the width of the bars of the bar Chart
 * @param cornerRadius This defines the radius of curve of the corners of the bars
 */
class LinearBarPlot(
    private val barWidth: Float = 30f,
    private val cornerRadius: Float = 12f
) : LinearPlotInterface {

    /**
     * This function plots the Bar Chart in the canvas
     *
     * @param linearData This is the data object which contains the data of the whole graph
     * @param decoration This object contains the decorations for the chart
     */
    override fun DrawScope.plotChart(
        linearData: LinearDataInterface,
        decoration: LinearDecoration
    ) {

        // Adding the Offsets to the Variable
        linearData.yAxisReadings.forEach { coordinateSet ->

            coordinateSet.forEach { point ->

                // This function draws the Bars
                drawRoundRect(
                    brush = Brush.verticalGradient(
                        listOf(
                            decoration.plotPrimaryColor.first(),
                            decoration.plotPrimaryColor.last()
                        )
                    ),
                    topLeft = Offset(
                        x = point.xCoordinate - barWidth / 2f,
                        y = point.yCoordinate
                    ),
                    size = Size(
                        width = barWidth,
                        height = linearData.yMarkerList[linearData.yMarkerList.size - 1].yCoordinate - point.yCoordinate - 12f
                    ),
                    cornerRadius = CornerRadius(cornerRadius)
                )
            }
        }
    }
}