package com.puj.testtaskonlineshop.di

import android.app.Application
import com.puj.testtaskonlineshop.presentation.fragments.HomeFragment
import com.puj.testtaskonlineshop.presentation.fragments.LoginFragment
import com.puj.testtaskonlineshop.presentation.fragments.ProductFragment
import com.puj.testtaskonlineshop.presentation.fragments.SignInFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class,
        ServiceModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: SignInFragment)

    fun inject(fragment: LoginFragment)

    fun inject(fragment: HomeFragment)

    fun inject(fragment: ProductFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}