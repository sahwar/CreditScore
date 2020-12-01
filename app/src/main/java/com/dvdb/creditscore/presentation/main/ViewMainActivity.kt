package com.dvdb.creditscore.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dvdb.creditscore.R
import com.dvdb.creditscore.presentation.overview.ViewOverviewFragment

class ViewMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ViewOverviewFragment.newInstance())
                .commitNow()
        }
    }
}