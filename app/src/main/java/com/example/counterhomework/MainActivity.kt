package com.example.counterhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.counterhomework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mCount = 0

    companion object {
        private const val KEY_COUNT = "KEY_COUNT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if(savedInstanceState != null){
            mCount = savedInstanceState.getInt(KEY_COUNT)
            binding.textCount.text = mCount.toString()
        }
    }


    fun countUp(view: android.view.View) {
        mCount++
        binding.textCount.text = mCount.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, mCount)
    }
}