package com.example.jonnyb.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.jonnyb.swoosh.R
import com.example.jonnyb.swoosh.model.Player
import com.example.jonnyb.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    // We want this variable to be available to all class methods, but we can't assign a value until the activity is created. We can use 'lateinit' to promise that we will initialise this Player instance later on when onCreate is called (i.e. when the activity is initialised).
    lateinit var player : Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"
    }

    fun onSkillFinishedClick(view: View) {
        // if a skill has been selected i.e. is not an empty string
        if (player.skill != "") {
            // create an intent targeting the finish activity
            // add the skill data to the intent
            // add the league data to the intent
            // start the finish activity
            var intent = Intent(this, FinishActivity::class.java)
            intent.putExtra(EXTRA_PLAYER, player)

            startActivity(intent)
        } else {
            // else (if a skill has not been selected)
            // create a toast saying please select a skill and show the toast
            Toast.makeText(this, "Please select a skill", Toast.LENGTH_SHORT).show()
        }
    }
}