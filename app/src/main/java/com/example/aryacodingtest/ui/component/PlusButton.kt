package com.example.aryacodingtest.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aryacodingtest.R

@Composable
fun PlusButton(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(30.dp)
    ) {
        Icon(modifier = Modifier

            .size(18.dp),
            painter = painterResource(R.drawable.icon_plus),
            contentDescription = stringResource(R.string.add),
            tint = Color.White,
        )


    }
}