package com.dev.anirban.chartlibrary.circular.center

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularDataInterface

/**
 * This class is the implementation of [CircularCenterInterface] which focuses on providing an
 * implementation to draw something on the center of the Circular Chart
 *
 * This Class in particular is the implementation to draw texts
 */
class DonutTargetTextCenter : CircularCenterInterface {

    /**
     * This function does nothing which is fine since we want the default Circle Center to be nothing
     *
     * @param circularData This is the data object which contains all the data about the Chart
     * @param decoration This is the decoration which contains all the decorations of the Chart
     */
    @Composable
    override fun DrawCenter(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    ) {

        // Percentage to be shown
        var percentage = circularData.itemsList[1].second / circularData.itemsList[0].second * 100

        if (percentage.isNaN())
            percentage = 0f

        if (percentage > 100f)
            percentage = 100f

        // Item and Value
        Text(
            text = "$percentage %",

            modifier = Modifier
                .padding(vertical = 4.dp),

            // Text Features
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.W500,
            color = decoration.textColor
        )
    }
}