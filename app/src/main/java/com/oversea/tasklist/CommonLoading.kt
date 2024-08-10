package com.oversea.tasklist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 *   Created by HuangWuYan on 2024/8/10
 *   Desc:
 **/
@Composable
fun CommonLoading(modifier: Modifier = Modifier) {

    Box(modifier = modifier.clickableNoIndication { }, contentAlignment = Alignment.Center) {
        CircularProgressIndicator(modifier = Modifier.size(36.dp), color = Color(0xFF5A5E68))
    }
}