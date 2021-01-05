package com.tauseebpp.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        fun buclick(view:View){
            val buSelected :Button = view as Button
            var cellId=0
            when(buSelected.id){
                R.id.bu1 ->cellId = 1
                R.id.bu2 ->cellId = 2
                R.id.bu3 ->cellId = 3
                R.id.bu4 ->cellId = 4
                R.id.bu5 ->cellId = 5
                R.id.bu6 ->cellId = 6
                R.id.bu7 ->cellId = 7
                R.id.bu8 ->cellId = 8
                R.id.bu9 ->cellId = 9
            }

            //Log.d("buclick :",buSelected.id.toString())
            //Log.d("buclick : cellId",cellId.toString())
            playgame(cellId, buSelected)
        }

    var activeplayer=1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playgame(cellId:Int , buselected : Button){

        if(activeplayer == 1)
        {
            buselected.text = "X"
            buselected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activeplayer = 2
        }
        else
        {
            buselected.text = "O"
            buselected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellId)
            activeplayer = 1
        }

        buselected.isEnabled = false
        checkwinner()
    }

    fun checkwinner()
    {
        var winner = -1
        //row 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner=1
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner=2
        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner=1
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner=2
        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner=1
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner=2
        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner=1
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner=2
        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner=1
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner=2
        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner=1
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner=2
        //Diagonal
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner=1
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner=2
        //Diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner=1
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner=2

        if(winner==1)
        {
            Toast.makeText(this,"Player 1 win",Toast.LENGTH_LONG).show()
            restartGame()
        }
        else if(winner==2)
        {
            Toast.makeText(this,"Player 2 win",Toast.LENGTH_LONG).show()
            restartGame()
        }
        if(player1.size + player2.size==9)
        {
            Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show()
            restartGame()
        }
    }

    fun restartGame()
    {
        activeplayer =1
        player1.clear()
        player2.clear()
        for(cellId : Int in 1..9)
        {
            var buselected : Button ? = when(cellId){
                1->bu1
                2->bu2
                3->bu3
                4->bu4
                5->bu5
                6->bu6
                7->bu7
                8->bu8
                9->bu9
                else ->{bu1}
            }
            buselected!!.text=""
            buselected!!.setBackgroundResource(R.color.whiteblu)
            buselected!!.isEnabled =true
        }
    }
}