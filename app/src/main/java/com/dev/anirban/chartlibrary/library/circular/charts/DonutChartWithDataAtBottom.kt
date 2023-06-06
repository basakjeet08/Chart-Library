package com.dev.anirban.chartlibrary.library.circular.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.library.circular.CircularChart
import com.dev.anirban.chartlibrary.library.circular.center.CircularDefaultCenter
import com.dev.anirban.chartlibrary.library.circular.colorconvention.GridColorConvention
import com.dev.anirban.chartlibrary.library.circular.data.CircularListData
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.library.circular.foreground.DonutChartForeground
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularForegroundInterface

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
class DonutChartWithDataAtBottom(
    override val circularCenter: CircularCenterInterface,
    override val circularData: CircularDataInterface,
    override val circularDecoration: CircularDecoration,
    override val circularForeground: CircularForegroundInterface,
    override val circularColorConvention: CircularColorConventionInterface
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
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Donut Chart
            Box(
                modifier = modifier
                    .size(180.dp)
                    .drawBehind {

                        // Calling all the necessary functions
                        doCalculations()
                        drawForeground()
                    },
                contentAlignment = Alignment.Center
            ) {

                // Draws the Center of the chart
                DrawCenter()
            }

            // Color Conventions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                // Calling all the necessary functions
                super.DrawColorConventions()
            }
        }
    }


    /**
     * Builder Composable Functions which makes the objects of [DonutChartWithDataAtBottom] and these are
     * actually called by the users to make charts
     */
    companion object {

        /**
         * This function creates an object of the [DonutChartWithDataAtBottom] which draws a basic
         * donut chart with its color conventions drawn at bottom
         *
         * @param circularCenter This is the implementation which draws the center of the circle
         * @param circularData This is the data class implementation which handles the data
         * @param circularDecoration This is the decorations for the Circular Chart
         * @param circularForeground This is the implementation which draws the foreground of the chart
         * @param circularColorConvention This is the color Convention implementation of the chart
         */
        @Composable
        fun ColumnDonutChart(
            modifier: Modifier = Modifier,
            circularCenter: CircularCenterInterface = CircularDefaultCenter(),
            circularData: CircularListData,
            circularDecoration: CircularDecoration = CircularDecoration.donutChartDecorations(),
            circularForeground: CircularForegroundInterface = DonutChartForeground(),
            circularColorConvention: CircularColorConventionInterface = GridColorConvention()
        ) {
            DonutChartWithDataAtBottom(
                circularCenter = circularCenter,
                circularData = circularData,
                circularForeground = circularForeground,
                circularDecoration = circularDecoration,
                circularColorConvention = circularColorConvention
            ).Build(
                modifier = modifier
            )
        }
    }
}