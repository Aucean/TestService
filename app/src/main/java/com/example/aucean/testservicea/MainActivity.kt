package com.example.aucean.testservicea

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.aucean.testservicea.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    fun onConnect(v: View) {
        val intent = Intent(this, ActivityTest::class.java)
        intent.putExtra("ip", mBinding.ipAddress)
        intent.putExtra("port", mBinding.port)
        startActivity(intent)
    }
}
