package com.dev.anirban

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dev.anirban.chartlibrary.other.bmi.BmiChart
import com.dev.anirban.chartlibrary.other.bmi.data.BmiData
import com.dev.anirban.chartlibrary.other.bmi.decorations.BmiDecorations
import com.dev.anirban.chartlibrary.other.bmi.margins.BmiMargin
import com.dev.anirban.chartlibrary.other.bmi.plots.BmiPlot
import com.dev.anirban.chartlibrary.util.ChartPoint
import com.dev.anirban.screens.components.TopBarUI
import com.dev.anirban.ui.theme.ChartLibraryTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChartLibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    // Scaffold
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        topBar = {
                            TopBarUI()
                        }
                    ) {

                        // Main App UI in the Body of the Scaffold
                        Surface(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxSize(),
                        ) {

//                            BMI()

                            BmiChart(
                                marginImpl = BmiMargin(),
                                decoration = BmiDecorations(
                                    textColor = MaterialTheme.colorScheme.onBackground,
                                    plotPrimaryColor = Color.Red,
                                    barGradientColors = listOf(
                                        Color.Blue,
                                        Color.Cyan,
                                        Color.Red,
                                        Color.LightGray
                                    ),
                                    weightCardColor = Color.Blue,
                                    idealWeightCardColor = Color.Green
                                ),
                                bmiData = BmiData(
                                    readingValue = ChartPoint(27f),
                                    idealWeight = ChartPoint(75f),
                                    weight = ChartPoint(20f)
                                ),
                                bmiPlot = BmiPlot()
                            ).Build(modifier = Modifier)
                        }
                    }
                }
            }
        }
    }
}