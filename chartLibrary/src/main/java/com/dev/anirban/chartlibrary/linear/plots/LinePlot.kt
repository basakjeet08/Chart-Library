package com.dev.anirban.chartlibrary.linear.plots

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.linear.interfaces.PlottingInterface

/**
 * This is the Line Plot class which implements the [PlottingInterface] Interface and makes a Line
 * Chart
 *
 * @param lineStroke This defines the stroke of the line
 * @param circleRadius This defines the radius of curve of the Circle
 */
class LinePlot(
    private val lineStroke: Float = 3f,
    private val circleRadius: Float = 6f
) : PlottingInterface {

    /**
     * This is the function which contains the actual margin implementation
     *
     * @param linearData This is the data of the Line Chart
     * @param decoration THis is the decoration of the function
     */
    override fun DrawScope.plotChart(
        linearData: LinearDataInterface,
        decoration: LinearDecoration
    ) {

        // This variable contains all the Offset of all the graph coordinates
        val graphCoordinatesList: MutableList<MutableList<Offset>> = mutableListOf()

        // Adding the Offsets to the Variable
        linearData.yAxisReadings.forEachIndexed { coordinateSetIndex, coordinateSet ->

            // Calculates the coordinate of One Set of the List
            val graphCoordinates: MutableList<Offset> = mutableListOf()

            coordinateSet.forEach { point ->

                // Adding the Coordinates of points in the same Set
                graphCoordinates.add(
                    point.getOffset()
                )
            }

            // Adding the coordinates of a whole Set in one Index of the Graph
            graphCoordinatesList.add(
                coordinateSetIndex,
                graphCoordinates
            )
        }

        // This loop makes the curved line between two points
        for (i in 0 until graphCoordinatesList.size) {

            // Path Variable
            val path = Path()

            // This is the current coordinate set
            val coordinates = graphCoordinatesList[i]

            // Moving to the start path of the the coordinate set to start making the Curved lines
            path.moveTo(
                coordinates[0].x,
                coordinates[0].y
            )

            // Inner Loop which draws the Lines from point to point of a single coordinate sets
            for (index in 0 until coordinates.size - 1) {

                // Control Points
                val control1X = (coordinates[index].x + coordinates[index + 1].x) / 2f
                val control1Y = coordinates[index].y
                val control2X = (coordinates[index].x + coordinates[index + 1].x) / 2f
                val control2Y = coordinates[index + 1].y

                // Defining the path from the last stayed to the next point
                path.cubicTo(
                    x1 = control1X,
                    y1 = control1Y,
                    x2 = control2X,
                    y2 = control2Y,
                    x3 = coordinates[index + 1].x,
                    y3 = coordinates[index + 1].y
                )
            }

            // Drawing path after defining all the points of a single coordinate set in the path
            drawPath(
                path = path,
                color = decoration.plotPrimaryColor[i],
                style = Stroke(
                    width = lineStroke
                )
            )
        }

        // This loop draws the circles or the points of the coordinates1
        graphCoordinatesList.forEachIndexed { index, offsets ->
            offsets.forEach {
                // This function draws the Circle points
                drawCircle(
                    color = decoration.plotSecondaryColor[index],
                    radius = circleRadius,
                    center = it
                )
            }
        }
    }
}