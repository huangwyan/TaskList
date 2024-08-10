package com.oversea.tasklist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 *   Created by HuangWuYan on 2024/8/9
 *   Desc:
 **/
class TaskListViewModel :ViewModel(){

    // 展示loading
    var isShowLoading = mutableStateOf(false)

    // 页面加载状态
    val pageState = mutableStateOf(LoadState.Loading)

    // 任务列表
    var taskList: MutableList<TaskItemEntity> = mutableListOf()

}