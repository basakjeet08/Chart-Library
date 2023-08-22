package com.dev.anirban.chartlibrary.other.bmi.body

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiBodyInterface
import com.dev.anirban.chartlibrary.other.bmi.interfaces.BmiDataInterface


/**
 * This is one of the implementation for drawing the body of the Bmi Chart. It implements the
 * [BmiBodyInterface] Interface
 *
 * @see [BmiBodyInterface]
 */
class BmiBody : BmiBodyInterface {


    /**
     * This function draws the body of the BMI Chart
     *
     * @param decorations this contains the decoration and colors for the Chart
     * @param bmiData This contains the data related to the Chart UI
     */
    @Composable
    override fun DrawBody(
        decorations: BmiDecorations,
        bmiData: BmiDataInterface
    ) {

        // This is the parent row for the body of the BMI Chart
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // This draws the Weight Card
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                DrawCardItem(
                    title = "Weight",
                    value = bmiData.weight,
                    cardColor = decorations.weightCardColor
                )
            }

            // This Draws the Ideal Weight Card
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                DrawCardItem(
                    title = "Ideal Weight",
                    value = bmiData.idealWeight,
                    cardColor = decorations.idealWeightCardColor
                )
            }
        }
    }


    /**
     * This function draw the Items of the Card.
     *
     * @param title This is the heading title string of the card which will be seen at the top
     * @param value This is the value of the small Card Text
     * @param cardColor This is the color of the Card
     */
    @Composable
    private fun DrawCardItem(
        title: String,
        value: String,
        cardColor: Color
    ) {

        // Card Composable function which draws the outer card
        Card(colors = CardDefaults.cardColors(containerColor = cardColor)) {

            // Header Title of the Card
            Text(
                text = title,

                // Modifier
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp),

                // Font Properties
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )

            // spacer of 12 dp
            Spacer(Modifier.height(12.dp))


            // This draws the ruler Lines using canvas
            Box(
                modifier = Modifier
                    .height(28.dp)
                    .fillMaxWidth()
                    .drawBehind {
                        drawRulerLines(size = size)
                    }
            )

            // spacer of 8 dp
            Spacer(Modifier.height(8.dp))

            // This is the inner card which contains the Text with the value
            Card(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Text(
                    text = value,

                    // Modifier Value
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 16.dp),

                    // Font Properties
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.Black
                )
            }

            // Spacer of 8 dp
            Spacer(modifier = Modifier.height(8.dp))
        }
    }


    /**
     * This function draw the ruler Lines in the canvas
     *
     * @param size this is the size of the Canvas
     */
    private fun DrawScope.drawRulerLines(size: Size) {

        // xScale of the canvas
        val xScale = size.width / 10f

        // Drawing 10 ruler Lines
        for (i in 1..9) {

            // This function draws the vertical lines
            drawLine(

                // Opacity of the ruler is set here
                color = when (i) {
                    1 -> Color.Black.copy(alpha = .2f)
                    2 -> Color.Black.copy(alpha = .4f)
                    3 -> Color.Black.copy(alpha = .6f)
                    7 -> Color.Black.copy(alpha = .6f)
                    8 -> Color.Black.copy(alpha = .4f)
                    9 -> Color.Black.copy(alpha = .2f)
                    else -> Color.Black
                },
                start = Offset(
                    x = i * xScale,
                    y = 0f
                ),
                end = Offset(
                    x = i * xScale,
                    y = if (i == 5) size.height else size.height / 2f
                ),
                strokeWidth = 5f
            )
        }
    }
}