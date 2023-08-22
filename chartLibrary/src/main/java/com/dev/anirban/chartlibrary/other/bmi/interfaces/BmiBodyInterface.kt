package com.dev.anirban.chartlibrary.other.bmi.interfaces

import androidx.compose.runtime.Composable
import com.dev.anirban.chartlibrary.other.bmi.body.BmiBody

/**
 * This is the Body Interface which has to be implemented by the class which makes a new
 * Implementation for the handling of body or other composable functions to be drawn in the Chart.
 *
 *  This class is implemented in [BmiBody] and you can see this class too for the basic
 *  implementation of the class
 *
 * @see [BmiBody]
 */
interface BmiBodyInterface {


    /**
     * This function draws the body of the BMI Chart
     */
    @Composable
    fun DrawBody()
}