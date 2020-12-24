package com.example.jonnyb.swoosh.controller

import android.content.Intent
import android.os.Bundle
import com.example.jonnyb.swoosh.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        getStartedBtn.setOnClickListener {
            // send an intent (by creating it) that will contain both this activity's context information and the particular class (i.e. activity) that we want to target (and transition to).
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}
