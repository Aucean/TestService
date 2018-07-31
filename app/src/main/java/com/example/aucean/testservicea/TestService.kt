package com.example.aucean.testservicea

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger

class TestService : Service() {
    val START_ACTIVITY = 1
    var mMessage: Message? = null
    val messager: Messenger by lazy {
        Messenger(object : Handler() {
            override fun handleMessage(msg: Message?) {
                mMessage = msg
                msg?.run {
                    if (msg.what == START_ACTIVITY) {
                        val intent = Intent(this@TestService, ActivityTest::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        this@TestService.startActivity(intent)
                    }

                }
            }

        })
    }
    override fun onBind(intent: Intent): IBinder {
        return messager.binder
    }


}
