package com.kjy.kotlinpractice

import java.util.*


// 코틀린 문법 총정리!!!
// 주석

/*

 */

// 코틀린 표기법
// 클래스 이름은 파스칼 표기법 : 모든 단어를 대문자로 시작

// 함수나 변수 이름은 카멜 표기법 : 첫단어만 소문자로 시작

// 변수 선언
/*
1. var : 일반적으로 통용되는 변수, 언제든지 읽고 쓰기 가능

2. val : 선언시에서만 초기화 가능 , 중간에 값을 변경할 수 없음

* Runtime시 변경되지 말아야 할 값은 안전하게 val 로 선언하는 것이 좋음

- 클래스에 선언된 변수 = property(속성)
- 이외의 Scope 내에 선언된 변수 = Local Variable(로컬 변수)

- 코틀린의 특징

고전적인 언어들은 변수가 선언된 후
초기화 되지 않으면 기본값으로 초기화 되거나
값이 할당되지 않았다는 표시로 null 값을 가지게 됌

코틀린은 기본 변수에서 null을 허용하지 않으며
또한 변수에 값을 할당하지 않은채로 사용하게 되면 문법 에러를 표시하고 컴파일을 막아주므로
의도치 않은 동작이나 nullpointerException 등을 원천적으로 차단해준다.

프로그램에 따라서는 변수에 값이 할당되지 않았다는 것을
하나의 정보로 사용하는 경우도 있을 수 있음.


-- 코틀린 입력 받을시: readLine() 이용 자바의 Scanner와 동일 --
 ** 사용시 주의사항 **
 기본적으로 입력을 문자열로만 받기 때문에 다른 형태로 사용하기 위해서는 형변환을 해주어야 한다.
 형변환을 해줄때에는 엘비스 연산자나 !!로 에러를 막는다.

 ex)

 var name = readLine()
 var size : Int = readLine()!!.toInt()

fun main() {

var a:Int? = null

}

== > nullable 변수 = 값이 null 인상태로 연산할시 nullpointerException 발생 가능성 있으므로
필요한 경우에만 사용 할것

-- 만약 변수의 값이 null일 수 있다는 것을 표시하기 위해서는 ?로 표시해줌.
?: 변수의 값이 null일 수 있따는 것을 표시(?를 표시 하지 않으면 선언시 null이 될 수 없음)

 */
/*


자료형 종류 >
정수형 >
Byte -> 8bits
short -> 16bits
Int -> 32bits
Long -> 64bits

실수형 >
float -> 32bits
double -> 64bits


var intValue:Int = 1234
var longValue: Long = 1234L
var intValueByHex : Int = 0x1af     -> 16진수
var intValueByBin : Int = 0b10110110 -> 2진수

코틀린은 8진수는 지원하지 않음

실수형

var doubleValue : Double = 123.5
var doubleValueWithExp : Double = 123.5e10
var floatValue : Float = 123.5f

문자형

코틀린은 글자 하나하나가 2byte = 16bits 크기의 값을 사용함

var charValue: Char = 'a'

var koreanCharValue : Char = '가'

특수문자의 종류
\t : 탭 , \b : 백스페이스 , \r: 첫 열로 커서 옮김, \n : 개행, \': 작은 따옴표,
\" : 큰 따옴표, \\ : 역슬래시, \$:  $문자, \uxxxx 유니코드 문자


논리형

true인지 false인지 둘 중 하나를 저장하는 값

var booleanValue : Boolean = true

var booleanValue : Boolean = false

문자형

val stringValue = "one line string test"


-- 여러줄 사용시에 --
""" 여러줄의
   문자열 """
val multiLineStringValue = """ multiline

string
test"""""


// 코틀린의 형변환과 배열

형변환: 하나의 변수에 지정된 자료형을 호환되는 다른 자료형으로 변경하는 기능

숫자형, 문자형은 변환이 가능하나 논리형은 불가능

형변환 함수 : 자료형 앞에 to를 붙여서 지정한다.

toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()

 // 명시적 형변환
   // 변환될 자료형을 개발자가 직접 지정


 // 암시적 형변환
 변수를 할당할 시 자료형을 지정하지 않아도 자동으로 형변환 됨

 코틀린은 암시적 형변환을 지원하지 않음

 // 배열

 var intArr = arrayOf(1, 2, 3, 4, 5)

 // 특정한 크기를 가지고 있는 비어있는 배열을 만들시

 var nullArr = arrayOfNulls<Int>(5)

 intArr[2] = 8

 println(intArr[4])

 --> 해당 index 위치에 값을 할당

 배열은 처음 선택했을때의 크기를 변경할 수 없다는 단점이 있지만 한번 선언을 해두면 다른 자료구조보다 빠른 입출력이 가능하다는 장점이 있음


 // 코틀린의 타입 추론과 함수

 -- 타입 추론 --

 변수나 함수들을 선언할때나 연산이 이루어 질때 자료형을 코드에 명시하지 않아도 코틀린이 자동으로 자료형을 추론해주는 기능

-- 함수 --

특정한 동작을 하거나 원하는 결과값을 연산하는데 사용


//함수를 만들시에 괄호안에 변수의 자료형을 지정해주고 : 다음 자리에 반환하는 값의 자료형을 써준다.(반환형)

// return 이 발생한다면 함수의 중간이더라도 값을 반환하고 함수를 종료하게 된다.
fun main() {

    println(add(5,6,7))


}

fun add(a: Int, b:Int, c:Int):Int {

    return a+b+c
}

이를 단일 표현식 함수로 고친다면

fun main() {

    println(add(5,6,7))

}

fun add(a:Int, b:Int, c:Int) = a + b + c

단일 표현식 함수에서는 반환형의 타입추론이 가능하므로 반환형 생략 가능


// 조건문과 비교연산자

if문

비교연산자

<, <= , > , >= , !=

==  equal 두개 사용

is 연산자 와 !is

is : 변수 호환 여부 체크 ,  형변환까지 한번에 진행시켜줌

* When
-> 하나의 변수를 여러개의 값과 비교 가능


fun main() {

    doWhen(1)
    doWhen("DiMo")
    doWhen(12L)
    doWhen(3.14159)
    doWhen("Kotlin")


}

fun doWhen(a: Any) { // Any: 최상위 자료형
    when(a) {
         1 -> println("정수 1입니다")
         "DiMo" -> println("디모의 코틀린 강좌입니다")
         is Long -> println("Long 타입 입니다.")
         !is String -> println("String 타입이 아닙니다")
         else -> println ("어떤 조건도 만족하지 않습니다.")
    }
}

// 반복문과 증감연산자

-- 반복문의 종류 --

1) 조건형 반복문 : 조건이 참인 경우 반복을 유지

2) 범위형 반복문 : 반복 범위를 정해 반복을 수행

-- 증감 연산자 --

++a , -- a == 전위 연산자 : 연산자가 포함된 구문에서 이미 증감된 수를 반영하여 연산이 진

a++, a-- == 후위연산 : 증가나 감소된 수를 해당 구문에서 사용하지 않고 '다음 구문'부터 사용한다는 다른점이 있음




fun main () {

    var a = 0

    do
    {
        println(a++)
    }
    while (a < 5)
}

// for : 최신 언어들이 제공하는 이해하기 쉬운형태로 사용 가능


fun main () {

    for(i in 0..9) {
    print(i)
    }
   }

   in ? 뒤에 step 번호 사용시 번호만큼 띄어서 출력

   downTo 감소하며 반복

   // 흐름제어와 논리연산자

   1. return : 함수를 종료 하고 값을 '반환' 하는 역할을 함
   2. break : 반복문 내의 구문이 실행되는 중간에 즉시 반복문을 '종료'하고 다음 구문으로 넘어가는 역할을 하며
   3. continue : 다음 반복문으로 즉시 넘어가는 역할을 한다.

   @loop 레이블 기준으로 즉시 break 이나 continue 문 실행시켜줌

   fun main() {

    loop@for (i in 1..10) {
        for(j in 1..10) {
            if(i == 1 && j == 2) break@loop
            println("i : $i, j : $j")
        }
    }
}

// 위의 예시를 보면 i = 1 , j=1 이고 그후 break 이 실행되었음
fun main() {

    for (i in 1..10) {
        if(i == 3) continue
        println(i)
    }
}


-- @label 예시 --

fun main() {
    awd@for(i in 0..10) {
        for(j in 0..10) {
            if (i == 0 && j == 3) {
                break@awd
            }
            println("$i, $j")
        }
    }
}





-- 논리연산자 --

새로운 논리값을 도출할때 쓰는 연산자
&& , ||, !

&&: true && true 둘다 true 인 경우

|| : true || false 둘 중 하나라도 true 인 경우

! : 뒤에 붙는 값을 반전시킴

-- Scanner로 입력받기 --

사용자로부터 데이터를 입력 받기 위해서는 Scanner 객체에 System.in(InputStream)을 넣어서 생성한 인스턴스를 사용해야 한다.
System.in은 키보드와 연결 된 자바의 표준 입력 스트림으로 사용자가 키보드를 통해 입력한 데이터를 컴퓨터를 통해 프로그램에 전달해주는 역할을 한다.
Scanner객체는 System.in을 통해 전달 된 데이터를 언어의 기본타입으로 변환해주는 역할을 한다.

-- Scanner의 기본 형태 --

fun main(args: Array<String>) {
    val sc: Scanner = Scanner(System.`in`)


    또는


fun main(args: Array<String>) = with(Scanner(System.`in`)) {

}



-- Scanner 기본 예시 --


fun main(args: Array<String>) {

    val sc: Scanner = Scanner(System.`in`)

    val name = sc.nextLine()
    val age = sc.nextInt()

    println("name: $name,  age: $age")

}

<Scanner 객체에서 사용하는 주요 메소드들>

next(): String! = String 타입으로 리턴
nextByte(): Byte = Byte 타입으로 리턴
nextShort() : Short = Short 타입으로 리턴
nextInt() : Int = Int 타입으로 리턴
nextLong() : Long = Long 타입으로 리턴
nextFloat() : Float = Float 타입으로 리턴턴
nextDouble(): Double = Double 타입으로 리턴
nextLine(): '\n'을 포함하는 한 라인을 읽고 '\n'을 버린 나머지 문자열을 String 타입으로 리턴


fun main(args: Array<String>) {

    val scan: Scanner = Scanner(System.`in`)
    var num : Int
    var flag : Boolean = true

    while (true) {
        flag = true
        println("정수 n을 입력하세요 (0 입력시 프로그램 종료)")
        num = scan.nextInt()
        if (num == 0) {
            println("종료")
            break
        }

        for(i in num-1 downTo 2) {
            if(num % i == 0) {
                flag = false
                break
            }
        }
        if(flag == false) {
            println("num은 소수가 아닙니다.")

        }else {
            println("num은 소수 입니다.")
        }
    }


}

-- 클래스 --
기본형: 클래스 형태는 class 클래스 이름(속성 이름: type)
자바랑 다르게 코틀린은 생성자를 따로 만들어주지 않아도 된다.
객체를 생성할 때 속성 따라 값을 입력해주면 된다.

fun main() {
    var a = Prs("awd", 23)

    println("${a.birth}, ${a.name}")
    a.introduce()
}

class Prs(var name: String, val birth:Int) {
    fun introduce() {
        println("$name $birth")
    }
}

-- init --

보통 자바에서는 생성자를 만들면 구문을 수행하는 기능을 넣을 수 있다(ex: 속성출력)
하지만 위 코드처럼 생성자를 만들면 생성자를 실행하면서 구문을 넣을 수 없었다.
init을 사용하여 생성자를 출력했을 시 구문이 실행되게 할 수 있다.
init은 여러개 둘 수 있다.


fun main() {

    var a = Prs("awd", 23)

}

class Prs(var name:String, var birth: Int) {
    init{
        println("${this.name} ${this.birth}")
    }
    init {
        println(1)
    }
}

-- Constructor(보조 생성자)

constructor 오버로딩 생성자를 만들 수 있다.


fun main() {

    var a = Prs("awd")

}


class Prs(var name: String, var birth: Int) {

    //this를 이용해 기본 생성자로 값을 넘겨줘야 한다.

    constructor(name:String): this(name, 23)
    init {

        println("${this.name} ${this.birth}")
    }


}

-- 상속

클래스를 상속할 때 부모 클래스는 open 이라는 키워드가 있어야 상속이 가능하다.
또한 서브 클래스의 속성들은 부모 클래스의 속성과 이름이 같으면 안된다.
함수를 override할 때는 override 키워드 사용
함수를 override할 때도 부모 클래스의 함수에 open 키워드를 사용해야 함.

fun main() {
    var dog = Dog("a", 12)
    dog.introduce1()
    dog.introduce()


}

open class Animal(var name: String, var age: Int, var type : String) {
    open fun introduce() {
        println("${this.name}, ${this.age}, ${this.type}")
    }

}

class Dog(var name1: String, var age1 : Int): Animal(name1, age1, "강아지"){

    fun introduce1() {
        super.introduce()
    }

    override fun introduce() {
        println("override")
    }
}

-- 추상 클래스 --

자바와 동일함

abstract class 사용
fun main() {
    var dog = Dog("a", 12)
    dog.introduce1()
    dog.introduce()


}

open class Animal(var name: String, var age: Int, var type : String) {
    open fun introduce() {
        println("${this.name}, ${this.age}, ${this.type}")
    }

}

class Dog(var name1: String, var age1 : Int): Animal(name1, age1, "강아지"){

    fun introduce1() {
        super.introduce()
    }

    override fun introduce() {
        println("override")
    }
}

-- 인터페이스 --

코틀린에서 인터페이스는 자바 인터페이스와 다르게
추상 함수만 있는게 아니라 속성과 일반 함수도 선언할 수 있다. 하지만 생성자는 생성 불가
구현부가 있는 함수 -> open함수로 간주
구현부가 없는 함수 -> abstract 함수로 간주

// 인터페이스

fun main() {
    var a = Dog(1)
    a.eat()
    a.run()


}

interface Runner{

    fun run()
}

interface Eater{
    fun eat() {
        println("awd")
    }
}
class Dog(var a: Int) : Runner, Eater {
    override fun run() {
        println("run")

    }

    override fun eat() {
        println("eat")
    }
}

// 접근제한자

자바와 쓰는 방법은 동일, 단 메소드에 아무것도 쓰지 않을시 (기본값): public (자바는 protected)

public: 클래스 외부에서 접근 가능
private : 클래스 내부에서만 접근 가능
protected : 클래스 자신과 상속받은 클래스 접근 가능

-- 고차함수 / 람다함수 --

고차함수 : 함수를 클래스에서 만들어낸 인스턴스처럼 취급하는 방법
-> 함수를 파라미터로 넘겨줄 수 있음
-> 결과값으로도 반환받을 수 있음


fun main() {


    b(::a) // 함수를 넘겨줄때 :: 을 붙인다.

    // 람다 함수로 작성된 c
    // (입력 타입) -> 반환타입 = {변수이름: 입력타입 -> 구문}
    // 아래 두개의 c, d 처럼 타입 생략 가능

    var c: (String) -> Unit = {s -> println(s)}
    var d = {s: String -> println(s)}
    var e = {s: String -> s }       // s를 반환하라는 소리
    var f = {                       // 인자가 없는 경우
        println("xzcxc")
    }
    var g : (String)->Unit = {println(it)}  // 인자가 하나일 경우 it 키워드 사용

    c("zxc")
    d("sss")
    println(e("ccc"))
    f()
    g("qqq")
}

fun a(str: String): String {
    return str
}

fun b(funs: (String) -> String) {
    // 가져온 함수에 인자를 넣어 실행
    println(funs("awds"))
}


-- 스코프 함수 --
함수형 언어를 좀 더 편리하게 사용할 수 있도록 하는 기본 함수
apply, run, with, also, let이 있음

-> apply

인스턴스의 값을 람다함수를 사용해 변경할 수 있는 함수 그리고 변경된 객체를 반환
예제를 보고 이해하는게 빠르다

장점 : 코드가 깔끔해짐

fun main() {

    var a = Book("a", 20000)
    // apply 스코프람다함수를 통해 a객체의 속성과 함수 변경 및 사용가능
    a.apply {
        name = "apply $name"
        // 2000감소
        dc()
    }
    a.printName()
}

class Book(var name: String, var price : Int) {
    fun dc() {
        price -= 2000
    }

    fun printName() {
        println("$name $price")
    }

}

-> run
apply 와 똑같은 기능이지만 마지막 구문에 있는 값을 반환해주는 차이가 있음
fun main() {
    var a = Book("a", 20000)
    var b = a.run {
        name = "apply $name"
        dc()
        "zxc"       // 반환
    }
    print(b)

}

class Book(var name: String, var price : Int) {

    fun dc() {
        price -= 2000
    }

    fun printName() {
        println("$name $price")
    }
}

-> with : run과 똑같지만 사용법만 다름
a.run -> with(a)


fun main() {

    var a = Book("a", 20000)
    var b = with(a) {               // a.run
        name = "apply $name"
        dc()
        "zxc"

    }
    print(b)
}

class Book(var name: String, var price: Int) {
    fun dc() {
        price -= 2000
    }

    fun printName() {
        println("$name $price")

    }
}

-> let / also

apply = alse
run = let

기능은 위처럼 같다.
하지만, also, let의 공통된 차이점은 it 키워드를 사용해 객체 변수를 참조한다는 것.
이유는 같은 이름 변수로 혼동이 올 수 있기 때문


fun main() {

    var price = 5000
    var a = Book("a", 20000)
    a.run{

        // 20000원이 출력되야하지만 main문의 price가 스코프 우선순위가 높아 5000원 출력
        println(price)
    }
}

class Book(var name: String, var price: Int) {


}


// let

fun main() {

    var price = 5000
    var a = Book("a", 20000)
    a.let {
        println(it.price)
    }

}

class Book(var name: String, var price: Int) {

}

-- Object --

객체가 하나만 필요해서 사용하는 경우에 쓰는 키워드 -> 싱글톤 디자인 패턴

class 안에도 object를 만들 수 있는데, 기존 JAVA에서 static이랑 비슷하다 생각하면 된다.
키워드는 companion object


// Object

fun main() {

    Counter.countUp()
    println(Counter.count)
    Counter.clear()
    println(Counter.count)


}

object Counter {
    var count = 0
    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }

}

// companion object

// companion object

fun main(){

    var a = Food()
    var b = Food()
    a.up()          // 공용 변수 증가
    b.up()          // 공용 변수 증가
    println("${Food.total}")
}

class Food() {
    companion object {

        var total = 0
    }
    fun up() {
        total++
    }
}

-- 옵저버 패턴 --

listener , callback 이라고 부른다.
간단히 말하면, 어떠한 이벤트가 발생을 감시해 이벤트 발생시 기능이 호출되도록 하는 패턴이다.



// Observe pattern

fun main() {

    EventPrinter().start()
}

interface EventListener{

    fun onEvent(count: Int)

}

class Counter(var listener: EventListener) {
    fun count() {

        for(i in 0..20) {
            if(i % 5 == 0) {
                listener.onEvent(i)
            }

        }

    }
}

class EventPrinter: EventListener {
    override fun onEvent(count: Int) {
        println(count)
    }
    fun start() {
        var count = Counter(this)
        count.count()
    }
}

// Observe pattern

// class EventPrinter : 이벤트를 수신해서 출력
// class Counter : 숫자를 카운트 하며 5의 배수마다 이벤트를 발생 시킬 Counter

// 위 두개를 연결 할 interface : EventListener


fun main() {

    // 1. Counter가 5의 배수마다 이벤트를 발생시킴
    // 2. EventPrinter 내에서 구현된 EventListener에서 출력
    EventPrinter().start()


}

// 이벤트가 발생할 때 숫자를 반

interface EventListener {
    fun onEvent(count:Int)

}

// 이벤트가 발생하는 Counter

class Counter(val listener: EventListener) {
    fun count() {
        for (i in 0..20) {
            if ( i % 5 ==0) {
                listener.onEvent(i)
            }
        }
    }
}

// 이벤트를 받아서 화면에 출력할 Event Printer

class EventPrinter {
    fun start() {
        // EventListener 구현부 넘겨줌
        // 리스너를 익명클래스로 정의
        Counter(object: EventListener{
            override fun onEvent(count: Int) {
                println(count)
            }
        }).count()
    }
}
환

-- 다형성 as --

Up-Casting

상위 자료형인 수퍼클래스로 변환

Down-Casting

- Up-Casting 된 인스턴스를 다시 하위 자료형으로 변환.
- Down-Casting은 '별도의 연산자'가 필요함.

-> as

변수를 호환되는 자료형으로 변환해주는 캐스팅 연산자. 반환도 가능

var a: Dring = Cola()
var b = a as Cola

-> is

변수가 자료형에 호환되는지를 먼저 체크한 후 변환해주는 캐스팅 연산자. 조건문 내에서 사용
var a: Dring = Cola()
if (a is Cola)
{
// 이 안에서만 a가 cola가 됨

}


// 다형성 as

fun main() {

    var a = Drink()
    a.drink()

    var b: Drink = Cola()
    b.drink()

    if(b is Cola) { // if문 알에서 일시적 캐스팅
        b.washD()

    }

    // Cola로 캐스팅된 c 동시에 b도 캐스팅이 된다.
    var c = b as Cola
    c.washD()
    b.washD()
}

open class Drink{
    var name = "음료"
    open fun drink() {
        println("${name}을 마십니다.")
    }
}

class Cola: Drink() {
    var type = "콜라"
    override fun drink() {
        println("${type}을 마십니다.")
    }

    fun washD() {
        println("${type}으로 설거지 합니다.")
    }
}


-- Generic(제네릭) --

클래스나 함수에서 사용하는 자료형을 외부에서 지정할 수 있는 기능
함수나 클래스를 선언할 때 고정적인 자료형 대신 실제 자료형으로 대체되는 타입 파라미터를 받아 사용하는 방법

'T'를 사용하는 것이 관례.
여러 개일 경우 <T, U, V>

특정한 수퍼 클래스를 상속받은 클래스 타입으로만 제한하려면 <T:SuperClass>


fun<T>genericFunc(param:T):T
class GenericClass<T>(var pref: T)


fun<Int>genericFunc(param:T):T
class GenericClass<Int>(var pref: T)

ex)


fun main() {

    UsingGeneric(A()).doShout()
    UsingGeneric(B()).doShout()

    funGeneric(A())
    funGeneric(B())
}

fun<T : A> funGeneric(t: T) {

    t.shout()
}

open class A {
    open fun shout() {
        println("A shout")
    }
}

class B: A() {
    override fun shout() {
        println("B shout")
    }
}

class UsingGeneric<T : A>(val t: T) {
    fun doShout() {
        t.shout()
    }
}

-- 리스트 --

여러개의 데이터를 원하는 순서로 넣어 관리하는 형태

>종류<

- List<out T>

- MutableList<T>


>두 클래스의 차이<

List는 생성시에 넣은 객체를 대체, 추가, 삭제할 수 없음

MutableList는 대체, 추가, 삭제 가능함


-- 리스트를 만들어서 사용 예시

listOf(1, 2, 3)
mutableListOf("A","B","C")

-- mutableListOf 에서 사용 가능 가능 메서드 //
요소의 추가 add(데이터), add(인덱스, 데이터)
요소의 삭제 remove(데이터), removeAt(인덱스)
무작위 섞기 shuffle()
정렬 sort()



// 리스트 실전 - 1

fun main() {

    val a = listOf("사과", "딸기", "배")
    println(a[1])

    for (fruit in a)
    {
        print("${fruit}:")
    }
    println()

    val b = mutableListOf(6, 3, 1)
    println(b)

    b.add(4)
    println(b)

    b.add(2, 8)
    println(b)

    b.removeAt(1)
    println(b)

    b.shuffle()
    println(b)

    b.sort()
    println(b)
}

// 리스트 실전 - 2


fun main() {

    val a = listOf<Int>(1, 2, 3)
    val b = mutableListOf<Int>()

    b.add(1)
    b.add(2)
    b.add(3)
    b.add(2, 6)
    b.sort()
    println(b)
    b.shuffle()
    println(b)
    println()
    println(a)
    println(b)

}

-- String function = 문자열을 다루는법 --


-- String function 예시 -1 --

fun main() {

    // 문자열의 길이

    val test = "a.b.c.d"
    println(test.length)

    // 문자열 분해하여 배열에 저장

    var spl = test.split('.')
    println(spl)


    // 배열 값들을 String 으로 합쳐줌
    println(spl.joinToString())
    println(spl.joinToString("-"))

    println(test.substring(0..2))

    // 특정문자로 시작 및 종료 포함하였는지 확인 하는 구문
    // 시작 단어 bool
    println(test.startsWith("a."))
    // 끝 단어 bool
    println(test.endsWith(".d"))
    // 포함 단어 bool
    println(test.contains("b.c"))

}

-- String function 예시 -2 --


fun main() {

    val test1 = "Test.Kotlin.String"
    println(test1.length) // 문자열 길이

    println(test1.toLowerCase())    // 소문자로 변환
    println(test1.toUpperCase())    // 대문자로 변환

    // 문자열 분해하여 배열로 다시 결합

    val test2 = test1.split(".")
    println(test2)

    println(test2.joinToString())   // 그냥 합쳐짐
    println(test2.joinToString("-")) // -문자를 넣어 합쳐짐

    var test3 = "1234567890"
    println(test3.substring(5..9))
}


-- String function 예시 -3 --

fun main() {
    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"

    println(nullString.isNullOrEmpty())
    println(emptyString.isNullOrEmpty())
    println(blankString.isNullOrEmpty())
    println(normalString.isNullOrEmpty())
    println()
    println(nullString.isNullOrBlank())
    println(emptyString.isNullOrBlank())
    println(blankString.isNullOrBlank())
    println(normalString.isNullOrBlank())


}

-- null 처리 --


자바에서는 보통 if(변수 == null)형식으로 null값을 처리한다.
코틀린은 ? ?: !!을 통해 null 값을 처리할 수 있다.

** null 처리 연산자의 종류 **

1.
?.  =>  null safe operator
참조 연산자를 실행하기 전에 먼저 객체가 null인지 확인부터하고
객체가 null이라면 뒤따라 오는 구문을 실행하지 않음
ex) sample?.toUpperCase()
sample이면 null이면 toUpperCase()를 실행하지 않음.

2.
?: => elvis operator
객체가 null이 아니라면 그대로 사용하지만 null이면
연산자 우측의 객체를 사용한다.
ex) sample?:"default"

sample이 null이니까 대신 "default"를 사용

3.
!!. => non-null assertion operator
참조 연산자를 사용할 때 null 여부를 컴파일 시 확인하지 않도록 하여
runtime시 NPE가 나도록 의도적으로 방치하는 연산자

// 예시 - null safe 연산자를 스코프 함수와 사용
// null 체크하기 위해 if문 대신 사용하면 편리한 기능


fun main() {
    var a: String? = "Kotlin Exam"
    a?.run  {
        println(toUpperCase())
        println(toLowerCase())

    }

}

-- 변수의 동일성 --

1. 내용의 동일성

메모리 상의 서로 다른 곳에 할당된 객체라고 해도 그 내용이 같으면 동일하다고 판단하는 것
== 연산자를 사용

2. 객체의 동일성

서로 다른 변수가 메모리 상의 같은 객체를 가리킬 때만 동일하다고 판단하는 것

=== 연산자

내용의 동일성은 자동으로 판단되는 것이 아닌 코틀린의 모든 클래스가 내부적으로 상속 받는
Any라는 최상위 클래스에 equals()함수가 반환하는 boolean 값으로 판단하게 된다.
기본 자료형에는 자료형의 특징에 따라 equals()함수가 이미 구현되어 있지만 커스텀 class를 만들 때는
equals를 상속 받아 동일성을 확인해주는 구문을 별도로 구현해야 한다.


-- 예시 --

fun main() {

    var a = Product("콜라", 1000)
    var b = Product("콜라", 1000)
    var c = a
    var d = Product("사이다", 1000)

    println("a == b : " + (a == b).toString())
    println("a === b : " + (a === b).toString())

    println("a == c : " + (a == c ).toString())
    println("a === c : "+ (a ===c).toString())

    println("a == d :" + (a == d).toString())
    println("a === d :" + (a === d).toString())

}

class Product(val name: String, val price: Int) {
    override fun equals(other: Any?): Boolean {
        if (other is Product) {
            return other.name == name && other.price == price

        } else {
            return false
        }
    }
}

-- default arguments --

파라미터를 받아야 하는 함수이지만 별다른 파라미터가 없더라도 기본 값으로 동작해야 한다면
default arguments를 사용한다.

-- 예시 --


fun main() {

    deliveryItem("짬뽕")
    deliveryItem("책", 3)
    deliveryItem("노트북", 30, "학교")

    deliveryItem("선물", destination = "친구 집")


}

fun deliveryItem(name: String, count: Int = 1, destination: String = "짐") {

    println("${name}, ${count}개를 ${destination}에 배달하였습니다.")
}


-- named arguments --

파라미터의 순서와 관계 없이 파라미터의 이름을 사용하여 직접 파라미터의 값을 할당하는 기능

-- variable number of arguments(vararg)
: 같은 자료형을 갯수에 상관없이 파라미터로 받고 싶을 때 사용

vararg는 갯수가 지정되지 않은 파라미터라는 특징이 있으므로 다른 파라미터와 같이 쓸 때는 반드시 맨 마지막에 위치 해야 한다.

ex) fun sample(text: String, vararg x: Int )



fun main() {

    sum(1, 2, 3, 4)


}

fun sum(vararg numbers: Int) {
    var sum = 0

    for (n in numbers) {

        sum += n        // sum = sum + n
    }

    print(sum)
}


-- infix 함수

=> 연산자 처럼 쓸 수 있는 함수

=> 참고로 class안에서 infix함수를 선언할 때에는 적용할 클래스가 자기 자신이므로 클래스 이름은 쓰지 않는다.

-- ex-1)

fun main() {

    println(6 multiply 4)

    println(6.multiply(4))


}

infix fun Int.multiply(x: Int): Int = this * x


-- ex-2)

fun main() {

    println("awd" strSum 1)
    println("awd".strSum(2))

    println(3 mul 4)
    println(3.mul(4))

}



// infix fun (this에 해당되는 타입).함수이름(인자이름: 타입): 반환 = 구문

infix fun String.strSum(x: Int): String = this + x
infix fun Int.mul(x: Int): Int = this * x


// 참고 : 클래스안에서 infix함수를 적용할 경우 this는 클래스 객체 자신이므로 함수이름 왼쪽에 클래스 이름은 쓰지 않는다.


-- 중첩 클래스 (Nested Class)

하나의 클래스가 다른 클래스의 기능과 강하게 연관되어 있다는 의미를 전달하기 위해 만들어진 형식

class Outer {
    class Nested {
    }       * 외부 클래스의 내용을 공유할 수 없음
   }

-- 내부 클래스 (inner class)

혼자서 객체를 만들수는 없고 외부 클래스의 객체가 있어야만 생성과 사용이 가능한 클래스

내부 클래스(Inner Class)
class Outer{
    inner class Inner {     // inner 키워드

    }                       * 외부 클래스의 속성과 함수의 사용이 가능
}

// 중첩 클래스와 내부 클래스의 예시 ==> 중첩 클래스와 내부 클래스는 클래스 간의 연계성을 표현하여 코드의 가독성 및 작성 편의성이 올라갈 수 있으므로 적절한 상황에서 사용하면 좋다.

fun main () {

    Outer.Nested().introduce()

    val outer = Outer()
    val inner = outer.Inner()

    inner.introduceInner()
    inner.introduceOuter()

    outer.text = "Changed Outer Class"
    inner.introduceOuter()


}


class Outer {

    var text = "Outer Class"

    class Nested {
        fun introduce() {
            println("Nested Class")
        }
    }

    inner class Inner {

        var text = "Inner Class"

        fun introduceInner() {

            println(text)
        }

        fun introduceOuter() {
            println(this@Outer.text)
        }
    }
}

-- Data Class --

데이터를 다루는 데에 최적화된 class로 5가지 기능을 내부적으로 자동으로 생성

equals()

내용의 동일성을 판단

hashCode()
객체의 내용에서 고유한 코드를 생성

toString()

포함된 속성을 보기 쉽게 나타냄

copy()

객체를 복사하여 똑같은 내용의 새 객체를 만듬. copy()를 통해 새 객체를 생성할 때는 똑같은 내용의 객체를 생성 할 수도 있지만 생성자와 똑같은 형태의 파라미터를 부여하여 일부 속성을 변경할 수 있다.


componentX
속성을 순서대로 반환


형태: Data(component1(), component2())

-- 예시 --

fun main() {

    val a = General("보영", 212)

    println(a == General("보영", 212))
    println(a.hashCode())
    println(a)

    val b = Data("루다", 306)

    println(b == Data("루다", 306))
    println(b.hashCode())
    println(b)

    println(b.copy())
    println(b.copy("아린"))
    println(b.copy(id = 618))

}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)

-- 설명 --
==> 일반 클래스로 만든 a는 equals()나 hashCode(), toString() 함수의 결과가 제대로 구현되지 않은 반면 data클래스로 만든
b는 3함수 모두 의미 있는 기능으로 자동 구현되어 있음을 알 수 있으며 copy() 함수를 통해 원본을 복사한 새 객체 역시 쉽게 만들 수 있음을 알 수 있다.


-- 예시 --

fun main() {

    val list = listOf(Data("보영", 212),
                      Data("루다", 306),
                      Data("아린", 618))

    for ((a,b) in list) {
        println("${a}, ${b}")
    }


}

class General(val name: String, val id: Int)

data class Data(val name: String, val id: Int)


-- enum class --

==> enum 클래스 안의 객체들은 관행적으로 상수를 나타낼 때 사용하는 대문자로 기술한다.
또한 enum의 객체들은 고유한 속성을 가질 수 있다.


'열거형'의 준만

-- 형태 --

enum class Color{
    RED,
    BLUE,
    GREEN           // 특이한 형태이지만 모두 enum class인 Color의 객체를 생성하기 위한 선언이다.

}

* 또한 enum에 생성자를 만들어 속성을 받도록 하면 객체를 선언할 때 속성도 설정할 수 있다. 또한 일반 클래스처럼 함수도 추가할 수 있다.
이 때는 객체의 선언이 끝나는 위치에 세미콜론을 추가하고 함수를 기술하면 된다.

-- 형태 --

enum class Color (val number: Int) {
    RED(1),
    BLUE(2),
    GREEN(3)
}

-- 예시 --

fun main() {

    var state = State.SING
    println(state)

    state = State.SLEEP
    println(state.isSleeping())

    state = State.EAT
    println(state.message)


}


enum class State(val message: String) {

    SING("노래를 부른다"),
    EAT("밥을 먹는다"),
    SLEEP("잠을 잔다");

    fun isSleeping() = this == State.SLEEP
}


-- 컬렉션 함수 --

list나 set, map 과 같은 컬렉션 또는 배열에 일반 함수 또는 람다 함수 형태를 사용하여 for문 없이도 아이템을 순회하며 참조하거나
조건을 걸고, 구조의 변경까지 가능한 여러 가지 함수를 지칭한다.

forEach
collection.forEach{
    println(it)
}

filter
collection.filter {
    it < 4 (it에 조건을 걸어줌)
}

map
collection.map {
    it * 2 (it에 수식을 적용하여 값을 변경하여 컬렉션으로 만들어주고 반환)
}


any  all none
collection.any{it == 0} 하나라도 조건에 맞으면 true
collection.all{it == 0} 모두 조건에 맞으면 true
collection.none{it == 0} 하나도 조건에 맞지 않으면 true

first
collection.first() 일반함수로 사용하는 경우 컬렉션의 첫번째 객체를 반환
collection.first{it > 3} 람다함수 형태로 중괄호 안의 it에 조건을 걸어주면 조건에 맞는 첫번째 객체를 반환

last
collection.last{it > 3} 조건에 맞는 마지막 객체를 반환

first -> find 대체 가능
last -> findLast로 대체 가능

first, last 함수 사용시 문제점
조건에 맞는 객체가 없는 경우 ( = 컬렉션이 비어 있는 경우)
NoSuchElementException이 발생.
이 때는 firstOrNull, lastOrNull을 사용하면 객체가 없는 경우 null을 반환

count
collection.count() 일반함수로 사용하면 컬렉션의 모든 아이템의 개수를 반환
collection.count{it > 7} 중괄호와 함께 it에 조건을 걸어주면 조건에 맞는 아이템 갯수를 반환.

-- Map 컬렉션 --


fun main() {

    var a: MutableMap<Int, String> = mutableMapOf()
    a[1] = "a"
    a[2] = "b"


    for(i in a) {
        println("${i.key} ${i.value}")
    }
    a.remove(1)

    println(a)
    println(a[2])

}

-- listOf --

fun main() {


    val nameList = listOf("박수영", "김지수", "김다현", "신유나", "김지우")

    nameList.forEach{ print(it + " ")}
    println()

    println(nameList.filter{it.startsWith("김")})

    println(nameList.map {"이름 : " + it})

    println(nameList.any{it == "김지연"})
    println(nameList.all{it.length == 3})
    println(nameList.none{it.startsWith("이")})

    println(nameList.first{it.startsWith("김")})
    println(nameList.last{it.startsWith("김")})
    println(nameList.count{it.contains("지")})

    println(nameList.lastOrNull { it.startsWith("학")})

    }

-- associate By --

객체에서 key를 추출하여 map으로 변환하는 함수

collection.associateBy{ it.name }

-- groupBy --

key가 같은 아이템끼리 배열로 묶어 map으로 만드는 함수

-- partition --

아이템에 조건을 걸어 두개의 컬렉션으로 나누어 줌. 두 컬렉션은 두 객체를 담을 수 있는 Pair라는 클래스 객체로 반환 되므로
각각의 컬렉션을 first, second로 참조하여 사용.

또는 Pair를 직접 받아줄수 있도록 변수 이름을 괄호 안에 두 개 선언해주면 각각의 변수 이름으로 받을 수 있다.

val (over2002, under2002) = collection.partition{ it.birthYear > 2002 }

-- 예시 --


fun main() {

    data class Person(val name: String, val birthYear: Int)

    val personList = listOf(Person("유나",1992),
                            Person("조이", 1996),
                            Person("츄", 1999),
                            Person("유나", 2003))

    println(personList.associateBy { it.birthYear })
    println(personList.groupBy{it.name})

    val (over98, under98) = personList.partition { it.birthYear > 1998 }
    println(over98)
    println(under98)
}

-- flatMap --

아이템마다 만들어진 컬렉션을 합쳐서 반환하는 함수

collection.flatMap( listOf(it * 3, it + 3)}

==> 중괄호 안에서 아이템마다 새로운 컬렉션을 생성하면 이를 합쳐서 하나의 컬렉션으로 반환해준다.


-- getOrElse --

인덱스 위치에 아이템이 있으면 아이템을 반환하고 아닌 경우 지정한 기본 값을 반환하는 함수
collection.getOrElse() { }

-- zip --

컬렉션 두 개의 아이템을 1:1로 매칭하여 (Pair 클래스의 객체로 만들어 리스트에 넣어) 새 컬렉션을 만들어줌. 이때 결과 List의
아이템의 갯수는 더 작은 컬렉션을 따라가게 됨.

collectionA zip collectionB

-- 예시 --

fun main() {


    val numbers = listOf(-3, 7, 2, -10, 1)

    println(numbers.flatMap { listOf(it * 10, it + 5)})

    println(numbers.getOrElse(1){50})
    println(numbers.getOrElse(10){50})

    val names = listOf("A", "B", "C", "D")
    println(names zip numbers)

}


-- 변수의 고급 기술. 상수, lateinit, lazy --

val은 할당된 객체를 바꿀 수 없을 뿐이지 객체 내부의 속성을 변경할 수 없는 것은 아니다.
그런데, 절때 변경이 불가능한 것도 있다.

-- 상수 --

컴파일 시점에 결정되어 절때 바꿀 수 없는 값.

const val CONST_A = 1234

==> 상수로 선언될 수 있는 값은 기본 자료형만 가능하며(*String 자료형을 포함)

런타임에 생성될 수 있는 일반적인 다른 클래스의 객체들은 담을 수 없다.

class Sample { const val CONST_A = 1234} (불가능) // 클래스의 속성으로 사용할 수 없다.
fun Sample {const val CONST_A = 1234} (불가능) // 지역 변수로 사용할 수 없다.

반드시 companion object 안에 선언하며 객체의 생성과 관계없이 클래스와 관계된
(Sample.CONST_A) 고정적인 값으로만 사용

-- 형태 --

class Sample {
    companion object {
            const val CONST_A = 1234
          }
}


-- 표기 --

상수의 이름을 만들 때는 의례적으로 대문자와 언더바(_)만 사용한 표기법을 사용하여 이를 통해 변수가 아닌 상수라는 점을 알림

** 변수를 사용하지 않고 상수를 별도로 사용하는 이유 **

==> 변수의 경우 런타임시 객체를 생성하는데 시간이 더 소요되어 성능의 하락이 있기 때문.
따라서 늘 고정적으로 사용할 값은 상수를 통해 객체의 생성 없이 메모리에 값을 고정하여 사용함으로써 성능을 향상 시킬 수 있음.



-- 예시 --

fun main() {
    val foodCourt = FoodCourt()

    foodCourt.searchPrice(FoodCourt.FOOD_CREAM_PASTA)
    foodCourt.searchPrice(FoodCourt.FOOD_STEAK)
    foodCourt.searchPrice(FoodCourt.FOOD_PIZZA)



}

class FoodCourt {

    fun searchPrice(foodName: String) {

        val price = when(foodName) {

            FOOD_CREAM_PASTA -> 13000
            FOOD_STEAK -> 25000
            FOOD_PIZZA -> 15000
            else -> 0

        }

        println("${foodName}의 가격은 ${price}원 입니다.")
    }

    companion object {

        const val FOOD_CREAM_PASTA = "크림파스타"
        const val FOOD_STEAK = "스테이크"
        const val FOOD_PIZZA = "피자"
    }
}

-- lateinit(늦은 초기화) --

==> 기본 자료형을 제외(String 가능)하고 객체 생성시 초기화를 하지 않고 변수만 선언할 수 있게 하는 키워드

==> 코틀린에서는 변수를 선언할 때 객체를 바로 할당하지 않는 경우에는 기본적으로 컴파일이 불가능.
이럴 때는 var 앞에 lateinit을 사용하여 일단 변수만 선언하고 초깃값의 할당은 나중에 할 수 있도록 하는 키워드.

-- 기본 형태 --

lateinit var a: Int

** lateinit var 변수의 제한사항 **

초깃값 할당 전까지 변수를 사용할 수 없음(에러 발생)

기본 자료형에는 사용할 수 없음(*String 클래스에서는 사용 가능)
또한 lateinit 변수의 '초기화'를 하였는지 여부를 확인할 때는 ::a.isInitialized 값을 확인해보면 초기화가 되었는지 확인하여
사용할 수 있으므로 오류를 막을 수 있다.


-- late init 예시 1 --

fun main() {
    val a = LateInitSample()

    println(a.getLateInitText())
    a.text = "새로 할당한 값"
    println(a.getLateInitText())


}

class LateInitSample {

    lateinit var text: String
    fun getLateInitText(): String {
        if (::text.isInitialized) {
            return text
        } else {
            return "기본값"
        }
    }
}


-- late init 예시 2 --


fun main() {

    var t = a()
    println(t.test())
    t.a = "zxc"
    println(t.test())

}

class a{

    lateinit var  a: String         // lateinit 으로 초기화

    fun test(): String {
        // a가 초기화가 되었는지 체크
        if(::a.isInitialized) {

            return a
        }else {

            return "null"
        }

    }
}



-- lazy --

변수의 초기화 시점을 사용할 때 초기화하게 해주는 키워드

-- lazy delegate properties (지연 대리자 속성) --

변수를 사용하는 시점까지 초기화를 자동으로 늦춰준다.

val a: Int by lazy{7}

lateinit과 달리 val 변수에 by라는 키워드를 사용하여 lazy라는 람다 함수 형태의 초기화 함수를 사용

코드에서는 선언 시 즉시 객체를 생성 및 할당하여 변수를 초기화하는 형태를 갖고 있지만 실제 실행 시에는 val 변수를 사용하는 시점에
초기화를 진행함으로써 코드의 실행시간을 최적화할 수 있는 코드.

-- 형태 ex) --

val a: Int by lazy{7}
...
println(a)          // 이 시점에 7로 초기화 됨

참고로 람다 함수로 초기화가 진행되므로 함수 안에 여러개의 구문이 들어갈 수 있다. 맨 마지막 구문의 결과가 변수에 할당된다.

val a: Int by lazy {
    println("initializing")
    7
}


-- lazy 예시 1 --


fun main() {

    val number: Int by lazy {

        println("초기화를 합니다")
        7
    }

    println("코드를 시작합니다")
    println(number)
    println(number)

}

-- lazy 예시 2 --

fun main() {

    val num : Int by lazy {

        println("초기화")
        7
    }

    println("start")
    println(num)
    println(num)
    }

    // 코루틴(coroutine)


/*

* 코루틴
메인이 되는 루틴과 별도로 진행이 가능한 루틴으로 개발자가 루틴의 실행과 종료를 마음대로 제어가 가능한 단위

* 코루틴의 scope

코루틴은  제어 범위 및 실행 범위를 지정할 수 있다.

-Global Scope

프로그램 어디서나 제어, 동작이 가능한 기본 범위

CoroutineScope

특정한 목적의 Dispatcher를 지정하여 제어 및 동작이 가능한 범위

CoroutineScope를 만들 때 적용 가능한 Dispatcher

Dispatcher.Default => 기본적인 백그라운드 동작
Dispatcher.Io => I/O에 최적화된 동작
Dispatcher.Main => 메인 스레드에서 동작

코루틴을 이용해 Scope에서 제어되도록 생성될 수 있음.

val scope = CoroutineScope(Dispatcher.Default)
val coroutineA = scope.launch{}
val coroutineB = scope.async{}


launch vs async

launch: 반환 값이 없은 Job 객체

async: 반환 값이 있는 Deffered 객체


// 루틴의 대기를 위한 추가적인 함수

delay ()
delay(millisecond:Long) millisecond 단위로 루틴을 잠시 대기시키는 함수

join()
Job.join() Job의 실행이 끝날 때 까지 대기하는 함수

await()
Deferred.await() Deffered의 실행이 끝날 때 까지 대기하는 함수

Deffered 의 결과도 반환

새 함수들은 코루틴 내부 또는 runBlocking{}과 같은 루틴의 대기가 가능한 구문 안에서만 동작이 가능하다.

// 코루틴에 cancel()을 걸어주면 다음 두 가지 조건이 발생하며 코루틴을 중단 시킬 수 있다.

1. 코루틴 내부에 delay() 함수 또는 yield() 함수가 사용된 위치까지 수행된 뒤 종료됨

2. cancel()로 인해 속성인 isActive가 false가 되므로 이를 확인하여 수동으로 종료함

// withTimeoutOrNull()

제한시간 내에 수행되면 결과 값을, 아닌 경우 null을 반환
이 함수도 join()이나 await()처럼 blocking 함수이다.



 */

 */
