package by.paulk.mycalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import by.paulk.mycalc.inputBuilder.InputBuilder
import by.paulk.mycalc.calculator.Calculator
import by.paulk.mycalc.contracts.ICalculator
import by.paulk.mycalc.contracts.IInputBuilder

class MainActivity : AppCompatActivity() {

    lateinit var txtInput: TextView
    val calculator: ICalculator = Calculator()
    val inputBuilder: IInputBuilder = InputBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtInput = findViewById(R.id.txtInput)
    }

    override fun onSaveInstanceState(outState: Bundle?) {

        outState?.putString("EXPRESSION", txtInput.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        txtInput.text = savedInstanceState.getString("EXPRESSION")
    }


    fun onDigit(view: View) {
        txtInput.text = inputBuilder.build((view as Button).text,txtInput.text.toString());
    }

    fun onDecimalPoint(view: View) {
        txtInput.text = inputBuilder.build((view as Button).text,txtInput.text.toString());
    }

    fun onOperator(view: View) {
        txtInput.text = inputBuilder.build((view as Button).text,txtInput.text.toString());
    }

    fun onClear(view: View) {
        txtInput.text = inputBuilder.build((view as Button).text,txtInput.text.toString());
    }


    fun onEqual(view: View) {
        var result = inputBuilder.
            build((view as Button).text,
                txtInput.text.toString())

        if (result != "") {
            txtInput.text = calculator.calculate(result)
        }
    }


}

