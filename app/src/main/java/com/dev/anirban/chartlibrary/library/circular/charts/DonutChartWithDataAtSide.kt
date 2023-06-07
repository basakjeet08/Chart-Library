package com.dev.anirban.chartlibrary.library.circular.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.library.circular.CircularChart
import com.dev.anirban.chartlibrary.library.circular.center.CircularDefaultCenter
import com.dev.anirban.chartlibrary.library.circular.center.DonutTargetTextCenter
import com.dev.anirban.chartlibrary.library.circular.colorconvention.ListColorConvention
import com.dev.anirban.chartlibrary.library.circular.colorconvention.TargetColorConvention
import com.dev.anirban.chartlibrary.library.circular.data.TargetData
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.library.circular.foreground.DonutChartForeground
import com.dev.anirban.chartlibrary.library.circular.foreground.DonutTargetChartForeground
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
open class DonutChartWithDataAtSide(
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

        // Making a row to fit the canvas and the color conventions
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Chart Title
            if (chartTitle.isNotBlank()) {
                Text(
                    text = chartTitle,

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 24.dp, end = 24.dp),

                    // Text Features
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    color = circularDecoration.textColor,
                )

                Spacer(modifier = Modifier.height(8.dp))
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                // Donut Chart
                Box(
                    modifier = modifier
                        .weight(1f)
                        .size(180.dp)
                        .drawBehind {

                            // Calling all the necessary functions
                            doCalculations()
                            drawForeground()
                        },
                    contentAlignment = Alignment.Center
                ) {

                    // Draws the center of the chart
                    DrawCenter()
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

    /**
     * Builder Composable Functions which makes the objects of [DonutChartWithDataAtSide] and these are
     * actually called by the users to make charts
     */
    companion object {

        /**
         * This function creates an object of the [DonutChartWithDataAtSide] which draws a basic
         * donut chart with its color conventions drawn at side
         *
         * @param modifier THis is made so that modifications can be passed from the parent function
         * @param chartTitle This is the title for the chart
         * @param circularCenter This is the implementation which draws the center of the circle
         * @param circularData This is the data class implementation which handles the data
         * @param circularDecoration This is the decorations for the Circular Chart
         * @param circularForeground This is the implementation which draws the foreground of the chart
         * @param circularColorConvention This is the color Convention implementation of the chart
         */
        @Composable
        fun RowDonutChart(
            modifier: Modifier = Modifier,
            chartTitle: String,
            circularCenter: CircularCenterInterface = CircularDefaultCenter(),
            circularData: CircularDataInterface,
            circularDecoration: CircularDecoration = CircularDecoration.donutChartDecorations(),
            circularForeground: CircularForegroundInterface = DonutChartForeground(),
            circularColorConvention: CircularColorConventionInterface = ListColorConvention()
        ) = DonutChartWithDataAtSide(
            circularCenter = circularCenter,
            circularData = circularData,
            circularDecoration = circularDecoration,
            circularForeground = circularForeground,
            circularColorConvention = circularColorConvention
        ).Build(
            modifier = modifier,
            chartTitle = chartTitle
        )


        /**
         * This function creates an object of the [DonutChartWithDataAtBottom] which draws a basic
         * donut chart with its color conventions drawn at side but the data is in the form of
         * Target and Achieved
         *
         * @param modifier THis is made so that modifications can be passed from the parent function
         * @param chartTitle This is the title for the chart
         * @param circularCenter This is the implementation which draws the center of the circle
         * @param circularData This is the data class implementation which handles the data
         * @param circularDecoration This is the decorations for the Circular Chart
         * @param circularForeground This is the implementation which draws the foreground of the chart
         * @param circularColorConvention This is the color Convention implementation of the chart
         */
        @Composable
        fun TargetDonutChart(
            modifier: Modifier = Modifier,
            chartTitle: String,
            circularCenter: CircularCenterInterface = DonutTargetTextCenter(),
            circularData: TargetData,
            circularDecoration: CircularDecoration = CircularDecoration.donutChartDecorations(),
            circularForeground: CircularForegroundInterface = DonutTargetChartForeground(),
            circularColorConvention: CircularColorConventionInterface = TargetColorConvention()
        ) = DonutChartWithDataAtSide(
            circularCenter = circularCenter,
            circularData = circularData.toDonutTargetData(),
            circularDecoration = circularDecoration,
            circularForeground = circularForeground,
            circularColorConvention = circularColorConvention
        ).Build(
            modifier = modifier,
            chartTitle = chartTitle
        )
    }
}