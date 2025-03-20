package com.example.aryacodingtest.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aryacodingtest.R

// FontFamily for Inter Medium
val InterFontMedium = FontFamily(
    Font(R.font.inter_medium, FontWeight.Normal)
)

/**
 * Composable function for displaying a chat message bubble.
 *
 * @param message The message text to display.
 * @param time The timestamp of the message.
 * @param isSentByMe Boolean indicating whether the message was sent by the user.
 */
@Composable
fun MessageBubble(message: String, time: String, isSentByMe: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = if (isSentByMe) Arrangement.End else Arrangement.Start // Align bubbles based on sender
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = if (isSentByMe) Color.White else Color(0xFF4895C3), // Different colors for sender & receiver
                    shape = RoundedCornerShape(16.dp) // Rounded corners for the bubble
                )
                .padding(12.dp)
                .widthIn(max = 280.dp) // Limit the width of the message bubble
        ) {
            Column {
                // Message Text
                Text(
                    text = message,
                    color = if (isSentByMe) Color.Black else Color.White,
                    fontSize = 17.sp,
                    fontFamily = InterFontMedium
                )

                // Time & Read Status Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End, // Align timestamp to the right
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = time,
                        fontSize = 12.sp,
                        fontFamily = InterFontMedium,
                        fontWeight = FontWeight.Normal,
                        color = if (isSentByMe) Color(0xFF02A6FC) else Color.White // Blue for sent messages, white for received
                    )

                    // Read Receipt Icon (Only for sent messages)
                    if (isSentByMe) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.icon_chat_read),
                            contentDescription = "Read Receipt",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}
