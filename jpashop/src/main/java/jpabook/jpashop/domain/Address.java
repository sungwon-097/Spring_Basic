package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

// 값 타입
@Embeddable // 내장 타입
@Getter
// Setter 제공 안해서 변경 불가능하게끔 해준다.
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // JPA 스펙상 만들어줌.
    protected Address() {
    }

    // 생성할때만 값 생성
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
