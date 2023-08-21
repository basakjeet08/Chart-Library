package com.dev.anirban.chartlibrary.other.bmi.decorations

import androidx.compose.ui.graphics.Color


/**
 * This is one of the implementations of the [BmiDecorations] which mostly contains the
 * decorations stuff like colors and all
 *
 * @param textColor this is the text color for all the margins and other things
 * @param plotPrimaryColor This is the plot color for the plotting circle
 * @param barGradientColors This contains the list of colors used for the gradient
 * @param weightCardColor This contains the color of the weight Card
 * @param idealWeightCardColor This contains the color of the ideal weight card
 *
 */
class BmiDecorations(
    val textColor: Color,
    val plotPrimaryColor: Color,
    val barGradientColors: List<Color>,
    val weightCardColor: Color,
    val idealWeightCardColor: Color
)