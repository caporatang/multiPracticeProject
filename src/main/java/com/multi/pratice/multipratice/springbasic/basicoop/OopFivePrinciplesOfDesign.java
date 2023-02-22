package com.multi.pratice.multipratice.springbasic.basicoop;

/**
 * packageName : com.multi.pratice.multipratice.springbasic
 * fileName : OopFivePrinciplesOfDesign
 * author : taeil
 * date : 2023/02/16
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/16        taeil                   최초생성
 */
public class OopFivePrinciplesOfDesign {
    // 객체지향 설계 5원칙 (SOLID)

    // 결합도는 낮추고 응집도는 높여야함
    // 결합도 -> 모듈간의 상호 의존 정도를 나타내는 지표, 결합도가 낮으면 객체의 재사용 및 유지보수가 유리함
    // 응집도 -> 하나의 모듈 내부에 존재하는 구성 요소들의 기능적 관련성 -> 응집도가 높은 모듈은 하나의 책임에 집중하고 독립성이 높아짐, 재사용 및 유지보수 용이

    // 1. SRP (Single Responsibility Principle) 단일 책임 원칙 -> 어떠한 클래스를 변경해야 하는 이유는 한가지 뿐 이여야 한다.

    // 2. OCP (Open Closed Principle) 개방 폐쇄 원칙 -> 자신의 확장에는 열려 있고, 주변의 변화에 대해서는 닫혀 있어야함 -> ex) JDBC, Mybatis, Stream(Input, Out)
    // -> 상위 클래스 또는 인터페이스를 중간에 둠으로써, 자신은 변화에 대해서는 폐쇄적이지만, 인터페이스는 외부의 변화에 대해서 확장을 개방해 줄 수 있음

    // 3. LSP (Liskov Substitution Principle) 리스코프 치환 원칙 -> 서브 타입은 언제나 자신의 기반(상위) 타입으로 교체 할 수 있어야 한다.

    // 4. ISP (Interface Segregation Principle) 인터페이스 분리 원칙 ->  클라이언트는 자신이 사용하지 않는 메서드에 의존 관계를 맺으면 안된다.
    // ex) 지도 class에 도보, 자동차, 바이크 등 여러가지 길 안내 지도가 있다고 가정했을때,
    // 자전거 navi 클래스를 만들어서 지도 class를 상속 받으면 자전거 길 안내 메서드 뿐 아니라 자동차, 도보 등등 자전거와 상관없는 여러가지 길 안내 메서드를 의존하게 되기 때문에 위배된다.
    // 지도를 상속받아 사용 해야 한다면, 자전거 길 안내() 인터페이스를 따로 만들어, 인터페이스를 통해서 구현해야한다.

    // 5. DIP (Dependency Inversion Principle) 의존 역전 원칙 -> 자신보다 변하기 쉬운 것 에 의존하지 말아야함
}