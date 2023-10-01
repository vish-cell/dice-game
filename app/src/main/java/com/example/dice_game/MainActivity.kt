package com.example.dice_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.roll1)

        button1.setOnClickListener { rollDice1() }
    }

    fun rollDice1() {
        val roll1 = (1..6).random()
        val roll2 = (1..6).random()

        val result1: TextView = findViewById(R.id.score1)
        val result2: TextView = findViewById(R.id.score2)
        result1.text = (roll1 + roll2).toString()

        val image1: ImageView = findViewById(R.id.pic1)
        val image2: ImageView = findViewById(R.id.pic2)

        val drawableResource1 = when (roll1) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        val drawableResource2 = when (roll2) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        image1.setImageResource(drawableResource1)
        image2.setImageResource(drawableResource2)

        val winnerText: TextView = findViewById(R.id.winner)
        val winner = decideWinner(roll1, roll2)
        winnerText.text = "Winner: $winner"
    }

    // Function to decide the winner based on the dice rolls
    private fun decideWinner(roll1: Int, roll2: Int): String {
        return when {
            roll1 > roll2 -> "PLAYER 1"
            roll2 > roll1 -> "PLAYER 2"
            else -> "DRAW"
        }
    }
}
