package com.example.teamdirectory.di

import com.example.teamdirectory.data.remote.HttpClientFactory
import com.example.teamdirectory.data.remote.UserApi
import com.example.teamdirectory.data.repository.UserRepository
import com.example.teamdirectory.ui.detail.UserDetailViewModel
import com.example.teamdirectory.ui.users.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory().createHttpClient() }
    singleOf(::UserApi)
    singleOf(::UserRepository)
    viewModelOf(::UsersViewModel)
    viewModel { (id: Int) -> UserDetailViewModel(id = id, repository = get()) }
}
