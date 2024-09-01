# 메모리 가시성
멀티 스레드 환경에서 한 스레드가 변경한 값이 다른 스레드에서 언제 보이는지에 대한 문제이다.
````java
public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        thread.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {
        boolean runFlag = true;
        // volatile boolean runFlag = true;
        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {

            }
            log("task 종료");
        }
    }
}
````
위 예제 프로그램은 runFlag를 false로 바꿔도 while문이 끝나지 않고 계속 실행된다. 끝나지 않고 동작되는 이유가 메모리 가시성 문제이다.  

## 메모리 접근
자바 프로그램을 실행하면 main 스레드와 work 스레드는 모두 메인 메모리의 runFlag의 값을 읽어온다. 프로그램 시작 시점에는 runFlag의 값이 true 이기 때문에 모든 스레드에서는 true의 값을 읽는다.  
main 스레드에서 false로 바꿨으니까 메인 메모리에의 값도 false로 바꿨을거고 그럼 work 스레드에서도 false로 변경된 값을 가지고 중지 되는게 맞다 라고 생각할수도 있다.  

CPU는 성능 개선을 위해 중간에 캐시 메모리를 사용한다. CPU 연산은 초당 연산이 매우 빨라서 CPU 연산의 빠른 성능을 따라가려면, CPU 가까이에 있는 빠른 메모리가 필요한데 이것이 캐시 메모리다.  
각 스레드가 runFlag의 값을 사용하면 CPU는 이 값을 효율적으로 처리하기 위해 먼저 runFlag를 캐시 메모리에 불러온 후 이후 부터는 캐시 메모리에 있는 값을 사용한다. 

그 후에 main 스레드에서 runFlag를 false로 변경하더라도 메인 메모리의 runFlag의 값을 변경하는게 아니라 main 스레드 캐시 메모리의 runFlag의 값만 변경되는 것이다.
- 핵심은 
  - main 스레드가 runFlag의 값을 변경해도 main 스레드를 실행중인 CPU코어가 사용하는 캐시 메모리의 runFlag 값만 False로 변경되는것이다.
  - work 스레드가 실행중인 코어의 캐시 메모리의 runFlag는 여전히 true 이다.
  - work 스레드는 runFlag의 값은 true로 알고있기 때문에 while문을 빠져나오지 못하고 계속해서 실행한다.

## 그래서 해결 방법은?
캐시 메모리를 사용하면 CPU 처리 성능을 개선할 수 있다. 하지만 성능 향상보다 여러 스레드에서 같은 시점에 같은 데이터를 보는 것이 더 중요할 수 있다. 값에 접근할 때 메인 메모리에 '직접' 접근하는 방법이 있다.  
직접 접근하는 키워드가 volatile 키워드이다.

````java
public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        thread.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");
    }

    static class MyTask implements Runnable {
        // boolean runFlag = true;
        volatile boolean runFlag = true;
        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {

            }
            log("task 종료");
        }
    }
}
````
위 코드에서 바뀐건 runFlag에 키워드만 추가했다. 단, 성능의 저하가 약간 있을 수 있기 때문에 필요한 곳에만 사용해야 한다.

## 자바 메모리 모델
Java Memory Model(JMM)은 자바 프로그램이 어떻게 메모리에 접근하고 수정할 수 있는지를 규정하며, 멀티스레드 프로그래밍에서 스레드 간의 상호작용을 정의한다. 
- happens-before
  - happens-before 관계는 자바 메모리 모델에서 스레드 간의 작업 순서를 정의하는 개념이다. 만약 A 작업이 B 작업보다 happens-before 관계에 있다면, A 작업에서의 모든 메모리 변경 사항은 B 작업에서 볼 수 있다. 즉, A 작업에서 변경된 내용은 B 작업이 시작되기 전에 모두 메모리에 반영된다.
    - happens-before 관계는 이름 그대로, 한 동작이 다른 동작보다 먼저 발생함을 보장한다.
    - happens-before 관계는 스레드 간의 메모리 가시성을 보장하는 규칙이다.
    - happens-before 관계가 성립하면, 한 스레드의 작업을 다른 스레드에서 볼 수 있게 된다.
    - 한 스레드에서 수행한 작업을 다른 스레드가 참조할 때 최신 상태가 보장되는 것이다.
  

- happens-before 관계가 발생하는 경우
  1. 프로그램 순서 규칙 : 단일 스레드 내에서, 프로그램의 순서대로 작성된 모든 명령문은 happens-before 순서로 실행된다.
     - 예를 들어, int a = 1;, int b = 2; 에서 a 변수 할당이 b 할당보다 먼저 실행된다.
  2. volatile 변수 규칙 : 한 스레드에서 volatile 변수에 대한 쓰기 작업은 해당 변수를 읽는 모든 스레드에 보이도록 한다. volatile 변수에 대한 쓰기 작업은 그 변수를 읽는 작업보다 happens-before 관계를 형성한다.
  3. 스레드 시작 규칙 : 한 스레드에서 Thread.start() 를 호출하면, 해당 스레드 내의 모든 작업은 start() 호출 이후에 실행된 작업보다 happens-before 관계가 성립된다.  

결국 happens-before는 volatile 또는 동기화 기법을 사용하면 메모리 가시성의 문제가 발생하지 않는다.