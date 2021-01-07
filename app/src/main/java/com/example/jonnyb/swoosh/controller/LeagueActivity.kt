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

    // Activities get destroyed when the screen orientation changes (i.e. when the screen is rotated). Any data saved in memory, e.g. our Player instance, will be destroyed when the screen is rotated. To prevent a new empty instance of Player being created when this happens, we serialise and store the player instance from our old activity instance (the one about to be destroyed), adding it to the new version of state (outState) which will then be applied to the new Activity instance. onSaveInstanceState is called before the activity is destroyed. onRestoreInstanceState is called when the activity is recreated. The same instance of the Bundle object is passed into both of these lifecycle methods. The Bundle can be null if the activity has not been destroyed yet, so null handling is needed. We then get and deserialise the Player instance fro the new state and save it to a property inside of our new activity instance (the 'player' property). The result is that the user's league selection is remembered, even if the screen is rotated after the selection is made.
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

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
