package com.kjy.kotlinpractice

import java.util.*

/*
## 코틀린 자료 구조
1. 배열 (Array)
배열 (Array) 같은 type의 연관된 데이터를 효율적으로 관리하기 위한 자료구조.

장점 : index를 통해 원하는 위치에 있는 값에 대해 효율적으로 접근 가능.
단점: 크기가 정해져 있으므로 유동적인 데이터의 추가, 삭제가 어려움.
시간 복잡도 :
접근 - O(1) [index를 통해 값에 바로 접근]
검색 - O(n) [처으 index부터 순회]
추가, 삭제 - 맨 뒤에 추가, 삭제 시 O(1), 중간 값일 시 추가, 삭제 후 데이터를 한칸씩 밀어야 하므로 O(n)

코틀린 Array는 다음 과 같이 사용가능.

// 크기 3의 배열 [1,2,3]
val array: Array<Int> = arrayOf(1, 2, 3)

// 크기 5의 배열 [0, 0, 0, 0, 0]
val array2: Array<Int> = Array(5) { 0 }

// 크기가 고정되어 있으므로 추가 시에는 left value를 통해 새로운 배열을 만들어야 함.
val newArray = array.plus(3)

위와 같이 크기가 고정되어 있는 단점이 존재하므로, 코틀린에서는 ArrayList와 같은 크기가 자유롭고, 추가, 수정, 삭제가 용이한 타입을 제공.
// ArrayList [1, 2, 3]
val arrayList: ArrayList<Int> = arrayListOf(1, 2, 3)

// 기존 arrayList에 4이라는 값 추가. [1, 2, 3, 4]
arrayList.add(4)

// 기존 arrayList에 index 0의 값 삭제 [2, 3, 4]
arrayList.removeAt(0)

// 기존 arrayList에 2라는 값 삭제 [3, 4]
arrayList.remove(2)

2. 스택(stack)

목록의 끝에서만 접근 할 수 있는 제한적인 자료구조.
LIFO(Last In First Out) : 가장 마지막에 들어온 데이터가 가장 먼저 나감.

시간 복잡도:
접근 , 검색 - O(n) [처음 index부터 순회]
추가 , 삭제 - O(1) [마지막 index에 대해서 추가, 삭제 보장]

코틀린에서의 stack type

fun main() {
    val stack = Stack<Int>()

    // 값 추가 (push)
    stack.push(3)
    stack.push(4)


    // 값 추출 (pop), LIFO 구조를 가지므로 가장 마지막에 들어온 4가 pop이 된다.
    println(stack.pop())
}

## 활용 처 :
1. 웹 브라우저 뒤로가기(가장 나중에 열린 페이지를 먼저 보여줌.
2. 역순 문자열 출력(문자열의 마지막부터 출력)등


3.  큐(Queue)

LIFO 형태를 갖는 스택과 반대되는 개념, 한쪽 끝에서는 삽입, 한쪽 끝에서는 추출 작업이 이루어짐.
FIFO(FIRST in FIRST out): 처음에 들어온 데이터가 가장 먼저 나감.

시간 복잡도:
접근, 검색 - O(n) [처음 index부터 순회]
추가, 삭제 - O(1) [마지막 index에 추가, 처음 index에 대해서 삭제 보장]


코틀린에서도 Queue type을 사용할 수 있다.
그러나 Queue는 클래스가 아닌 인터페이스이며, 이를 구현하는 다양한 클래스가 존재한다. (AbstractQueue, LinkedList..)
그러므로 Queue type을 사용하기 위해서는 이를 구현하는 클래스의 인스턴스를 선언하여 사용.


fun main() {
    val queue: Queue<Int> = LinkedList()

// 값 추가 (add or offer)
// add의 경우 에러 발생이 Throw Exception을 수행.
queue.add(3)
queue.offer(4)

// 값 추출 (remove or poll), FIFO 구조를 가지므로 가장 먼저 들어온 3이 dequeue 된다.
// remove의 경우 에러 발생시 Throw Exception을 수행
println(queue.remove())
println(queue.poll())
}

## 활용
프로세스의 스케줄링(먼저 들어온 작업에 대한 처리)
BFS(너비 우선 탐색)등




4. 링크드리스트 (Linked List)
data, pointer를 가지는 각 노드가 연결되어 있는 형태의 자료구조.
노드를 연속적으로 연결함으로써 배열과 달리 동적인 크기를 가질 수 있음
장점: 노드의 중간지점에서의 자료의 추가, 삭제가 O(1)의 시간 복잡도를 가짐.
단점: 데이터를 검색하기 위해서는 head부터 순회해야 하므로 O(n)의 시간 복잡도를 가짐.

시간 복잡도:
접근, 검색 - O(n) [처음 index부터 순회]
추가, 삭제 - 맨 앞 또는 뒤라면 O(1), 중간 위치라면 O(n)

## 종류

- 단일(single)링크드리스트: 하나의 pointer를 가지며, next node 만을 가리킴.

- 이중 링크드리스트: 두개의 pointer를 가지며 이전 (prev), 다음 (next) node를 가리킴.

- 원형 링크드리스트 : 일반적인 링크드리스트에서, 마지막 노드가 처음 노드를 가리킴.

## 코틀린에서의 LinkedList type 사용.

fun main() {
    val linkedList = LinkedList<Int>()

    // 맨 앞에 삽입. [3]
    linkedList.addFirst(3)
    // index 1에 값 4 삽입 [3,4]
    linkedList.add(1, 4)
    // 마지막에 삽입 [3, 4, 5]
    linkedList.addLast(5)

    // index 0의 값 삭제 [4, 5]
    linkedList.removeAt(0)
    // 맨 앞의 값 삭제 [5]
    linkedList.remove()
    // 마지막 값 삭제 []
    linkedList.remove()
}

// 코틀린의 자료구조 2 (해쉬, 트리, 힙)

1. 해쉬(Hash)

해쉬 함수 : 임의의 데이터를 고정된 길이의 데이터로 매핑시키는 함수
해쉬 : 해쉬 함수를 통해 매핑된 고정된 길이의 데이터
해쉬의 특징
1. 결과값이 중복될 가능성이 거의 없다.
2. 입력값을 알 수 없으며, 결과값을 알아도 이를 통해 입력 값을 유추할 수 없다.

해쉬 테이블: 해쉬값을 index로 사용하여 key, value의 형태로 값을 저장하는 자료구조.

해쉬 충돌: 고정된 길이의 데이터로 변환하는 해쉬의 한계로 인해, 서로 다른 두개의 key가 동일한 hash 값을 갖게 되는 것.

- 해쉬 충돌을 해결하기 위한 방법

1. Chaining
: 같은(충돌한) 해쉬 키에 대해 Linked List를 이용하여 기존의 자료 뒤에 새로운 값을 연결시키는 방식.

장점:
- 제한된 크기에 대한 효율적인 공간 관리
- 미리 공간을 보장할 필요가 없으므로 적은 메모리를 사용.

단점:
- 하나의 해쉬 키에 데이터가 몰리게 된다면 검색에 대한 효율성 하락
- 외부 공간 사용, 외부 공간에 대한 작업 추가

시간 복잡도:
추가, 삭제, 탐색: 최악의 경우 O(n) [하나의 해쉬에 모든 값이 몰려있을 경우]

2. Linear Probing
같은(충돌한) 해쉬 키에 대해 해당 address의 다음 index부터 순회하여 비어있는 공간에 데이터를 저장하는 방식.

장점:
- 외부 공간 사용 없이 테이블 내에서 충돌 처리 가능
단점:
- 테이블 공간 사용 증가.
- 해쉬 함수의 성능에 따른 전체 해쉬 테이블의 효율성 변화

시간 복잡도:
추가, 삭제, 탐색: 최악의 경우 O(n) [테이블을 순회하며 일치하는 해쉬 값을 탐색하고 추가, 삭제해야 하므로]
 */














