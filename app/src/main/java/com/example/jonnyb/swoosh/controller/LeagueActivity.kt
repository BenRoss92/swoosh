package com.example.jonnyb.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.jonnyb.swoosh.R
import com.example.jonnyb.swoosh.model.Player
import com.example.jonnyb.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        womensLeagueBtn.isChecked = false
        coEdLeagueBtn.isChecked = false

        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coEdLeagueBtn.isChecked = false

        player.league = "womens"
    }

    fun onCoEdClicked(view: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)

            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
        }
    }
}
