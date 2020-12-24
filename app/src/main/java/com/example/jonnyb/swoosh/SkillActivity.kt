package com.example.jonnyb.swoosh

import android.os.Bundle
import android.util.Log

class SkillActivity : BaseActivity() {

    var league = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        Log.d("LEAGUE", league)
    }
}