package by.paulk.mycalc.calculator

import by.paulk.mycalc.contracts.ICalculator
import net.objecthunter.exp4j.ExpressionBuilder

class Calculator : ICalculator {

    override  fun calculate(input: String):String{

        val expression = ExpressionBuilder(input).build()
        try {
            val result = expression.evaluate()

            if ((result % 1) == 0.0){
                return result.toInt().toString()
            }
            else{
                return result.toString()
            }
        } catch (ex: ArithmeticException) {

            return "ERROR"
        }
    }


}