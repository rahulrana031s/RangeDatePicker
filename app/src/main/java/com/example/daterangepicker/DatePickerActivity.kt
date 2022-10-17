package com.example.daterangepicker

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.daterangepicker.databinding.ActivityDatePickerBinding


class DatePickerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBar()

        setListners()

    }

    private fun setListners() {

       binding.calendarView.setOnRangeSelectedListener { startDate, endDate, startLabel, endLabel ->
            binding.textView4.text = startLabel
            binding.textView3.text = endLabel

        }

        binding.tvDone.setOnClickListener {
            val i = Intent(this@DatePickerActivity, MainActivity::class.java)
            i.putExtra("startDate",     binding.textView4.text)
            i.putExtra("endDate",     binding.textView3.text)
            startActivity(i)
            finish()

        }
        binding.tvCancel.setOnClickListener {
            finish()
        }
    }

    private fun setStatusBar() {

        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.blue)

    }
}