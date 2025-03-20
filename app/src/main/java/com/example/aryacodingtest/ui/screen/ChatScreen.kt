package com.example.aryacodingtest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aryacodingtest.R
import com.example.aryacodingtest.ui.component.MessageBubble
import com.example.aryacodingtest.ui.component.MessageInputSection
import com.example.aryacodingtest.ui.component.Toolbar

@Composable
fun ChatScreen(innerPadding: PaddingValues) {
    var isMenuExpanded by remember { mutableStateOf(false) } // Controls the attachment menu state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF048df5), // Blue
                        Color(0xFF14a8f6), // Lighter Blue
                        Color(0xFF91aebb), // Greyish-Blue
                        Color(0xFFe9c39c)  // Warm Beige
                    ),
                    tileMode = TileMode.Clamp
                )
            )
            .clickable { isMenuExpanded = false } // Close menu when clicking outside
    ) {
        // Main Chat Column (Includes Toolbar and Messages)
        Column(
            modifier = Modifier
                .then(if (isMenuExpanded) Modifier.blur(15.dp) else Modifier) // Blur effect when menu is open
        ) {
            Toolbar() // Top app bar

            // Chat Messages Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp) // Adds spacing between messages
            ) {
                MessageBubble(
                    message = stringResource(R.string.message_1),
                    time = stringResource(R.string.time_1),
                    isSentByMe = false // Received message
                )

                MessageBubble(
                    message = stringResource(R.string.message_2),
                    time = stringResource(R.string.time_2),
                    isSentByMe = true // Sent message
                )
            }
        }

        // Message Input Section (Aligns at Bottom)
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            MessageInputSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
                    .imePadding() // Adjust for keyboard
                    .navigationBarsPadding(), // Adjust for system navigation bar
                onMenuStateChange = { isMenuExpanded = it } // Updates menu state
            )
        }
    }
}
