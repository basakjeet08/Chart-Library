package com.dev.anirban.chartlibrary.designpattern.circular.charts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.designpattern.circular.CircularChart
import com.dev.anirban.chartlibrary.designpattern.circular.center.CircularDefaultCenter
import com.dev.anirban.chartlibrary.designpattern.circular.colorconvention.ListColorConvention
import com.dev.anirban.chartlibrary.designpattern.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.designpattern.circular.interfaces.CircularForegroundInterface

/**
 * This class is the sub - class of [CircularChart] class which is the root parent class of the
 * circular charts.
 *
 * This class in general provides an implementation for a donut chart which has its color conventions
 * in the same row as itself.
 *
 * @param circularCenter This is the implementation which draws the center of the circle
 * @param circularData This is the data class implementation which handles the data
 * @param circularDecoration This is the decorations for the Circular Chart
 * @param circularForeground This is the implementation which draws the foreground of the chart
 * @param circularColorConvention This is the color Convention implementation of the chart
 */
class RowDonutChart(
    override val circularCenter: CircularCenterInterface = CircularDefaultCenter(),
    override val circularData: CircularDataInterface,
    override val circularDecoration: CircularDecoration,
    override val circularForeground: CircularForegroundInterface,
    override val circularColorConvention: CircularColorConventionInterface = ListColorConvention()
) : CircularChart(
    circularCenter,
    circularData,
    circularDecoration,
    circularForeground,
    circularColorConvention
) {

    /**
     * This is the build function which starts building the Chart in the canvas and all the other
     * components of the chart
     *
     * @param modifier This is kept so that the programmer can provide his default custom modifier
     */
    @Composable
    override fun Build(modifier: Modifier) {

        // Making a row to fit the canvas and the color conventions
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            // Donut Chart
            Canvas(
                modifier = modifier
                    .weight(1f)
                    .size(180.dp)
            ) {

                // Calling all the necessary functions
                doCalculations()
                drawForeground()
            }

            // Color Conventions
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {

                // Calling all the necessary functions
                super.DrawColorConventions()
            }
        }
    }
}