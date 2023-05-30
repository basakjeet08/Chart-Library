package com.dev.anirban.chartlibrary.designpattern

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.designpattern.chartbuilders.ChartBuilder
import com.dev.anirban.chartlibrary.designpattern.chartdatas.ChartDataModel

open class Chart(
    private val chartBuilder: ChartBuilder,
    private val chartDataModel: ChartDataModel
) : ChartBuilder, ChartDataModel {


    override fun doCalculations(size: Size, componentSize: Size) {
        chartDataModel.doCalculations(size, componentSize)
    }

    override fun DrawScope.drawForeground() {
        chartBuilder.apply {
            drawForeground()
        }
    }

    override fun DrawScope.drawBackground() {
        chartBuilder.apply {
            drawBackground()
        }
    }

    override fun DrawScope.drawMargins() {
        chartBuilder.apply {
            drawMargins()
        }
    }

    override fun DrawScope.drawOthers() {
        chartBuilder.apply {
            drawOthers()
        }
    }

    @Composable
    fun Build(
        modifier: Modifier = Modifier,
        height: Dp = 200.dp
    ) {
        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .padding(top = 12.dp, bottom = 12.dp)
        ) {

            // Decreasing the Size of Component than the Canvas Size to make the UI look better
            val componentSize = size / 1.20f

            doCalculations(size, componentSize)
            drawMargins()
            drawBackground()
            drawForeground()
            drawOthers()
        }
    }
}