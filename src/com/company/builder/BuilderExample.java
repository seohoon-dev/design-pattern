package com.company.builder;

public class BuilderExample {
    public static void main(String[] args) {
        // 점층적 생성자 패턴
        Car car1 = new Car("한국타이어", "핸들");
        Car car2 = new Car("핸들", "한국타이어", null);

        // 자바 빈 패턴
        // 객체의 일관성 보장x, 불변성 유지x
        Car car3 = new Car();
        car3.setTire("한국타이어");
        car3.setHandle("핸들");
        car3.setTire("중국타이어");

        // 빌더 패턴
        Computer computer = Computer.builder()
                .setCpu("intel")
                .setSsd("256G")
                .setRam("8G")
                .build();

        System.out.println("computer = " + computer);
    }
}

