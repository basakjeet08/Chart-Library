package com.dev.anirban.screens.water

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.circular.charts.DonutChartWithDataAtSide
import com.dev.anirban.chartlibrary.circular.data.DonutListData
import com.dev.anirban.chartlibrary.circular.data.TargetData
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.linear.LinearChart
import com.dev.anirban.chartlibrary.linear.colorconvention.GridColorConvention
import com.dev.anirban.chartlibrary.linear.data.LinearData
import com.dev.anirban.chartlibrary.linear.util.Point
import com.dev.anirban.screens.utils.CustomCard
import com.dev.anirban.screens.utils.WaterSunnyCardBody
import com.dev.anirban.screens.utils.WaterWeatherCardBody
import com.dev.anirban.ui.theme.ChartLibraryTheme
import com.dev.anirban.ui.theme.InterFontFamily

// Preview Composable Function
@Preview(
    "Light",
    heightDp = 1530,
    showBackground = true
)
@Preview(
    name = "Dark",
    heightDp = 1530,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        WaterDayStats()
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WaterDayStats() {

    // This Column contains the body of the screen
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {

        // This function draws an elevated Card View
        CustomCard(
            title = "Daily Progress"
        ) {

            Column {
                DonutChartWithDataAtSide.TargetDonutChart(
                    circularData = TargetData(
                        target = 4000f,
                        achieved = 5000f,
                        siUnit = "L",
                        cgsUnit = "mL",
                        conversionRate = { it / 1000f }
                    )
                )

                Row(
                    modifier = Modifier
                        .padding(start = 12.dp, bottom = 12.dp, end = 12.dp)
                        .fillMaxWidth()
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.AccountBox,
                        contentDescription = null
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "Over hydration",

                        // Text and Font Properties
                        textAlign = TextAlign.Start,
                        color = Color.Red,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = "You have crossed your daily intake",

                    // Modifications
                    modifier = Modifier
                        .padding(start = 44.dp, bottom = 2.dp),

                    // Text and Font Properties
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 14.sp
                )

                Text(
                    text = "Over hydration can lead to water intoxication. This occurs when " +
                            "the amount of salt and other electrolytes in your body become too diluted.",

                    // Modifications
                    modifier = Modifier
                        .padding(start = 44.dp, bottom = 12.dp, end = 6.dp),

                    // Text and Font Properties
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f),
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp,
                    lineHeight = TextUnit(
                        value = 18f,
                        TextUnitType.Sp
                    )
                )
            }
        }

        // Sunny Water Intake Increase Prompt Card
        CustomCard {
            WaterSunnyCardBody()
        }

        // Weather Water Intake Increase Prompt Card
        CustomCard {
            WaterWeatherCardBody()
        }

        CustomCard(
            title = "Daily Progress"
        ) {
            LinearChart.BarChart(
                linearData = LinearData(
                    yAxisReadings = listOf(
                        Point.pointDataBuilder(5f, 10f, 6f, 4.2f, 8f, 10f, 6f)
                    ),
                    xAxisReadings = Point.pointDataBuilder(
                        "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                    )
                )
            )
        }

        CustomCard(
            title = "Ratio"
        ) {
            DonutChartWithDataAtSide.RowDonutChart(
                circularData = DonutListData(
                    itemsList = listOf(
                        Pair("Water", 1500f),
                        Pair("Juice", 300f),
                        Pair("Soft Drink", 500f)
                    ),
                    siUnit = "L",
                    cgsUnit = "mL",
                    conversionRate = { it / 1000f }
                ),
                circularDecoration = CircularDecoration(
                    textColor = MaterialTheme.colorScheme.onSurface,
                    colorList = listOf(
                        Color.Blue,
                        Color.Green,
                        Color.Red
                    )
                )
            )
        }

        CustomCard(
            title = "Beverages"
        ) {
            Column {
                LinearChart.LineChart(
                    linearData = LinearData(
                        yAxisReadings = listOf(
                            Point.pointDataBuilder(3f, 2.5f, 2.8f, 3.5f, 5.7f, 2.6f, 3.4f),
                            Point.pointDataBuilder(3.6f, 3f, 2.4f, 6f, 4.5f, 2.9f, 3.8f)
                        ),
                        xAxisReadings = Point.pointDataBuilder(
                            "6-7", "8-9", "10-11", "12-1", "2-3", "4-5", "6-7"
                        )
                    ),
                    colorConvention = GridColorConvention(
                        textList = listOf("Water", "Juice")
                    )
                )

                Text(
                    text = "Over hydration",

                    // Modifications
                    modifier = Modifier
                        .padding(start = 16.dp, bottom = 12.dp),

                    // Text and Font Properties
                    textAlign = TextAlign.Start,
                    color = Color.Red,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
            }
        }
    }
}