package com.dev.anirban.chartlibrary.other.bmi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiBodyInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiChartInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiDataInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiMarginInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiPlotInterface

class BmiChart(
    override val marginImpl: BmiMarginInterface,
    override val decoration: BmiDecorations,
    override val bmiData: BmiDataInterface,
    override val bmiPlot: BmiPlotInterface,
    override val bmiBody: BmiBodyInterface
) : BmiChartInterface {


    /**
     * This function draws the margins according to the margin implementation passed to it
     */
    override fun DrawScope.drawMargin() {
        marginImpl.apply {
            drawMargin(
                bmiData = bmiData,
                decoration = decoration
            )
        }
    }


    /**
     * This function draws the plotting of the chart
     */
    override fun DrawScope.plotChart() {
        bmiPlot.apply {
            plotChart(
                bmiData = bmiData,
                decoration = decoration
            )
        }
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
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .drawBehind {

                        // Calling all the necessary functions
                        bmiData.apply { doCalculations(size = size) }
                        drawMargin()
                        plotChart()
                    }
            )

            bmiBody.apply {
                DrawBody(
                    decorations = decoration,
                    bmiData = bmiData
                )
            }
        }
    }
}