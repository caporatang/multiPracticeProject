# Thread의 체크 예외
Runnable 인터페이스의 run() 메서드를 구현할 때 InterruptedException 체크 예외를 thrwos 할 수 없는 이유는 자바의 규칙 때문이다.
````java
public interface Runnable {
    void run();
}
````
자바에서 메서드를 재정의 할 때, 재정의 메서드가 지켜야할 예외 관련 규칙은
- 체크 예외
  - 부모 메서드가 체크 예외를 던지지 않는 경우, 재정의된 자식 메서드도 체크 예외를 던질 수 없다.
  - 자식 메서드는 부모 메서드가 던질 수 있는 체크 예외의 하위 타입만 던질 수 있다.
- 언체크(런타임) 예외
  - 예외 처리를 강제하지 않으므로 상관없이 throw 할 수 있다.

Runnable 인터페이스의 run() 메서드는 아무런 체크 예외를 throw 하지 않는다. 따라서 Runnable 인터페이스의 run() 메서드를 재정의 하는 곳에서는 체크 예외를 throw 할 수 없다.

## 자바에서 이런 제약을 두는 이유?
부모 클래스의 메서드를 호출하는 클라이언트 코드는 부모 메서드가 던지는 특정 예외만을 처리하도록 작성된다. 자식 클래스가 더 넓은 범위의 예외를 던지면 해당 코드는 모든 예외를 제대로 처리하지 못할 수 있다.  
예외 처리의 일관성을 지키고, 예상하지 못한 런타임 오류를 막기 위함이다.

````java
class Parent {
    void method() throws InterruptedException {
        /* do something...*/
    }

    class Child extends Parent {
        @Override
        void method() throws Exception {
        // 부모 메서드가 InterruptedException을 thorws 하는데 자식 메서드에서 상위인 Exception을 던지면 컴파일 에러가 난다
            /* do something...*/
        }
    }

    public class Test {
        public static void main(String[] args) {
            try {
                Parent p = new Child();
                p.method();
            } catch (InterruptedException e) {
                // Parent를 참조해서 객체를 만들었으니, 자바 컴파일러 입장에서는 InterruptedException 을 잡게된다.
                // InterruptedException 처리
            }
        }
    }
}
````
정리 하자면, 자바 컴파일러는 Parent p의 method() 를 호출한 것으로 인지한다. method()는 InterruptedException을 반환하는데, 재정의한 자식이 다른 예외를 반환한다면 클라이언트는 해당 예외를 잡을 수 없다.

## 체크 예외 재정의 규칙
자식 클래스에 재정의된 메서드는 부모 메서드가 던질 수 있는 체크 예외의 하위 타입만을 throw할 수 있고, 원래 메서드가 체크 예외를 throw 하지 않는 경우, 재정의된 메서드도 체크 예외를 던질 수 없다

