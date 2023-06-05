package com.dev.anirban.chartlibrary.library.circular.decoration

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * This is the class which contains the circular decoration data
 *
 * @param textColor Color of all the texts in the chart
 * @param colorList Primary Color list or the color list of the canvas arc in order
 */
class CircularDecoration(
    val textColor: Color,
    val colorList: List<Color>
) {

    /**
     * These function are used to make an object of [CircularDecoration]
     */
    companion object {

        /**
         * Provides [CircularDecoration] Objects for the circular Donut Charts
         *
         * Needs a Composable function to get the color from the material Theme since its
         * a composable function
         *
         * @param textColor Color of all the texts in the chart
         * @param colorList Primary Color list or the color list of the canvas arc in order
         */
        @Composable
        fun donutChartDecorations(
            textColor: Color = MaterialTheme.colorScheme.onSurface,
            colorList: List<Color> = listOf(
                Color.Cyan.copy(alpha = .7f),
                Color.Green,
                Color.Yellow,
                Color.Red
            )
        ) = CircularDecoration(
            textColor = textColor,
            colorList = colorList
        )

        /**
         * Provides [CircularDecoration] Objects for the circular Ring Charts
         *
         * Needs a Composable function to get the color from the material Theme since its
         * a composable function
         *
         * @param textColor Color of all the texts in the chart
         * @param colorList Primary Color list or the color list of the canvas arc in order
         */
        @Composable
        fun ringChartDecoration(
            textColor: Color = MaterialTheme.colorScheme.onSurface,
            colorList: List<Color> = listOf(
                Color.Cyan.copy(alpha = .7f),
                Color.Green,
                Color.Yellow,
                Color.Red,
                Color.Red
            )
        ) = CircularDecoration(
            textColor = textColor,
            colorList = colorList
        )
    }
}