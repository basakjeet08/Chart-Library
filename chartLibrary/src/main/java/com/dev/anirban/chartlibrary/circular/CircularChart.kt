package com.dev.anirban.chartlibrary.circular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularChartInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularColorConventionInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularDataInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularForegroundInterface

/**
 * This class extends from the [CircularChartInterface] which means its the root level class
 *
 * @property circularCenter Implementation for the center of the chart
 * @property circularData Implementation for the data of the chart
 * @property circularDecoration Implementation for the decoration of the chart
 * @property circularForeground Implementation for the foreground of the chart
 * @property circularColorConvention Implementation for the color convention of the chart
 *
 * @property DrawCenter This function draws the center of the chart
 * @property doCalculations This function does the calculation of the chart
 * @property drawForeground This function draws the foreground of the chart
 * @property DrawColorConventions This function draws the Color Convention of the chart
 * @property Build This function starts building the circular Chart
 */
open class CircularChart(
    override val circularCenter: CircularCenterInterface,
    override val circularData: CircularDataInterface,
    override val circularDecoration: CircularDecoration,
    override val circularForeground: CircularForegroundInterface,
    override val circularColorConvention: CircularColorConventionInterface
) : CircularChartInterface {

    /**
     * Function to draw something on the center
     */
    @Composable
    override fun DrawCenter() {
        circularCenter.DrawCenter(
            circularData = circularData,
            decoration = circularDecoration
        )
    }

    /**
     * This function does mostly handle business and calculation related
     */
    override fun doCalculations() {
        circularData.doCalculations()
    }

    /**
     * This function draws the foreground
     */
    override fun DrawScope.drawForeground() {
        circularForeground.apply {
            drawForeground(
                circularData = circularData,
                decoration = circularDecoration
            )
        }
    }

    /**
     * This function draws the Color Convention in the chart
     */
    @Composable
    override fun DrawColorConventions() {
        circularColorConvention.DrawColorConventions(
            circularData = circularData,
            decoration = circularDecoration
        )
    }

    /**
     * This is the Build Function which starts composing the Charts and composes the Charts
     *
     * @param modifier This is for default modifications to be passed from the parent Class
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
}