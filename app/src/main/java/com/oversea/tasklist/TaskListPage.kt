package com.oversea.tasklist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 *   Created by HuangWuYan on 2024/8/9
 *   Desc: 任务列表页面UI
 **/

@Composable
fun TaskListPage() {
    val viewModel = viewModel<TaskListViewModel>()

    val pageState = viewModel.pageState.value



    when (pageState) {
        LoadState.Loading -> CommonLoading(modifier = Modifier.fillMaxSize())
        LoadState.Completed -> {
            OrderTransferPageContent(viewModel)
        }

        else -> CommonEmpty(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp)
        )
    }

    if (viewModel.isShowLoading.value) {
        CommonLoading(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun OrderTransferPageContent(viewModel: TaskListViewModel) {
    Column {
        CommonAppBar()
        AccountListWidget(viewModel = viewModel)
    }
}



@Composable
fun AccountListWidget(viewModel: TaskListViewModel) {

    if (viewModel.taskList.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(viewModel.taskList) {
                EmptySelectAccountView()
            }
        }
    } else {
        EmptySelectAccountView()
    }
}


@Composable
fun EmptySelectAccountView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(160.dp)
                .padding(bottom = 8.dp),
            painter = painterResource(id = R.drawable.ic_common_empty),
            contentDescription = null
        )

    }
}