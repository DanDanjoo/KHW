fun main () {
    println(" 환영합니다! 아무개의 계산기 입니다. ")

    while(true) {
        println(" 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/) 중 하나만 가능합니다. ex) 5 + 12 , 종료하시겠습니까? 'exit' ")
        val input = readLine()

        if (input.equals("exit", true)) {
            println("프로그램 종료!")
            break
        }
    }
}

class Calculator {


}
