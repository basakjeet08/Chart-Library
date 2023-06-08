package com.dev.anirban.chartlibrary.screens.utils

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.anirban.chartlibrary.R
import com.dev.anirban.chartlibrary.ui.theme.ChartLibraryTheme
import com.dev.anirban.chartlibrary.ui.theme.InterFontFamily

// Preview Composable Function
@Preview("Light")
@Preview(
    name = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    ChartLibraryTheme {
        TopBarUI()
    }
}

/**
 * This is the Top App Bar of the App
 *
 * @param modifier Modifications provided by the parent Function
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarUI(
    modifier: Modifier = Modifier
) {
    TopAppBar(title = {
        Text(
            text = stringResource(R.string.water_statistics),
            modifier = Modifier
                .padding(start = 4.dp),


            // Text and Font Properties
            fontSize = 20.sp,
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Center,
        )
    },
        modifier = modifier,
        navigationIcon = {

            // Navigation Image / Back Button
            Image(
                painter = painterResource(id = R.drawable.back_button),
                contentDescription = stringResource(id = R.string.back_button),
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp, end = 8.dp, start = 16.dp)
                    .size(16.dp),
                alignment = Alignment.CenterStart
            )
        }
    )
}
