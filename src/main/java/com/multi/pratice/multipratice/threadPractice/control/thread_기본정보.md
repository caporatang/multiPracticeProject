# 스레드에서 제공하는 기본 정보
스레드에서 기본적으로 제공하는 정보는 다음과 같다.
````java
public class ThreadInfoMain {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority()); // 우선 순위
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup()); // 스레드 그룹
        log("mainThread.getState() = " + mainThread.getState()); // 상태

        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("myThread = " + myThread);
        log("myThread.threadId() = " + myThread.threadId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority()); // 우선 순위
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup()); // 스레드 그룹
        log("myThread.getState() = " + myThread.getState()); // 상태
    }
}
````
- 스레드 객체 정보  
  - log("mainThread = " + mainThread);
  - 해당 스레드의 객체를 문자열로 변환하여 출력한다. Thread클래스의 toString 메서드는 스레드ID, 스레드 이름, 우선순위, 스레드 그룹을 포함하는 문자열을 반환한다.
  - Thread[#21, myThread,5,main]
- 스레드 ID
  - log("myThread.threadId() = " + myThread.threadId());
  - 스레드의 고유 식별자를 반환한다. ID는 JVM 내에서 각 스레드에 대해 유일하다. ID는 스레드가 생성될 때 할당되며, 직접 지정할 수 없다.
- 스레드 이름
  - log("myThread.getName() = " + myThread.getName());
  - 스레드 ID는 중복되지 않지만, 스레드 이름은 중복될 수 있다.
- 스레드 우선순위 
  - log("myThread.getPriority() = " + myThread.getPriority()); 
  - 우선순위는 1 ~ 10 까지 낮음 ~ 높음 이다. 기본값은 5로 설정되고 메서드를 사용해서 우선순위를 변경할 수 있다.
  - 우선순위는 스레드 스케줄러가 어떤 스레드를 우선 실행할지 결정하는 데 사용된다.
- 스레드 그룹
  - log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
  - 스레드 그룹은 스레드를 그룹화하여 관리할 수 있는 기능을 제공한다. 기본적으로 모든 스레드는 부모 스레드와 동일한 스레드 그룹에 속하게 된다.
  - 스레드 그룹은 여러 스레드를 하나의 그룹으로 묶어서 특정 작업(일괄 종료, 우선순위 설정)을 수행할 수 있다.
    - 부모 스레드(Parent Thread)
      - 새로운 스레드를 생성하는 스레드를 의미한다. 스레드는 기본적으로 다른 스레드에 의해 생성된다. 이러한 생성 관계에서 새로 생성된 스레드는 생성한 스레드를 부모로 간주한다.
      - 위 예제 코드 myThread는 main 스레드에서 생성되었기 때문에 main 스레드가 부모 스레드이다.
      - main 스레드는 기본으로 제공되는 main 스레드 그룹에 소속되어 있다.
- 스레드 상태
  - log("myThread.getState() = " + myThread.getState());
  - 스레드의 현재 상태를 반환하는 메서드다. 반환되는 값은 열거형에 정의된 상수 중 하나이다.
    - NEW : 스레드가 아직 시작되지 않은 상태 
    - RUNNABLE : 스레드가 실행 중이거나 실행될 준비가 된 상태 
    - BLOCKED : 스레드가 동기화 락을 기다리는 상태이다.
    - WAITING : 스레드가 다른 스레드의 특정 작업이 완료되기를 기다리는 상태 
    - TIMED_WATING : 일정 시간 동안 기다리는 상태
    - TERMINATED : 스레드가 실행을 마친 상태이다
  