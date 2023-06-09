package com.dev.anirban.chartlibrary.circular.charts

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
import com.dev.anirban.chartlibrary.circular.CircularChart
import com.dev.anirban.chartlibrary.circular.center.RingChartTextCenter
import com.dev.anirban.chartlibrary.circular.colorconvention.CircularDefaultColorConvention
import com.dev.anirban.chartlibrary.circular.data.TargetData
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.circular.foreground.RingChartForeground
import com.dev.anirban.chartlibrary.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularForegroundInterface

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

        // Donut Chart
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
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
         * @param chartTitle This is the title for the chart
         * @param circularCenter This is the implementation which draws the center of the circle
         * @param circularData This is the data class implementation which handles the data
         * @param circularDecoration This is the decorations for the Circular Chart
         * @param circularForeground This is the implementation which draws the foreground of the chart
         * @param circularColorConvention This is the color Convention implementation of the chart
         */
        @Composable
        fun SingleRingChart(
            modifier: Modifier = Modifier,
            chartTitle: String,
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
        ).Build(
            modifier = modifier,
            chartTitle = chartTitle
        )


        /**
         * This function creates an object of the [RingChart] which draws a basic multiple ring chart
         *
         * @param modifier modifier to be passed down from the parent function
         * @param chartTitle This is the title for the chart
         * @param circularCenter This is the implementation which draws the center of the circle
         * @param circularData This is the data class implementation which handles the data
         * @param circularDecoration This is the decorations for the Circular Chart
         * @param circularForeground This is the implementation which draws the foreground of the chart
         * @param circularColorConvention This is the color Convention implementation of the chart
         */
        @Composable
        fun MultipleRingChartRowWise(
            modifier: List<Modifier> = listOf(Modifier, Modifier),
            chartTitle: String,
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
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
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
                        color = circularDecoration[0].textColor,
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }

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
                                    .size(250.dp),
                                chartTitle = ""
                            )
                        }
                    }
                }
            }
        }
    }
}