package com.puj.testtaskonlineshop.di

import androidx.lifecycle.ViewModel
import com.puj.testtaskonlineshop.presentation.viewmodels.HomeViewModel
import com.puj.testtaskonlineshop.presentation.viewmodels.LoginViewModel
import com.puj.testtaskonlineshop.presentation.viewmodels.ProductViewModel
import com.puj.testtaskonlineshop.presentation.viewmodels.SignInViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun bindSignInViewModel(viewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    fun bindProductViewModel(viewModel: ProductViewModel): ViewModel
}