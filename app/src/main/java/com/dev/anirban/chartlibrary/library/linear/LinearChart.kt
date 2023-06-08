package com.dev.anirban.chartlibrary.library.linear

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.library.linear.colorconvention.DefaultColorConvention
import com.dev.anirban.chartlibrary.library.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.library.linear.interfaces.LinearChartInterface
import com.dev.anirban.chartlibrary.library.linear.interfaces.LinearColorConventionInterface
import com.dev.anirban.chartlibrary.library.linear.interfaces.LinearDataInterface
import com.dev.anirban.chartlibrary.library.linear.interfaces.MarginInterface
import com.dev.anirban.chartlibrary.library.linear.interfaces.PlottingInterface
import com.dev.anirban.chartlibrary.library.linear.margins.NumberMargin
import com.dev.anirban.chartlibrary.library.linear.plots.BarPlot
import com.dev.anirban.chartlibrary.library.linear.plots.LinePlot

/**
 * This is the base class which directly implements the [LinearDataInterface] interfaces.
 *
 * @param margin This is the implementation for drawing the Margins
 * @param decoration This is the implementation for drawing the Decorations
 * @param linearData This is the implementation for keeping the Linear Chart data and calculations
 * @param plotting This is the implementation for how shall the plotting be drawn on the graph
 * @param colorConvention This is the implementation for how we are  going to draw all the color
 * conventions in the graph
 */
open class LinearChart(
    override val margin: MarginInterface,
    override val decoration: LinearDecoration,
    override val linearData: LinearDataInterface,
    override val plotting: PlottingInterface,
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
        plotting.apply {
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
     * @param chartTitle This is the title of the chart
     */
    @Composable
    override fun Build(
        modifier: Modifier,
        chartTitle: String
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, bottom = 18.dp, end = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Checking if any chart title is passed
            if (chartTitle.isNotBlank()) {

                // Chart Title
                Text(
                    text = chartTitle,

                    modifier = Modifier
                        .fillMaxWidth(),

                    // Text Features
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = decoration.textColor,
                )

                Spacer(modifier = Modifier.height(32.dp))
            }

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .drawBehind {

                        // Calling all the necessary functions
                        linearData.doCalculations(size)
                        drawMargin()
                        plotChart()

                    }
            )

            // Checking if the implementation is the default one
            if (colorConvention !is DefaultColorConvention) {
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
         * @param chartTitle This is the title of the Whole Chart
         * @param margin This is the implementation for drawing the Margins
         * @param decoration This is the implementation for drawing the Decorations
         * @param linearData This is the implementation for keeping the Linear Chart data and calculations
         * @param plotting This is the implementation for how shall the plotting be drawn on the graph
         * @param colorConvention This is the implementation for how we are going to draw all the
         * color conventions in the graph
         */
        @Composable
        fun LineChart(
            modifier: Modifier = Modifier,
            chartTitle: String,
            margin: MarginInterface = NumberMargin(),
            decoration: LinearDecoration = LinearDecoration.lineDecorationColors(),
            linearData: LinearDataInterface,
            plotting: PlottingInterface = LinePlot(),
            colorConvention: LinearColorConventionInterface = DefaultColorConvention()
        ) = LinearChart(
            margin = margin,
            decoration = decoration,
            linearData = linearData,
            plotting = plotting,
            colorConvention = colorConvention
        ).Build(
            modifier = modifier,
            chartTitle = chartTitle
        )

        /**
         * This function creates an object of the LinearChart which draws a basic Bar chart
         *
         * @param modifier This is to be passed from the Parent Class for the modifications
         * @param chartTitle This is the title of the Whole Chart
         * @param margin This is the implementation for drawing the Margins
         * @param decoration This is the implementation for drawing the Decorations
         * @param linearData This is the implementation for keeping the Linear Chart data and calculations
         * @param plotting This is the implementation for how shall the plotting be drawn on the graph
         * @param colorConvention This is the implementation for how we are going to draw all
         * the color conventions in the graph
         */
        @Composable
        fun BarChart(
            modifier: Modifier = Modifier,
            chartTitle: String,
            margin: MarginInterface = NumberMargin(),
            decoration: LinearDecoration = LinearDecoration.barDecorationColors(),
            linearData: LinearDataInterface,
            plotting: PlottingInterface = BarPlot(),
            colorConvention: LinearColorConventionInterface = DefaultColorConvention()
        ) = LinearChart(
            margin = margin,
            decoration = decoration,
            linearData = linearData,
            plotting = plotting,
            colorConvention = colorConvention
        ).Build(
            modifier = modifier,
            chartTitle = chartTitle
        )
    }
}