package com.dev.anirban.chartlibrary.library.circular.center

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.library.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.library.circular.interfaces.CircularDataInterface

/**
 * This class is the implementation of [CircularCenterInterface] which focuses on providing an
 * implementation to draw something on the center of the Circular Chart
 *
 * This Class in particular is the implementation to draw texts
 */
class DonutTargetTextCenter : CircularCenterInterface {

    /**
     * This function does nothing which is fine since we want the default Circle Center to be nothing
     */
    @Composable
    override fun DrawCenter(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    ) {

        var percentage = (circularData.achieved / circularData.target) * 100
        if (percentage.isNaN())
            percentage = 0f

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