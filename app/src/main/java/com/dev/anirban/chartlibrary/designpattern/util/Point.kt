package com.dev.anirban.chartlibrary.designpattern.util

import androidx.compose.ui.geometry.Offset

class Point<T>(
    val value: T
) {

    var xCoordinate: Float = 0f
        private set
    var yCoordinate: Float = 0f
        private set

    fun setXCoordinate(xCoordinate: Float) {
        this.xCoordinate = xCoordinate
    }

    fun setYCoordinate(yCoordinate: Float) {
        this.yCoordinate = yCoordinate
    }

    fun getOffset() : Offset = Offset(xCoordinate , yCoordinate)

}
