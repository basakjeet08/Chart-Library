package com.dev.anirban.chartlibrary.linear

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.linear.colorconvention.LinearDefaultColorConvention
import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.linear.interfaces.LinearChartInterface
import com.dev.anirban.chartlibrary.linear.interfaces.LinearColorConventionInterface
import com.dev.anirban.chartlibrary.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.linear.interfaces.LinearMarginInterface
import com.dev.anirban.chartlibrary.linear.interfaces.LinearPlotInterface
import com.dev.anirban.chartlibrary.linear.margins.LinearMargin
import com.dev.anirban.chartlibrary.linear.plots.LinearBarPlot
import com.dev.anirban.chartlibrary.linear.plots.LinearLinePlot

/**
 * This is the base class which directly implements the [LinearDataInterface] interfaces.
 *
 * @param margin This is the implementation for drawing the Margins
 * @param decoration This is the implementation for drawing the Decorations
 * @param linearData This is the implementation for keeping the Linear Chart data and calculations
 * @param plot This is the implementation for how shall the plotting be drawn on the graph
 * @param colorConvention This is the implementation for how we are  going to draw all the color
 * conventions in the graph
 */
open class LinearChart(
    override val margin: LinearMarginInterface,
    override val decoration: LinearDecoration,
    override val linearData: LinearDataInterface,
    override val plot: LinearPlotInterface,
    override val colorConvention: LinearColorConventionInterface
) : LinearChartInterface {

    /**
     * This function draws the margins according to the margin implementation passed to it
     */
    override fun DrawScope.drawMargin() {
        margin.apply {
            drawMargin(
                linearData = linearData,
                decoration = decoration
            )
        }
    }

    /**
     * This function draws the plotting of the chart
     */
    override fun DrawScope.plotChart() {
        plot.apply {
            plotChart(
                linearData = linearData,
                decoration = decoration
            )
        }
    }

    /**
     * This function draws the Color Conventions of the Chart
     */
    @Composable
    override fun DrawColorConvention() {
        colorConvention.DrawColorConventions(
            decoration = decoration
        )
    }

    /**
     * This is the Build Function which starts composing the Charts and composes the Charts
     *
     * @param modifier This is for default modifications to be passed from the parent Class
     */
    @Composable
    override fun Build(modifier: Modifier) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, bottom = 18.dp, end = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .drawBehind {

                        // Calling all the necessary functions
                        linearData.apply {
                            doCalculations(size = size)
                        }
                        drawMargin()
                        plotChart()

                    }
            )

            // Checking if the implementation is the default one
            if (colorConvention !is LinearDefaultColorConvention) {
                Spacer(modifier = Modifier.height(16.dp))

                // Draws the color conventions for the chart
                DrawColorConvention()
            }
        }
    }

    /**
     * Builder Composable Functions which makes the objects of [LinearChart] and these are
     * actually called by the users to make charts
     */
    companion object {

        /**
         * This function creates an object of the LinearChart which draws a basic Line chart
         * It can draw Single Line Charts as well as multiple Line Charts
         *
         * @param modifier This is to be passed from the Parent Class for the modifications
         * @param margin This is the implementation for drawing the Margins
         * @param decoration This is the implementation for drawing the Decorations
         * @param linearData This is the implementation for keeping the Linear Chart data and calculations
         * @param plot This is the implementation for how shall the plotting be drawn on the graph
         * @param colorConvention This is the implementation for how we are going to draw all the
         * color conventions in the graph
         */
        @Composable
        fun LineChart(
            modifier: Modifier = Modifier,
            margin: LinearMarginInterface = LinearMargin(),
            decoration: LinearDecoration = LinearDecoration.lineDecorationColors(),
            linearData: LinearDataInterface,
            plot: LinearPlotInterface = LinearLinePlot(),
            colorConvention: LinearColorConventionInterface = LinearDefaultColorConvention()
        ) = LinearChart(
            margin = margin,
            decoration = decoration,
            linearData = linearData,
            plot = plot,
            colorConvention = colorConvention
        ).Build(modifier = modifier)

        /**
         * This function creates an object of the LinearChart which draws a basic Bar chart
         *
         * @param modifier This is to be passed from the Parent Class for the modifications
         * @param margin This is the implementation for drawing the Margins
         * @param decoration This is the implementation for drawing the Decorations
         * @param linearData This is the implementation for keeping the Linear Chart data and calculations
         * @param plot This is the implementation for how shall the plotting be drawn on the graph
         * @param colorConvention This is the implementation for how we are going to draw all
         * the color conventions in the graph
         */
        @Composable
        fun BarChart(
            modifier: Modifier = Modifier,
            margin: LinearMarginInterface = LinearMargin(),
            decoration: LinearDecoration = LinearDecoration.barDecorationColors(),
            linearData: LinearDataInterface,
            plot: LinearPlotInterface = LinearBarPlot(),
            colorConvention: LinearColorConventionInterface = LinearDefaultColorConvention()
        ) = LinearChart(
            margin = margin,
            decoration = decoration,
            linearData = linearData,
            plot = plot,
            colorConvention = colorConvention
        ).Build(modifier = modifier)
    }
}