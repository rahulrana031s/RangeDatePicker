package com.example.daterangepicker

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.daterangepicker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var room = 1
    var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStatusBar()
        binding.tvGotoSearch.setOnClickListener{
            startActivity(Intent(this@MainActivity,DatePickerActivity::class.java))
        }

        setData()

        setLisners()

    }

    private fun setLisners() {
        binding.ivMinus.setOnClickListener {
            if(count > 1){
                count--
                binding.tvCount.text = count.toString()
            }

        }
        binding.ivPlus.setOnClickListener {

                count++
                binding.tvCount.text = count.toString()

        }
        binding.ivRoomMinus.setOnClickListener {
            if(room > 1){
                room--
                binding.tvRoom.text = room.toString()
            }
        }
        binding.ivRoomPlus.setOnClickListener {
            room++
            binding.tvRoom.text = room.toString()
        }
    }

    private fun setData() {
        val extras = intent.extras
        if (extras != null) {
            val start: String = extras.getString("startDate").toString()
            val end:String = extras.getString("endDate").toString()
            binding.etStartDate.text = start
            binding.etEndDate.text = end
        }
    }

    private fun setStatusBar() {

        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.white)

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }
}