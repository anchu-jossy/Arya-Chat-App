package com.example.aryacodingtest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun GradientRoundIcon(
    iconRes: Int,
    contentDescription: String?,
    iconTint: Color = Color.White,
    gradientColors: List<Color> = listOf(Color(0xFFFD7E14), Color(0xFFFFC107)), // Orange to Yellow
    size: Int = 40
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape) // Ensures round shape
            .background(brush = Brush.linearGradient(gradientColors)) // Apply gradient
            .clickable { /* Handle click if needed */ },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = iconTint,
            modifier = Modifier
                .size((size * 0.5).dp)
                .padding(1.dp) // Scale icon size
        )
    }
}
