package com.example.tictactoe

import android.content.Intent
import android.hardware.biometrics.BiometricManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.view.ViewDebug
import android.widget.EditText
import android.widget.*
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val PVP_button = findViewById<View>(R.id.button2)
        val cancel_button = findViewById<View>(R.id.button)
        val PVC_button = findViewById<View>(R.id.button3)
        val greeding_text = findViewById<View>(R.id.textView)
        val player_name1 = findViewById<TextView>(R.id.name1)
        val player_name2 = findViewById<TextView>(R.id.editTextTextPersonName2)
        val Start_button = findViewById<View>(R.id.button4)
        val Start_buttonPVC = findViewById<View>(R.id.button6)


        player_name1.visibility = View.INVISIBLE
        player_name2.visibility = View.INVISIBLE
        Start_button.visibility = View.INVISIBLE
        cancel_button.visibility = View.INVISIBLE
        Start_buttonPVC.visibility = View.INVISIBLE

        PVP_button.setOnClickListener {
            PVP_button.visibility = View.INVISIBLE
            PVC_button.visibility = View.INVISIBLE
            greeding_text.visibility = View.INVISIBLE
            player_name1.visibility = View.VISIBLE
            player_name2.visibility = View.VISIBLE
            Start_button.visibility = View.VISIBLE
            cancel_button.visibility = View.VISIBLE
        }

        PVC_button.setOnClickListener {
            PVP_button.visibility = View.INVISIBLE
            PVC_button.visibility = View.INVISIBLE
            greeding_text.visibility = View.INVISIBLE
            player_name1.visibility = View.VISIBLE
            Start_buttonPVC.visibility = View.VISIBLE
            cancel_button.visibility = View.VISIBLE
        }

        cancel_button.setOnClickListener {
            PVP_button.visibility = View.VISIBLE
            PVC_button.visibility = View.VISIBLE
            greeding_text.visibility = View.VISIBLE
            player_name1.visibility = View.INVISIBLE
            player_name2.visibility = View.INVISIBLE
            Start_button.visibility = View.INVISIBLE
            cancel_button.visibility = View.INVISIBLE
            Start_buttonPVC.visibility = View.INVISIBLE
        }

        Start_button.setOnClickListener {
            var speles_rezims = 0
            val name1 = player_name1.text.toString()
            val name2 = player_name2.text.toString()
            val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
            intent.putExtra("name1", name1)
            intent.putExtra("name2", name2)
            intent.putExtra("speles_rezims", speles_rezims)
            startActivity(intent)
        }

        Start_buttonPVC.setOnClickListener {
            var speles_rezims = 1
            val name = player_name1.text.toString()
            val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
            intent.putExtra("name1", name)
            intent.putExtra("speles_rezims", speles_rezims)
            startActivity(intent)
        }
    }
}
