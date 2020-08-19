package com.x.media

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.x.media.`null`.MainFragment
import com.x.media.mvvm.fragment.TabFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TabFragment.newInstance())
                .commitNow()
        }
    }
}
