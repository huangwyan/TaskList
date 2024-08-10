package com.oversea.tasklist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 *   Created by HuangWuYan on 2024/8/10
 *   Desc:
 **/
@Composable
fun CommonEmpty(
    modifier: Modifier = Modifier,
    tips: String = "请添加自动任务",
    tail: @Composable () -> Unit = {}
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_common_empty),
            contentDescription = null,
            modifier = Modifier
                .width(275.dp)
                .height(124.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = tips,
        )
        Spacer(modifier = Modifier.height(40.dp))
        tail()
    }
}