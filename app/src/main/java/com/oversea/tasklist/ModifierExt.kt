package com.oversea.tasklist

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role

// 防快速重复点击间隔时间, 默认为800毫秒
const val click_interval_millis_default = 800L


/**
 * 无点击效果
 */
fun Modifier.clickableNoIndication(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = { onClick.invoke() },
    )
}


/**
 * 无点击效果, 防快速重复点击
 */
fun Modifier.clickableNoIndicationPreventQuick(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    intervalMillis: Long = click_interval_millis_default,
    onClick: () -> Unit,
): Modifier = this.clickablePreventQuick(
    indication = null,
    enabled = enabled,
    onClickLabel = onClickLabel,
    role = role,
    intervalMillis = intervalMillis,
    onClick = onClick
)

/**
 * 防快速重复点击
 * [intervalMillis] 防重复点击间隔时间, 默认为800毫秒
 */
fun Modifier.clickablePreventQuick(
    indication: Indication?,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    intervalMillis: Long,
    onClick: () -> Unit,
): Modifier = composed {

    val lastClickTime = remember { mutableStateOf(0L) }

    this.clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = indication,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = {
            if (System.currentTimeMillis() - lastClickTime.value >= intervalMillis) {
                onClick.invoke()
                lastClickTime.value = System.currentTimeMillis()
            }
        }
    )
}