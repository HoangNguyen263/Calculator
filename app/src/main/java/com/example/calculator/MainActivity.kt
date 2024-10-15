package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.time.times

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var solutionTV: TextView
    lateinit var textResult: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        solutionTV = findViewById(R.id.solution_tv)
        textResult = findViewById(R.id.text_result)
        findViewById<Button>(R.id.btton0).setOnClickListener(this)
        findViewById<Button>(R.id.btton1).setOnClickListener(this)
        findViewById<Button>(R.id.btton2).setOnClickListener(this)
        findViewById<Button>(R.id.btton3).setOnClickListener(this)
        findViewById<Button>(R.id.btton4).setOnClickListener(this)
        findViewById<Button>(R.id.btton5).setOnClickListener(this)
        findViewById<Button>(R.id.btton6).setOnClickListener(this)
        findViewById<Button>(R.id.btton7).setOnClickListener(this)
        findViewById<Button>(R.id.btton8).setOnClickListener(this)
        findViewById<Button>(R.id.btton9).setOnClickListener(this)
        findViewById<Button>(R.id.bttonEqual).setOnClickListener(this)
        findViewById<Button>(R.id.bttonAdd).setOnClickListener(this)
        findViewById<Button>(R.id.bttonMinus).setOnClickListener(this)
        findViewById<Button>(R.id.bttonMultiply).setOnClickListener(this)
        findViewById<Button>(R.id.bttonDivide).setOnClickListener(this)
        findViewById<Button>(R.id.bttonC).setOnClickListener(this)
        findViewById<Button>(R.id.bttonCE).setOnClickListener(this)
        findViewById<Button>(R.id.bttonBS).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val id = p0?.id
        if (id == R.id.btton0) {
            addDigit(0)
        } else if (id == R.id.btton1) {
            addDigit(1)
        } else if (id == R.id.btton2) {
            addDigit(2)
        } else if (id == R.id.btton3) {
            addDigit(3)
        } else if (id == R.id.btton4) {
            addDigit(4)
        } else if (id == R.id.btton5) {
            addDigit(5)
        } else if (id == R.id.btton6) {
            addDigit(6)
        } else if (id == R.id.btton7) {
            addDigit(7)
        } else if (id == R.id.btton8) {
            addDigit(8)
        } else if (id == R.id.btton9) {
            addDigit(9)
        } else if (id == R.id.bttonAdd) {
            solutionTV.setText("$op1 + ")
            op = 1
            state = 2
        } else if (id == R.id.bttonMinus) {
            solutionTV.setText("$op1 -")
            op = 2
            state = 2
        } else if (id == R.id.bttonDivide) {
            solutionTV.setText("$op1 /")
            op = 3
            state = 2
        } else if (id == R.id.bttonMultiply) {
            solutionTV.setText("$op1 *")
            op = 4
            state = 2
        } else if (id == R.id.bttonEqual) {
            var result = 0
            if (op == 1 ) {
                result = op1 + op2

            } else if (op == 2) {
                result = op1 - op2
            }
            else if (op == 3) {
                result = op1 / op2
            }
            else if (op == 4) {
                result = op1 * op2
            }
            textResult.setText("$result")
            state = 1
            op1 = 0
            op2 = 0
            op = 0
        } else if (id == R.id.bttonC) {
            solutionTV.setText("")
            textResult.setText("")
            state = 1
            op1 = 0
            op2 = 0
            op = 0
        }

    }

    fun addDigit(c: Int) {
        if (state == 1) {
            op1 = op1 * 10 + c
            solutionTV.setText("$op1")
        } else {
            op2 = op2 * 10 + c

            if (op == 1 ) {
                solutionTV.setText("$op1 + $op2")

            } else if (op == 2) {
                solutionTV.setText("$op1 - $op2")
            }
            else if (op == 3) {
                solutionTV.setText("$op1 / $op2")
            }
            else if (op == 4) {
                solutionTV.setText("$op1 * $op2")
            }

        }
    }
}