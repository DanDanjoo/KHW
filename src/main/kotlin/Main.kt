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

