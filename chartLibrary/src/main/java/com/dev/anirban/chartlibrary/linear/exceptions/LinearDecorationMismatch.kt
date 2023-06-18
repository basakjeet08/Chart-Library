package com.dev.anirban.chartlibrary.linear.exceptions

import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.linear.interfaces.LinearDataInterface

/**
 * This exception is thrown when the color array [LinearDecoration.plotPrimaryColor] and
 * [LinearDecoration.plotSecondaryColor] contains less color than the list of Y - Axis Readings at
 * data class [LinearDataInterface.yAxisReadings]
 */

class LinearDecorationMismatch(message: String?) : Exception(message)