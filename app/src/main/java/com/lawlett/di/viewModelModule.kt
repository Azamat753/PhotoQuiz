package com.lawlett.di

import com.lawlett.photoquiz.viewmodels.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var viewModelModule = module {
    viewModel { GameViewModel(get())}
}