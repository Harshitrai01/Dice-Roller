package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = rollDice()

            // Do a dice Roll when app starts
            rollDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {

        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Find the ImageView in the layout
        val diceImage:ImageView=findViewById(R.id.imageView)


        // Update the screen with dice roll
//        val resultTextView: TextView = findViewById(R.id.textView)
//        resultTextView.text = diceRoll.toString()

        // Determine which drawable resource ID to use based on the dice roll
//        when (diceRoll) {
//                 // this rolls dice
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//        }

        /*
        A new concept here is that a when expression can actually return a value.
         With this new code snippet, the when expression returns the correct resource ID,
         which will be stored in the drawableResource variable. Then you can use that variable to update the image resource displayed.
        Notice that when is now underlined in red. If you hover your pointer over it,
        you'll see an error message: ‘when' expression must be exhaustive, add necessary ‘else' branch.
         */

        /*
        The error is because the value of the when expression is assigned to drawableResource,
        so the when must be exhaustive—it must handle all the cases possible so that a value is always returned,
        even if you change to a 12-sided dice. Android Studio suggests adding an else branch.
        You can fix this by changing the case for 6 to else. The cases for 1 through 5 are the same, but all others including 6 are handled by the else.
         */

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

