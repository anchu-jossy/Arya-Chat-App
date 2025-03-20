package com.example.aryacodingtest.ui.component

import AttachOptionItem
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aryacodingtest.R

/**
 * Composable for the message input section, including a text input field,
 * a plus button to expand the menu, and a send button when text is entered.
 */
@Composable
fun MessageInputSection(
    modifier: Modifier = Modifier,
    onMenuStateChange: (Boolean) -> Unit // Callback to notify menu state changes
) {
    var messageText by remember { mutableStateOf("") } // Stores the message text
    var isMenuExpanded by remember { mutableStateOf(false) } // Controls the menu visibility

    Box(
        modifier = modifier
            .fillMaxWidth()
            .then(if (isMenuExpanded) Modifier.blur(15.dp) else Modifier) // Apply blur effect when menu is expanded
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Plus button to expand or collapse the menu
            PlusButton {
                isMenuExpanded = !isMenuExpanded
                onMenuStateChange(isMenuExpanded)
            }
            Spacer(modifier = Modifier.width(12.dp)) // Adjust width as needed
            // Message input field
            MessageInputField(messageText = messageText, onTextChange = { messageText = it })

            // Send button (only visible when message text is not empty)
            if (messageText.isNotEmpty()) {
                SendIcon(
                    iconRes = R.drawable.icon_send,
                    contentDescription = stringResource(R.string.send)
                )
            }
        }

        // Popup menu for additional options (e.g., attach file, photo, etc.)
        if (isMenuExpanded) {
            PopupMenu(onDismiss = {
                isMenuExpanded = false
                onMenuStateChange(false)
            })
        }
    }
}

/**
 * A circular send icon button with customizable colors and size.
 */
@Composable
fun SendIcon(
    iconRes: Int,
    contentDescription: String?,
    iconTint: Color = Color(0xFFE8C39C), // Default icon tint
    backgroundColor: Color = Color.White, // Default background color
    size: Int = 30 // Default size
) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .background(backgroundColor, shape = RoundedCornerShape(50))
            .clickable { /* Handle click if needed */ },
        contentAlignment = Alignment.Center
    ) {

        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            tint = iconTint,
            modifier = Modifier
                .padding(8.dp)
                .size(18.dp)
        )
    }
}
