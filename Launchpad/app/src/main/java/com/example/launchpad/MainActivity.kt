package com.example.launchpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.launchpad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(find_job())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId) {

                R.id.itJob -> replaceFragment(find_job())
                R.id.itInterview -> replaceFragment(interview_tools())
                R.id.itAlumni -> replaceFragment(alumni())
                R.id.itProfile -> replaceFragment(profile())

                else -> {

                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}