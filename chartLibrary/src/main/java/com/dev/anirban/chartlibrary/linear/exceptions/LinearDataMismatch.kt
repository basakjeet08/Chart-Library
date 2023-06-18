package com.dev.anirban.chartlibrary.linear.exceptions

import com.dev.anirban.chartlibrary.linear.interfaces.LinearDataInterface

/**
 * This exception is thrown when the X - Axis Readings array [LinearDataInterface.xAxisReadings]
 * contains less text than the list of Y - Axis Readings [LinearDataInterface.yAxisReadings]
 */

class LinearDataMismatch(message: String?) : Exception(message)