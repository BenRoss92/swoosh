package com.example.jonnyb.swoosh.controller

import android.os.Bundle
import com.example.jonnyb.swoosh.R
import com.example.jonnyb.swoosh.model.Player
import com.example.jonnyb.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        // Android doesn't know what the Parcelable Extra tye will be, so we need to explicitly specify it here as Player.
        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeaguesText.text = "Looking for a ${player.league} ${player.skill} league near you..."
    }
}