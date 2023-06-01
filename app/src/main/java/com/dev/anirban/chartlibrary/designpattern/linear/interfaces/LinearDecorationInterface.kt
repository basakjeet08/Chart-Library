package com.dev.anirban.chartlibrary.designpattern.linear.interfaces

import androidx.compose.ui.graphics.Color

/**
 * This is the Decoration Interface which is the Interface for any Decoration class on the Linear
 * Charts.
 *
 * Any new implementation for the Linear Decorations need to implement this function for the
 * Implementation to work
 *
 */
interface LinearDecorationInterface {

    /**
     * textColor is used to define the color of the texts which are written in the Chart
     *
     * Note :- Keep in mind that the chart may need two colors One for the Dark theme another for
     * the light theme
     */
    val textColor: Color

    /**
     * plotColor is the Color used for the Lines Plotted in the Graph or the plot lines connecting
     * teh graph
     *
     * Note :- Since this is a list give more colors or equal colors to what XMarkers u provide
     */
    val plotColor: List<Color>

    /**
     * pointColor is the Color used for the dots in the Graph or the points in the graph
     *
     * Note :- Since this is a list give more colors or equal colors to what YMarkers u provide
     */
    val pointColor: List<Color>
}