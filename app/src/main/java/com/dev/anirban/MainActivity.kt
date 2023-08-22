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
import com.dev.anirban.screens.LibraryUIExample
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
                            LibraryUIExample()
                        }
                    }
                }
            }
        }
    }
}