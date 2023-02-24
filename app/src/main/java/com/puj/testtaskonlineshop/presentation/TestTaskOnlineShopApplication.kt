package com.puj.testtaskonlineshop.presentation

import android.app.Application
import com.puj.testtaskonlineshop.di.DaggerApplicationComponent

class TestTaskOnlineShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}