package com.dev.anirban.chartlibrary.circular.interfaces

import androidx.compose.runtime.Composable
import com.dev.anirban.chartlibrary.circular.colorconvention.*
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration

/**
 * This implementation shall be implemented by all the classes which are making color convention
 * implementation
 *
 * Implementations for this interface are :- [CircularDefaultColorConvention],
 * [CircularGridColorConvention],[CircularListColorConvention],[CircularTargetColorConvention]

 *
 * @property DrawColorConventions THis function draws the desired color Convention
 */
interface CircularColorConventionInterface {

    @Composable
    fun DrawColorConventions(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    )
}