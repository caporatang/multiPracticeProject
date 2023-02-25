package com.multi.pratice.multipratice.springbasic.objectmapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.objectmapper.dto
 * fileName : Car
 * author : taeil
 * date : 2023/02/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/25        taeil                   최초생성
 */
public class Car {
    private String name;
    @JsonProperty("car_number") // json 규격에 맞게 컬럼을 바꿔주자
    private String carNumber;
    @JsonProperty("TYPE")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}