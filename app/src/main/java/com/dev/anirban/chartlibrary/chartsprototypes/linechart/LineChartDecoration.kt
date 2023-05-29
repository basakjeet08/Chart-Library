package com.dev.anirban.chartlibrary.chartsprototypes.linechart

import androidx.compose.ui.graphics.Color

/**
 * This data class contains all the decoration data  related to the Line Chart
 *
 * @param textColor This is the text color to be used in the line chart
 * @param lineColor This is the line color to be used in the Line Chart
 * @param dotColor THis is the dot color to be used in the Line Chart
 */
data class LineChartDecoration(
    val textColor: Int,
    val lineColor: List<Color>,
    val dotColor: List<Color>
)