import operator.AddOperator
import operator.MultiplyOperator
import operator.SubtractOperator
import operator.DivideOperator
import operator.RemainOperator


fun main () {
    println("환영합니다! 아무개의 계산기입니다.")

    val calculator = Calculator()

    while(true) {
        println("덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나누기 (%) 중 하나만 가능합니다. ex) 5 + 12, 종료하시겠습니까? 'exit'")
        val input = readLine()

        if (input == "exit") {
            println("프로그램 종료!")
            break
        }

        val result = calculator.calculate(input)
        println("결과값: $result")

    }
}

class Calculator {

    fun calculate(input: String?): Double? {
        if (input == null) return null

        val bricks = input.trim().split(" ")
        if (bricks.size != 3) {
            println("수식을 바꿔주세요.")
            return null
        }

        try {
            val num1 = bricks[0].toDouble()
            val operator = bricks[1]
            val num2 = bricks[2].toDouble()

            return when (operator) {
                "+" -> add(AddOperator(), num1, num2)
                "-" -> subtract(SubtractOperator(), num1, num2)
                "*" -> multiply(MultiplyOperator(), num1, num2)
                "/" -> divide(DivideOperator(), num1, num2)
                "%" -> remain(RemainOperator(), num1, num2)
                else -> {
                    println("죄송합니다. 연산은 다섯가지만 가능합니다.")
                    null
                }
            }
        } catch (e: NumberFormatException) {
            println("잘못된 조작입니다.")
            return null
        } catch (e: ArithmeticException) {
            println("0으로 나눌 수 없습니다.")
            return null
        }
    }


    private fun add(operator: AddOperator, num1: Double, num2: Double): Double {
        return operator.operate(num1, num2)
    }

    private fun subtract(operator: SubtractOperator, num1: Double, num2: Double): Double {
        return operator.operate(num1, num2)
    }

    private fun multiply(operator: MultiplyOperator, num1: Double, num2: Double): Double {
        return operator.operate(num1, num2)
    }

    private fun divide(operator: DivideOperator, num1: Double, num2: Double): Double {
        return operator.operate(num1, num2)
    }
    private fun remain(operator: RemainOperator, num1: Double, num2: Double): Double {
        return operator.operate(num1, num2)
    }

}