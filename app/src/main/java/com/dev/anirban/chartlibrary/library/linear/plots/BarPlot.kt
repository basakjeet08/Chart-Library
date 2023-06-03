package com.dev.anirban.chartlibrary.library.linear.plots

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.dev.anirban.chartlibrary.library.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.library.linear.interfaces.LinearDecorationInterface
import com.dev.anirban.chartlibrary.library.linear.interfaces.PlottingInterface

class BarPlot : PlottingInterface {

    /**
     * This function plots the Bar Chart in the canvas
     *
     * @param linearData This is the data object which contains the data of the whole graph
     * @param decoration This object contains the decorations for the chart
     */
    override fun DrawScope.plotChart(
        linearData: LinearDataInterface,
        decoration: LinearDecorationInterface
    ) {

        // Adding the Offsets to the Variable
        linearData.yAxisReadings.forEach { coordinateSet ->

            coordinateSet.forEach { point ->

                // This function draws the Bars
                drawRoundRect(
                    brush = Brush.verticalGradient(
                        listOf(
                            decoration.plotPrimaryColor.first(),
                            decoration.plotPrimaryColor.first().copy(alpha = .15f)
                        )
                    ),
                    topLeft = Offset(
                        x = point.xCoordinate - 8f,
                        y = point.yCoordinate
                    ),
                    size = Size(
                        width = 30f,
                        height = linearData.yMarkerList[linearData.yMarkerList.size - 1].yCoordinate - point.yCoordinate - 12f
                    ),
                    cornerRadius = CornerRadius(12f)
                )
            }
        }
    }
}