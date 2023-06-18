package com.dev.anirban.chartlibrary.circular.exceptions

import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.circular.interfaces.CircularDataInterface

/**
 * This class is used to throw an exception when the [CircularDecoration.colorList] size is lesser
 * than the [CircularDataInterface.itemsList] size
 */
class CircularDecorationMismatch(message: String?) : Exception(message)