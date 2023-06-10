package com.dev.anirban.chartlibrary.circular.center

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.dev.anirban.chartlibrary.circular.decoration.CircularDecoration
import com.dev.anirban.chartlibrary.circular.interfaces.CircularCenterInterface
import com.dev.anirban.chartlibrary.circular.interfaces.CircularDataInterface


/**
 * This class is the implementation of [CircularCenterInterface] which focuses on providing an
 * implementation to draw an image on the Chart
 *
 * This Class in particular is the implementation to draw texts
 *
 * @param
 */
class CircularImageCenter(
    private val image: ImageVector = Icons.Default.Check,
    private val contentDescription: String? = null
) : CircularCenterInterface {

    @Composable
    override fun DrawCenter(
        circularData: CircularDataInterface,
        decoration: CircularDecoration
    ) {
        Icon(
            imageVector = image,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(24.dp)
        )
    }
}