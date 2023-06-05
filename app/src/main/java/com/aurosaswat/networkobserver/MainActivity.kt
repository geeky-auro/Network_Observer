package com.aurosaswat.networkobserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.aurosaswat.networkobserver.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        connectivityObserver=NetworkConnectivityObserver(applicationContext)
//        var textView=findViewById<TextView>(R.id.text123)
//        val status by ConnectivityObserver.observe().collectAsState(initial=ConnectivityObserver.Status.Unavailable)

        connectivityObserver.observe().onEach {
            viewBinding.text123.text=it.toString()
        }.launchIn(lifecycleScope)
    }
}