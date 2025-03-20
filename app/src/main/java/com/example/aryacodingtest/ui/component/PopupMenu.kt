package com.example.aryacodingtest.ui.component

import AttachOptionItem
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.aryacodingtest.R

@Composable
fun PopupMenu(onDismiss: () -> Unit) {
    // Transition state for animations
    val transition = updateTransition(targetState = true, label = "Menu Transition")

    // Scale animation for the popup menu
    val scale by transition.animateFloat(
        transitionSpec = { tween(800, easing = FastOutSlowInEasing) },
        label = "Scale Animation"
    ) { if (it) 1f else 0.8f }

    // Alpha animation to fade in the popup menu
    val alpha by transition.animateFloat(
        transitionSpec = { tween(800, easing = FastOutSlowInEasing) },
        label = "Alpha Animation"
    ) { if (it) 1f else 0f }

    // Offset animation to slide the popup menu into position
    val offsetY by transition.animateDp(
        transitionSpec = { tween(800, easing = FastOutSlowInEasing) },
        label = "Offset Y Animation"
    ) { if (it) 0.dp else 20.dp }

    // List of menu options with associated icons, text, and gradient colors
    val optionItems = listOf(
        Triple(
            R.drawable.icon_camera,
            R.string.camera,
            listOf(Color(0xFFACACAC), Color(0xFF787878)) // Gray gradient
        ),
        Triple(
            R.drawable.icon_photos,
            R.string.photos,
            listOf(Color(0xFFFBCA89), Color(0xFFF69A86)) // Orange-Pink gradient
        ),
        Triple(
            R.drawable.icon_files,
            R.string.files,
            listOf(Color(0xFF40D69E), Color(0xFF38B8AA)) // Greenish gradient
        ),
        Triple(
            R.drawable.icon_audio,
            R.string.audio,
            listOf(Color(0xFFBDA0E4), Color(0xFF778AE7)) // Purple-Blue gradient
        )
    )

    // Popup component with animation and dismiss behavior
    Popup(
        alignment = Alignment.TopStart, // Aligns popup to the top start
        onDismissRequest = onDismiss, // Callback when popup is dismissed
        properties = PopupProperties(focusable = true) // Allows focus inside the popup
    ) {
        Column(
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    alpha = alpha
                )
                .offset(y = offsetY)
                .padding(12.dp)
        ) {
            // Iterate through option items and display each one
            optionItems.forEach { (icon, textRes, gradientColors) ->
                AttachOptionItem(
                    iconRes = icon,
                    text = stringResource(textRes),
                    gradientColors = gradientColors
                )
            }
        }
    }
}
