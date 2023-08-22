package com.dev.anirban.chartlibrary.other.bmi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.dev.anirban.chartlibrary.other.bmi.body.BmiBody
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiBodyInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiChartInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiDataInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiMarginInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiPlotInterface
import com.dev.anirban.chartlibrary.other.bmi.margins.BmiMargin
import com.dev.anirban.chartlibrary.other.bmi.plots.BmiPlot
import java.text.DecimalFormat

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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {


                Text(
                    text = "BMI Chart",

                    // font Properties
                    fontSize = 16.sp,
                    lineHeight = 25.2.sp,
                    fontWeight = FontWeight.W500,
                    color = decoration.textColor,
                )

                Text(
                    text = "${DecimalFormat("#.##").format(bmiData.readingValue.value)} ${bmiData.bmiUnit}",


                    // Font Properties
                    fontSize = 16.sp,
                    lineHeight = 25.2.sp,
                    fontWeight = FontWeight.W500,
                    color = decoration.textColor,
                    textAlign = TextAlign.Right,
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

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


    /**
     * Builder Composable Functions which makes the objects of [BmiChart] and these are
     * actually called by the users to make charts
     */
    companion object {


        /**
         * This function creates an object of the [BmiChart] which draws a basic Bmi chart
         *
         * @param modifier This is to be passed from the Parent Class for the modifications
         * @param margin This is the implementation for drawing the Margins
         * @param decoration This is the implementation for drawing the Decorations
         * @param bmiData This is the implementation for keeping the data and calculations
         * @param bmiPlot This is the implementation for how shall the plotting be drawn on the graph
         * @param bmiBody This is the body of the BMI Chart
         */
        @Composable
        fun BMIChart(
            modifier: Modifier = Modifier,
            margin: BmiMarginInterface = BmiMargin(),
            decoration: BmiDecorations = BmiDecorations.bmiDecorationColors(),
            bmiData: BmiDataInterface,
            bmiPlot: BmiPlotInterface = BmiPlot(),
            bmiBody: BmiBodyInterface = BmiBody()
        ) = BmiChart(
            marginImpl = margin,
            decoration = decoration,
            bmiData = bmiData,
            bmiPlot = bmiPlot,
            bmiBody = bmiBody
        ).Build(modifier = modifier)
    }
}