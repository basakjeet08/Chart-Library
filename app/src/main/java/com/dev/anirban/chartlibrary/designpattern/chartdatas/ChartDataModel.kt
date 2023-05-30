package com.dev.anirban.chartlibrary.designpattern.chartdatas

import androidx.compose.ui.geometry.Size


interface ChartDataModel {

    fun doCalculations(size: Size, componentSize: Size)
}