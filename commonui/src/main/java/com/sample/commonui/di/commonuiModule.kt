package com.sample.commonui.di

import com.sample.commonui.viewmodel.repository.SearchRepositoriesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val commonuiModule = module {

    viewModel { SearchRepositoriesViewModel(get())}

}