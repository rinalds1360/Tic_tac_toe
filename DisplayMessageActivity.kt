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
import java.util.*
import kotlin.random.Random.Default.nextInt


class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val intent = getIntent()
        var name1 =intent.getStringExtra("name1")
        var name2 =intent.getStringExtra("name2")
        val gameMode = intent.getIntExtra("speles_rezims",0)
        val Button1 = findViewById<View>(R.id.Btn1)
        val Button2 = findViewById<View>(R.id.Btn2)
        val Button3 = findViewById<View>(R.id.Btn3)
        val Button4 = findViewById<View>(R.id.Btn4)
        val Button5 = findViewById<View>(R.id.Btn5)
        val Button6 = findViewById<View>(R.id.Btn6)
        val Button7 = findViewById<View>(R.id.Btn7)
        val Button8 = findViewById<View>(R.id.Btn8)
        val Button9 = findViewById<View>(R.id.Btn9)
        val exitButton = findViewById<View>(R.id.button5)
        var Button1_activited = false
        var Button2_activited = false
        var Button3_activited = false
        var Button4_activited = false
        var Button5_activited = false
        var Button6_activited = false
        var Button7_activited = false
        var Button8_activited = false
        var Button9_activited = false
        val myTxt = findViewById<TextView>(R.id.editTxt)
        val krustins = resources.getDrawable(R.drawable.output_onlinepngtools,theme)
        val aplis = resources.getDrawable(R.drawable.circle,theme)
        var player1 = IntArray(5)
        var player2 = IntArray(5)
        var spelet1 = 0
        var spelet2 = 0
        var rand = 0
        var kamgajiens = 0
        player1[0]=0; player1[1]=0; player1[2]=0; player1[3]=0; player1[4]=0;
        player2[0]=0; player2[1]=0; player2[2]=0; player2[3]=0; player2[4]=0;

        fun forComp(sen: Int):Boolean {
            when (sen) {
                1 -> if (Button1_activited) { return true}
                2 -> if (Button2_activited) { return true}
                3 -> if (Button3_activited) { return true}
                4 -> if (Button4_activited) { return true}
                5 -> if (Button5_activited) { return true}
                6 -> if (Button6_activited) { return true}
                7 -> if (Button7_activited) { return true}
                8 -> if (Button8_activited) { return true}
                9 -> if (Button9_activited) { return true}
            }
            return false
        }

        fun turnComp(){
            if ((gameMode == 1) and (kamgajiens % 2 ==1)) {
                rand = (1..9).random()
                var x = 0
                while (forComp(rand) and (x<40)) {
                    rand = (1..9).random()
                    x=x+1
                }
                when (rand) {
                    1 -> Button1.performClick()
                    2 -> Button2.performClick()
                    3 -> Button3.performClick()
                    4 -> Button4.performClick()
                    5 -> Button5.performClick()
                    6 -> Button6.performClick()
                    7 -> Button7.performClick()
                    8 -> Button8.performClick()
                    9 -> Button9.performClick()
                }
            }
        }

        if (gameMode == 1) {
            name2 = "Dators"
        }

        if (name1 == ""){
            name1 = "Player 1"
        }

        if (name2 == ""){
            name2 = "Player 2"
        }

        fun combo2(val0: Int, val1: Int, val2: Int):Boolean {
            var com: String = "" + val0 + " " + val1 + " " + val2
            when (com) {
                "1 2 3" -> return true
                "1 3 2" -> return true
                "2 1 3" -> return true
                "2 3 1" -> return true
                "3 1 2" -> return true
                "3 2 1" -> return true

                "4 5 6" -> return true
                "4 6 5" -> return true
                "5 4 6" -> return true
                "5 6 4" -> return true
                "6 4 5" -> return true
                "6 5 4" -> return true

                "7 8 9" -> return true
                "7 9 8" -> return true
                "8 7 9" -> return true
                "8 9 7" -> return true
                "9 7 8" -> return true
                "9 8 7" -> return true

                "1 4 7" -> return true
                "1 7 4" -> return true
                "4 1 7" -> return true
                "4 7 1" -> return true
                "7 1 4" -> return true
                "7 4 1" -> return true

                "2 5 8" -> return true
                "2 8 5" -> return true
                "5 2 8" -> return true
                "5 8 2" -> return true
                "8 2 5" -> return true
                "8 5 2" -> return true

                "3 6 9" -> return true
                "3 9 6" -> return true
                "6 3 9" -> return true
                "6 9 3" -> return true
                "9 3 6" -> return true
                "9 6 3" -> return true

                "1 5 9" -> return true
                "1 9 5" -> return true
                "5 1 9" -> return true
                "5 9 1" -> return true
                "9 1 5" -> return true
                "9 5 1" -> return true

                "3 5 7" -> return true
                "3 7 5" -> return true
                "5 3 7" -> return true
                "5 7 3" -> return true
                "7 3 5" -> return true
                "7 5 3" -> return true
                else -> {
                    return false
                }
            }
        }

        fun combo1(val0: Int, val1: Int, val2: Int):Boolean{
            if (combo2(val0, val1, val2) == false) {
                if (combo2(val0, val2, val1) == false) {
                    if (combo2(val1, val0, val2) == false) {
                        if (combo2(val1, val2, val0) == false) {
                            if (combo2(val2, val0, val1) == false) {
                                if (combo2(val2, val1, val0) == false) {
                                        return false
                                } else {
                                    return true
                                }
                            } else {
                                return true
                            }
                        } else {
                            return true
                        }
                    } else {
                        return true
                    }
                } else {
                    return true
                }
            } else {
                return true
            }
        }

        fun checkWinning(fig: IntArray):Boolean {
            if (combo2(fig[0],fig[1],fig[2])) {return true}
            if (combo2(fig[0],fig[1],fig[3])) {return true}
            if (combo2(fig[0],fig[1],fig[4])) {return true}
            if (combo2(fig[0],fig[2],fig[3])) {return true}
            if (combo2(fig[0],fig[2],fig[4])) {return true}
            if (combo2(fig[0],fig[3],fig[4])) {return true}
            if (combo2(fig[1],fig[2],fig[3])) {return true}
            if (combo2(fig[1],fig[2],fig[4])) {return true}
            if (combo2(fig[1],fig[3],fig[4])) {return true}
            if (combo2(fig[2],fig[3],fig[4])) {return true}
            return false
        }

        fun uzvara(){
            Button1_activited = true
            Button2_activited = true
            Button3_activited = true
            Button4_activited = true
            Button5_activited = true
            Button6_activited = true
            Button7_activited = true
            Button8_activited = true
            Button9_activited = true
        }

        myTxt.text = "Gājiens: " + name1;

        exitButton.setOnClickListener {
            finish()
        }

        Button1.setOnClickListener {
            if (Button1_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button1.background = krustins
                    player1[spelet1] = 1
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button1.background = aplis
                    player2[spelet2] = 1
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button1_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button2.setOnClickListener {
            if (Button2_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button2.background = krustins
                    player1[spelet1] = 2
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button2.background = aplis
                    player2[spelet2] = 2
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button2_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button3.setOnClickListener {
            if (Button3_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button3.background = krustins
                    player1[spelet1] = 3
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button3.background = aplis
                    player2[spelet2] = 3
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button3_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button4.setOnClickListener {
            if (Button4_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button4.background = krustins
                    player1[spelet1] = 4
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button4.background = aplis
                    player2[spelet2] = 4
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button4_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button5.setOnClickListener {
            if (Button5_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button5.background = krustins
                    player1[spelet1] = 5
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button5.background = aplis
                    player2[spelet2] = 5
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button5_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button6.setOnClickListener {
            if (Button6_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button6.background = krustins
                    player1[spelet1] = 6
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button6.background = aplis
                    player2[spelet2] = 6
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button6_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button7.setOnClickListener {
            if (Button7_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button7.background = krustins
                    player1[spelet1] = 7
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button7.background = aplis
                    player2[spelet2] = 7
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button7_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button8.setOnClickListener {
            if (Button8_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button8.background = krustins
                    player1[spelet1] = 8
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button8.background = aplis
                    player2[spelet2] = 8
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button8_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }

        Button9.setOnClickListener {
            if (Button9_activited == false) {
                if (kamgajiens % 2 == 0) {
                    Button9.background = krustins
                    player1[spelet1] = 9
                    spelet1 = spelet1 + 1
                    if (checkWinning(player1)) {
                        myTxt.text = "Uzvarēja " + name1;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name2;
                    }

                } else {
                    Button9.background = aplis
                    player2[spelet2] = 9
                    spelet2 = spelet2 + 1
                    if (checkWinning(player2)) {
                        myTxt.text = "Uzvarēja " + name2;
                        uzvara()
                    } else {
                        myTxt.text = "Gājiens: " + name1;
                    }
                }
                kamgajiens = kamgajiens + 1
                Button9_activited = true
                turnComp()
                if ((kamgajiens == 9)and((checkWinning(player1)or(checkWinning(player2))) == false)){
                    myTxt.text = "Neizšķirts";
                }
            }
        }
    }
}
