package com.dev.anirban.chartlibrary.other.bmi.decorations

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
) {


    /**
     * These function are used to make an object of [BmiDecorations]
     */
    companion object {
        private val firstColor = Color(0xFFB5D4F1)
        private val secondColor = Color(0xFF81E5DB)
        private val thirdColor = Color(0xFFE8D284)
        private val fourthColor = Color(0xFFE2798E)

        private val weightCardColor = Color(0xFFC7EBFC)
        private val idealWeightCardColor = Color(0xFFD8F5E0)


        /**
         * Provides [BmiDecorations] Object for the Bmi Charts
         *
         * Needs a Composable function to get the color from the material Theme since its
         * a composable function
         */
        @Composable
        fun bmiDecorationColors(
            textColor: Color = MaterialTheme.colorScheme.onSurface,
            plotPrimaryColor: Color = Color.Red,
            barGradientColors: List<Color> = listOf(
                firstColor,
                secondColor,
                thirdColor,
                fourthColor
            ),
            weightCardColor: Color = BmiDecorations.weightCardColor,
            idealWeightCardColor: Color = BmiDecorations.idealWeightCardColor
        ) = BmiDecorations(
            textColor = textColor,
            plotPrimaryColor = plotPrimaryColor,
            barGradientColors = barGradientColors,
            weightCardColor = weightCardColor,
            idealWeightCardColor = idealWeightCardColor
        )
    }
}