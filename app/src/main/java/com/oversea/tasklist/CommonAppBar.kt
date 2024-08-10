package com.oversea.tasklist

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.oversea.tasklist.theme.textStyleMedium16

/**
 *   Created by HuangWuYan on 2024/8/10
 *   Desc:
 **/
@Composable
fun CommonAppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    titleColor: Color = Color(0xFFFDFDFF),
    titleIcon: Int = 0,
    canGoBack: Boolean = true,
    backIcon: Int? = null,
    backgroundColor: Color = Color(0xFF129865),
    actions: @Composable RowScope.() -> Unit = {},
    actionsSpacing: Dp = 18.dp,
    actionsParentPadding: PaddingValues = PaddingValues(end = 12.dp),
    elevation: Dp = 0.dp,
    onBackClick: (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier,
        color = backgroundColor,
        shadowElevation = elevation,
    ) {
        val activity = LocalContext.current as Activity
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.weight(1f)) {
                if (canGoBack)
                    Image(
                        modifier = Modifier
                            .clickableNoIndication { onBackClick?.invoke() ?: activity.finish() }
                            .fillMaxHeight()
                            .padding(horizontal = 12.dp)
                            .size(24.dp),
                        painter = painterResource(id = backIcon ?: R.drawable.ic_common_back_white),
                        contentDescription = null
                    )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (titleIcon != 0) {
                    Image(
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 4.dp),
                        painter = painterResource(id = titleIcon),
                        contentDescription = null
                    )
                }

                Text(
                    text = title,
                    style = textStyleMedium16.copy(color = titleColor),
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Left,
                    maxLines = 1
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(actionsParentPadding),
                horizontalArrangement = Arrangement.spacedBy(
                    actionsSpacing,
                    alignment = Alignment.End
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = actions
            )
        }
    }
}