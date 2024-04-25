# 개인 프로젝트 - 계산기 만들기

## 🔍 클래스 다이어그램
![K-063](https://github.com/DanDanjoo/sparta/assets/162088392/384c289b-b727-485f-90ea-9fc3bebe9275)

### 😊 설명
입력 처리를 하는 부분 'main'과 연산을 처리하는 'Calculator'를 class로 나눴습니다.


####  while 반복문 응용

```
  while(true) {
        println(" 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나누기 (%) 중 하나만 가능합니다. ex) 5 + 12 , 종료하시겠습니까? 'exit' ")
        val input = readLine()
```
무한 루프(while(true))가 시작 되고, 계산기 기능을 설명하는 메시지가 출력됩니다. 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나누기(%) 중 하나만 선택 가능합니다.



#### 프로그램 종료 기능
 
```
                if (input == "exit") {
            println("프로그램 종료!")
            break
        }
```
입력이 "exit" 인지 확인하여 프로그램을 종료하고, 다른



#### Calculator 클래스 

```
class Calculator {

    fun calculate(input: String?): Int? {
        if (input == null) return null

        val bricks = input.trim().split(" ")
        if (bricks.size != 3) {
            println(" 수식을 바꿔주세요. ")
            return null
        }
```
.trim()은 문자열의 시작하는곳, 끝나는 곳의 공백을 제거하고, .Split()으로 문자를 기준으로 잘라 리스트로 반환해줍니다.  
*(" ") 띄어쓰기를 기준으로 출력값이 [33, +, 55] 3개의 요소를 가진 리스트가 됩니다.  
리스트, 배열에 size를 쓰면 요소가 몇 개인지 확인이 가능합니다.  
그래서 3개의 요소가 아닐때 " 수식을 바꿔주세요 " 라고 출력됩니다. 


### try catch문, 예외처리
```
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

```
bricks는 리스트입니다. 리스트의 첫번째 요소가 문자열이기 때문에, 정수로 바꿔줘야 합니다. .toInt()  
[0 1 2]은 입력값을 의미합니다. ex) 55[0] +[1] 6[2]  
만약 다섯가지 연산 이외 연산을 적용한다면, "죄송합니다. 연산은 다섯가지만 가능합니다." 라고 출력됩니다.  
입력된 문자열이 숫자 형식이 아닌 경우 발생하는 NumberFormatException을 잡아서 처리합니다.  
예외가 발생하면 "잘못된 조작입니다."라는 메시지를 출력하고 null을 반환하고,  
0으로 나누기에 발생할 수 있는 문제들은 ArithmeticException을 통해 처리합니다.  
예외가 발생하면 "0으로 나눌 수 없습니다."라는 메시지를 출력하고 null을 반환합니다.


#### 💻 프로그래밍 실행 예시시
![Desktop 2024 04 26 - 01 41 55 12 (1)](https://github.com/DanDanjoo/algorithm/assets/162088392/1282a1d9-42b6-4e64-a183-9fb956e2cbef)










## 📈 과제 요구사항
### 필수 구현 기능

- [ ]  Lv1
    - [ ]  더하기, 빼기, 나누기, 곱하기 연산을 수행할 수 있는 Calculator 클래스를 만들기
    - [ ]  생성한 클래스를 이용하여 연산을 진행하고 출력하기

- [ ]  Lv2
    - [ ]  Lv1에서 만든 Calculator 클래스에 “나머지 연산”이 가능하도록 코드를 추가하고, 연산 진행 후 출력
    - [ ]  ex) 나머지 연산 예시 : 6을 3으로 나눈 나머지는 0 / 5를 3으로 나눈 나머지는 2

- [ ]  Lv3
    - [ ]  아래 각각 클래스들을 만들고 클래스간의 관계를 고려하여 Calculator 클래스와 관계 맺기
        - [ ]  AddOperation(더하기)
        - [ ]  SubstractOperation(빼기)
        - [ ]  MultiplyOperation(곱하기)
        - [ ]  DivideOperation(나누기)
        - [ ]  관계를 맺은 후 필요하다면 Calculator 클래스의 내부코드를 변경
    - [ ]  `HINT` : 매개변수로 클래스를 주고 받아 객체를 주입하는 것이 핵심!

### 선택 구현 기능

- [ ]  Lv4
    - [ ]  아래 연산 클래스들을 AbstractOperation라는 클래스명으로 만들어 사용하여 추상 클래스로 정의하고 Calculator 클래스의 내부 코드를 변경합니다.
        - [ ]  AddOperation(더하기)
        - [ ]  SubtractOperation(빼기)
        - [ ]  MultiplyOperation(곱하기)
        - [ ]  DivideOperation(나누기)
    - [ ]  `HINT` : ‘상속’이라는 키워드로 찾아봅시다!

## ✉️ 과제 제출 방법
제출 링크 : https://nbcamp.spartacodingclub.kr/mypage/assignments 
- 제출 기한 : 04/26(금) 정오까지
    - 제출 이후, 해설 세션이 진행됩니다.
    - 해설 세션을 참고하고 보완해 다시 제출하고, 튜터님께 피드백을 받으러 찾아갑니다.
 
      
## 환경설정
Language : Kotlin  
IDEA : IntelliJ  
JDK : 17.0.10

