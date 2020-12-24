package com.example.jonnyb.swoosh.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// create a base activity that other activities inherit from.
// base activity should log out whenever we transition to a different part of the android lifecycle. Log out the class' name and the lifecycle method being called.
open class BaseActivity : AppCompatActivity() {

    private val TAG = "LifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "${javaClass.name}: onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "${javaClass.name}: onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "${javaClass.name}: onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "${javaClass.name}: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "${javaClass.name}: onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "${javaClass.name}: onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "${javaClass.name}: onDestroy")
        super.onDestroy()
    }
}