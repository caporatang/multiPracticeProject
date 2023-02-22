package com.multi.pratice.multipratice.springbasic.web;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.web
 * fileName : RestAPI
 * author : taeil
 * date : 2023/02/21
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/21        taeil                   최초생성
 */
public class RestAPI {
    // Rest란 무엇인가!
    // Rest (Representational State Transfer : 자원의 상태 전달) - 네트워크 아키텍처

    // 어떤 상태가 Rest하다고 할수 있는가?
    // 1. Clint, Server : 클라이언트와 서버가 서로 독립적으로 분리 되어 있어야함
    // 2. stateless : 요청에 대해서 클라이언트의 상태를 서버에 저장하지 않는다.
    // 3. Cache : 클라이언트는 서버의 응답을 Cache(임시저장) 할 수 있어야 한다. -> 클라이언트가 Cache를 통해 응답을 재사용할 수 있어야함, 이를 통해 서버의 부하를 낮추어야함
    // 4. 계층화(Layered System) : 서버와 클라이언트 사이에, 방화벽, 게이트웨이, Proxy 등 다양한 계층 형태로 구성 가능해야하고, 이를 확장 할 수 있어야 함
    // 5. 인터페이스 일관성 : 인터페이스의 일관성을 지키고, 아키텍처를 단순화시켜 작은 단위로 분리하여, 클라이언트, 서버가 독립적으로 개선 될 수 있어야한다.
    // 6. Code on Demand (Optional) : 자바 애플릿, 자바스크립트, 플래시 등 특정한 기능을 서버로부터 클라이언트가 전달받아 코드를 실행 할 수 있어야함

    // 인터페이스 일관성을 판단하는 기준 --> 규약임, 이정도는 지켜서 개발해야함
    // 1. 자원의 식별
    // 1-1 웹 기반의 Rest에서는 리소스 접근할 때 URL를 사용함
    // https://foo.co.kr/user/100 -> 해당 url에서는 resource : user , 식별자 : 100

    // 2. 메시지를 통한 리소스 조작
    // -> 다양한 방식으로 데이터를 전달 할 수 있음
    // -> HTML, XML, JSON, TEXT ..등 -> 이 중 어떤 타입의 데이터인지를 알려주기 위해 HTTP Header부분에 content-type을 통해 데이터 타입을 지정할수있음
    // -> 리소스 조작을 위해 데이터 전체를 전달 하지 않고, 이를 메세지로 전달함

    // 3. 자기 서술적 메시지
    // -> 요청 하는 데이터가 어떻게 처리 되어져야 하는지 충분한 데이터를 포함 할 수 있어야 한다.
    // -> HTTP 기반의 REST에서는 HTTP Method와 Header정보, 그리고 URI의 포함되는 정보로 표현 할 수 있습니다.
    // GET(읽기), POST(생성), PUT(생성 또는 수정), DELETE(삭제) .. 그 외에 담지 못한 정보들은 URL의 메시지를 통하여, 표현함

    // 4. 애플리케이션 상태에 대한 엔진으로써 하이퍼미디어 --> 잘 사용하지않음..
    // Rest API를 개발할 때 단순히 Client요청에 대한 데이터만 응답 해주는 것이 아닌 관련된 리소스에 대한 Link 정보까지 같이 포함되어야함

    // URL과 URI의 차이
    // URI는 URL과 URN을 포함한 개념임. --> URI가 제일 큰 개념이고 그 안에 들어가있는게 URL, URN
    // URI : 통합 자원 식별자(Uniform Resource Identifier)는 인터넷에 있는 자원을 어디에 있는지 자원 자체를 식별하는 방법이다.
    // URL : 파일식별자(Uniform Resource Locator)는 네트워크 상에서 자원이 어디 있는지 위치를 알려주기 위한 규약이다.

    // 컨트롤러를 예를들어
    // 클래스에 붙은 RequestMapping /member/v1 -> URI패턴
    // 메서드에 붙은 요청 식별자 ("/test")

}