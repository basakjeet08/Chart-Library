package com.dev.anirban.chartlibrary.library.circular.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.library.circular.CircularChart
import com.dev.anirban.chartlibrary.library.circular.center.RingChartTextCenter
import com.dev.anirban.chartlibrary.library.circular.colorconvention.CircularDefaultColorConvention
import com.dev.anirban.chartlibrary.library.circular.data.TargetData
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.library.circular.foreground.RingChartForeground
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularForegroundInterface

/**
 * This class is the sub - class of [CircularChart] class which is the root parent class of the
 * circular charts.
 *
 * This class in general provides an implementation for a ring chart.
 *
 * @param circularCenter This is the implementation which draws the center of the circle
 * @param circularData This is the data class implementation which handles the data
 * @param circularDecoration This is the decorations for the Circular Chart
 * @param circularForeground This is the implementation which draws the foreground of the chart
 * @param circularColorConvention This is the color Convention implementation of the chart
 */
class RingChart(
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

        // Donut Chart
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = modifier
                    .size(300.dp)
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

            // This function draws the color convention
            DrawColorConventions()
        }

    }

    /**
     * Builder Composable Functions which makes the objects of [DonutChartWithDataAtSide] and these are
     * actually called by the users to make charts
     */
    companion object {


        /**
         * This function creates an object of the [RingChart] which draws a basic single ring chart
         *
         * @param modifier modifier to be passed down from the parent function
         * @param circularCenter This is the implementation which draws the center of the circle
         * @param circularData This is the data class implementation which handles the data
         * @param circularDecoration This is the decorations for the Circular Chart
         * @param circularForeground This is the implementation which draws the foreground of the chart
         * @param circularColorConvention This is the color Convention implementation of the chart
         */
        @Composable
        fun SingleRingChart(
            modifier: Modifier = Modifier,
            circularCenter: CircularCenterInterface = RingChartTextCenter("", "", ""),
            circularData: TargetData,
            circularDecoration: CircularDecoration = CircularDecoration.ringChartDecoration(),
            circularForeground: CircularForegroundInterface = RingChartForeground(),
            circularColorConvention: CircularColorConventionInterface = CircularDefaultColorConvention()
        ) = RingChart(
            circularCenter,
            circularData.toRingTargetData(),
            circularDecoration,
            circularForeground,
            circularColorConvention
        ).Build(modifier = modifier)


        /**
         * This function creates an object of the [RingChart] which draws a basic multiple ring chart
         *
         * @param modifier modifier to be passed down from the parent function
         * @param circularCenter This is the implementation which draws the center of the circle
         * @param circularData This is the data class implementation which handles the data
         * @param circularDecoration This is the decorations for the Circular Chart
         * @param circularForeground This is the implementation which draws the foreground of the chart
         * @param circularColorConvention This is the color Convention implementation of the chart
         */
        @Composable
        fun MultipleRingChartRowWise(
            modifier: List<Modifier> = listOf(Modifier, Modifier),
            circularCenter: List<CircularCenterInterface> = listOf(
                RingChartTextCenter("", "", ""),
                RingChartTextCenter("", "", "")
            ),
            circularData: List<TargetData>,
            circularDecoration: List<CircularDecoration> = listOf(
                CircularDecoration.ringChartDecoration(),
                CircularDecoration.ringChartDecoration()
            ),
            circularForeground: List<CircularForegroundInterface> = listOf(
                RingChartForeground(),
                RingChartForeground()
            ),
            circularColorConvention: List<CircularColorConventionInterface> = listOf(
                CircularDefaultColorConvention(),
                CircularDefaultColorConvention()
            )
        ) {
            Row {

                circularData.forEachIndexed { index, circularRingData ->
                    Box(
                        modifier = Modifier
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {

                        RingChart(
                            circularCenter[index],
                            circularRingData.toRingTargetData(),
                            circularDecoration[index],
                            circularForeground[index],
                            circularColorConvention[index]
                        ).Build(
                            modifier = modifier[index]
                                .size(250.dp)
                        )
                    }
                }
            }
        }
    }
}