package com.puj.testtaskonlineshop.di

import android.app.Application
import com.puj.testtaskonlineshop.presentation.fragments.LoginFragment
import com.puj.testtaskonlineshop.presentation.fragments.SignInFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: SignInFragment)

    fun inject(fragment: LoginFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}