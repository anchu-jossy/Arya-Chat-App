package com.example.aryacodingtest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aryacodingtest.R

// Define a custom font family
val InterSemiBold = FontFamily(
    Font(R.font.inter_semibold, FontWeight.SemiBold) // Ensure this font is available in res/font
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Profile Image
                Image(
                    painter = painterResource(R.drawable.sarahcarter),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(40.dp) // Profile image size
                        .clip(RoundedCornerShape(8.dp)) // Rounded corners
                )

                Spacer(modifier = Modifier.width(10.dp)) // Spacing between image & text

                // Contact Name
                Text(
                    text = "Sarah Carter",
                    fontSize = 18.sp,
                    fontFamily = InterSemiBold,
                    color = Color.White
                )
            }
        },
        navigationIcon = {
            // Back Button
            IconButton(onClick = { /* Handle back action */ }) {
                Icon(
                    painter = painterResource(R.drawable.icon_previous),
                    contentDescription = "Back",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent, // Transparent background
            titleContentColor = Color.White // White text color
        )
    )
}
