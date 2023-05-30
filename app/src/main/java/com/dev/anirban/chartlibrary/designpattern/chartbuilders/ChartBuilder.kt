package com.dev.anirban.chartlibrary.designpattern.chartbuilders

import androidx.compose.ui.graphics.drawscope.DrawScope

interface ChartBuilder {

    fun DrawScope.drawForeground()

    fun DrawScope.drawBackground()

    fun DrawScope.drawMargins()

    fun DrawScope.drawOthers()
}