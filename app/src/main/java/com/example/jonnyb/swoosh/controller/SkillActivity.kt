package com.example.jonnyb.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.jonnyb.swoosh.R
import com.example.jonnyb.swoosh.utilities.EXTRA_LEAGUE
import com.example.jonnyb.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBeginnerClick(view: View) {
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }

    fun onBallerClick(view: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun onSkillFinishedClick(view: View) {
        // if a skill has been selected i.e. is not an empty string
        if (skill != "") {
            // create an intent targeting the finish activity
            // add the skill data to the intent
            // add the league data to the intent
            // start the finish activity
            var intent = Intent(this, FinishActivity::class.java)
            intent.putExtra(EXTRA_LEAGUE, league)
            intent.putExtra(EXTRA_SKILL, skill)
            startActivity(intent)
        } else {
            // else (if a skill has not been selected)
            // create a toast saying please select a skill and show the toast
            Toast.makeText(this, "Please select a skill", Toast.LENGTH_SHORT).show()
        }
    }
}