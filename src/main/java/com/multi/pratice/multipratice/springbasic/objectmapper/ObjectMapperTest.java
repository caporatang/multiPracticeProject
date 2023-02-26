package com.multi.pratice.multipratice.springbasic.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.multi.pratice.multipratice.springbasic.objectmapper.dto.Car;
import com.multi.pratice.multipratice.springbasic.objectmapper.dto.User;

import java.util.Arrays;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.objectmapper
 * fileName : ObjectMapperTEst
 * author : taeil
 * date : 2023/02/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/25        taeil                   최초생성
 */
public class ObjectMapperTest {
    // object mapper는 특정 객체가 있다면 json형태로 바꿔주거나, text 형태라면 객체로 바꿔주는 라이브러리임
    // Text JSON -> Object
    // Object -> Text JSON

    // controller req json(text) -> object
    // response object -> json(text)

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("김태일");
        user.setAge(22);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        //System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        // json의 형태를 알수있을때 가져오는 방법
        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText(); // name으로 시작하는 노드를 가져오기
        int _age = jsonNode.get("age").asInt(); // age가져오기

        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        // 배열안에 노드를 가져오기
        JsonNode cars = jsonNode.get("cars"); // -> 노드를 통으로 가져오기
        ArrayNode arrayNode = (ArrayNode) cars; // 가져온 노드를 arrayNode로 변환

        // 변환한 arrayNode를 원하는 클래스(타입)로 컨버팅
        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println(_cars);

        //값 변환하기
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "태일킴");
        objectNode.put("age", 50);
        // json 이쁘게 출력하기
        System.out.println(objectNode.toPrettyString());
    }
}