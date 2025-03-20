package com.example.aryacodingtest.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aryacodingtest.R

/**
 * A composable text input field for user messages with a send button.
 * The send button appears only when the input is not empty.
 *
 * @param messageText The current message text entered by the user.
 * @param onTextChange A callback to update the message text.
 */
@Composable
fun MessageInputField(
    messageText: String,
    onTextChange: (String) -> Unit
) {
    BasicTextField(
        value = messageText,
        onValueChange = { onTextChange(it) }, // Properly updates the text state
        textStyle = LocalTextStyle.current.copy(
            textAlign = TextAlign.Start,
            color = Color.White,
            fontSize = 16.sp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(Color.DarkGray.copy(alpha = 0.15f), RoundedCornerShape(24.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        singleLine = true,
        maxLines = 1,
        cursorBrush = SolidColor(Color.White),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Text input field container
                Box(modifier = Modifier.weight(1f)) {
                    if (messageText.isEmpty()) {
                        Text(
                            text = stringResource(R.string.message_placeholder),
                            color = Color.White.copy(alpha = 0.7f),
                            fontSize = 16.sp
                        )
                    }
                    innerTextField()
                }

                // Send button only appears when there is text input
                if (messageText.isNotEmpty()) {
                    SendIcon(
                        iconRes = R.drawable.icon_send,
                        contentDescription = stringResource(R.string.send)
                    )
                }
            }
        }
    )
}
