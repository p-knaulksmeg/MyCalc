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

    private val EXPRESSION = "EXPRESSION"
    private lateinit var expressionInput: TextView
    private val calculator: ICalculator = Calculator()
    private val inputBuilder: IInputBuilder = InputBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        expressionInput = findViewById(R.id.expressionInput)
    }

    override fun onSaveInstanceState(outState: Bundle?) {

        outState?.putString(EXPRESSION, expressionInput.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        expressionInput.text = savedInstanceState.getString(EXPRESSION)
    }


    fun onDigit(view: View) {
        updateExpression(view)
    }

    fun onDecimalPoint(view: View) {
        updateExpression(view)
    }

    fun onOperator(view: View) {
        updateExpression(view)
    }

    fun onClear(view: View) {
        updateExpression(view)
    }


    fun onEqual(view: View) {
        val result = updateExpression(view).toString()

        if (result != "") {
            expressionInput.text = calculator.calculate(result)
        }
    }

    fun updateExpression(view: View){

        expressionInput.text = inputBuilder.build((view as Button).text, expressionInput.text.toString())
    }

}

