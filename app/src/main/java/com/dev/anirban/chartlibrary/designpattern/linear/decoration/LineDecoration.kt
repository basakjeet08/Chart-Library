package com.dev.anirban.chartlibrary.designpattern.linear.decoration

import androidx.compose.ui.graphics.Color
import com.dev.anirban.chartlibrary.designpattern.linear.interfaces.LinearDecorationInterface

/**
 * This is one of the implementations of the [LinearDecorationInterface] which mostly contains the
 * decorations stuff like colors and all
 *
 * @param textColor this is the text color for all the margins and other things
 * @param plotPrimaryColor THis is the plot color for all the plotted Lines in the graph
 * @param plotSecondaryColor These are points color which are the points plotted in the graph
 */
class LineDecoration(
    override val textColor: Color,
    override val plotPrimaryColor: List<Color>,
    override val plotSecondaryColor: List<Color>
) : LinearDecorationInterface