package com.erykhf.android.studentbeanschallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erykhf.android.studentbeanschallenge.databinding.MainActivityBinding
import com.erykhf.android.studentbeanschallenge.ui.main.MainFragment
import com.erykhf.android.studentbeanschallenge.ui.main.PhotoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PhotoFragment.newInstance())
                    .commitNow()
        }
    }
}