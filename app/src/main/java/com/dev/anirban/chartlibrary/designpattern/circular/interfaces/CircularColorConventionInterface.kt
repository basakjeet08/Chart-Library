package com.dev.anirban.chartlibrary.designpattern.circular.interfaces

import androidx.compose.runtime.Composable
import com.dev.anirban.chartlibrary.designpattern.circular.decoration.CircularDecoration

/**
 * This implementation shall be implemented by all the classes which are making color convention
 * implementation
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