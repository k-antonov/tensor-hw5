package com.example.tensor_hw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tensor_hw5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Activity holding fragment container"

        if (savedInstanceState == null) {
            addFragmentSender()
        }

    }

    private fun addFragmentSender() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, SenderFragment())
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(TAG, "Back stack entries count: ${supportFragmentManager.backStackEntryCount}")
    }
}