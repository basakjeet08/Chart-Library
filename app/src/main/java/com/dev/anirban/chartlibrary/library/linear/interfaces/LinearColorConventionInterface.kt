package com.dev.anirban.chartlibrary.library.linear.interfaces

import androidx.compose.runtime.Composable
import com.dev.anirban.chartlibrary.library.linear.decoration.LinearDecoration

/**
 * This implementation shall be implemented by all the classes which are making color convention
 * implementation
 *
 * @property DrawColorConventions THis function draws the desired color Convention
 */
interface LinearColorConventionInterface {

    /**
     * This variable contains the list of strings which needs to be drawn in the color convention
     */
    val textList: List<String>

    /**
     * This is the function which draws all the color convention
     */
    @Composable
    fun DrawColorConventions(decoration: LinearDecoration)

}