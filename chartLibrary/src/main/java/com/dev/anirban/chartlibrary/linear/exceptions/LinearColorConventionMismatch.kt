package com.dev.anirban.chartlibrary.linear.exceptions

import com.dev.anirban.chartlibrary.linear.decoration.LinearDecoration
import com.dev.anirban.chartlibrary.linear.interfaces.LinearColorConventionInterface

/**
 * This exception is thrown when the Text List array [LinearColorConventionInterface.textList]
 * contains more text than the list of primary color at decoration class
 * [LinearDecoration.plotPrimaryColor]
 */
class LinearColorConventionMismatch(message: String?) : Exception(message)
