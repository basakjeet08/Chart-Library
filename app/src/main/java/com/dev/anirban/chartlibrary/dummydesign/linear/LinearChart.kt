package com.dev.anirban.chartlibrary.dummydesign.linear

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.chartsprototypes.linechart.LineChartDecoration

class LinearChart<T>(
    override val plotterInterface: PlotterInterface<T>,
    override val linearData: LinearData<T>,
    override val lineChartDecoration: LineChartDecoration,
    override val marginInterface: MarginInterface<T>
) : LinearChartInterface<T> {


    override fun DrawScope.drawMargins() {
        marginInterface.apply {
            drawMargins(linearData = linearData, lineChartDecoration = lineChartDecoration)
        }
    }

    override fun DrawScope.drawPlotting() {
        plotterInterface.apply {
            drawPlotting(linearData = linearData, lineChartDecoration = lineChartDecoration)
        }
    }

    @Composable
    override fun Build(modifier: Modifier, height: Dp) {

        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .padding(top = 12.dp, bottom = 12.dp)
        ) {

            // Decreasing the Size of Component than the Canvas Size to make the UI look better
            val componentSize = size / 1.20f

            linearData.doCalculations(size, componentSize)
            drawMargins()
            drawPlotting()
        }
    }
}