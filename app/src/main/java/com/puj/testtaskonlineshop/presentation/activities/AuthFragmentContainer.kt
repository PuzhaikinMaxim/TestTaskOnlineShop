package com.puj.testtaskonlineshop.presentation.activities

import androidx.fragment.app.Fragment

interface AuthFragmentContainer {

    fun startNewFragment(fragment: Fragment)

    fun startMainMenuActivity()
}