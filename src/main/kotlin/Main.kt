fun main () {
    println(" 환영합니다! 아무개의 계산기 입니다. ")

    val calculator = Calculator()

    while(true) {
        println(" 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나누기 (%) 중 하나만 가능합니다. ex) 5 + 12 , 종료하시겠습니까? 'exit' ")
        val input = readLine()

        if (input.equals("exit", true)) {
            println("프로그램 종료!")
            break
        }

        val result = calculator.calculate(input)
        println("결과값: $result")

    }
}

class Calculator {

    fun calculate(input: String?): Int? {
        if (input == null) return null

        val bricks = input.trim().split(" ")
        if (bricks.size != 3) {
            println(" 수식을 바꿔주세요. ")
            return null
        }


    try
    {
        val amu1 = bricks[0].toInt()
        val operator = bricks[1]
        val amu2 = bricks[2].toInt()



        return when (operator) {
            "+" -> amu1 + amu2
            "-" -> amu1 - amu2
            "*" -> amu1 * amu2
            "/" -> amu1 / amu2
            "%" -> amu1 % amu2
            else -> {
                println("죄송합니다. 연산은 다섯가지만 가능합니다. ")
                null
            }

        }

    } catch (e: NumberFormatException) {
        println(" 잘못된 조작입니다. ")
        return null
    } catch (e: ArithmeticException) {
        println("0으로 나눌 수 없습니다.")
        return null
    }
 }
    }



