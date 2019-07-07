package com.hyeran.seminar3.lombok;

public class Main {

    public static void main(String... args) {
        Test test = new Test();

        //@Data가 다양한 메소드를 자동으로 만들어줌
        TestData testData = new TestData();
        testData.getEmail();
        testData.setUserIdx(0);
        testData.toString();

        //Getter, Setter 메소드 자동 생성
        TestGetterSetter testGetterSetter = new TestGetterSetter();
        testGetterSetter.setEmail("hyeran9712@naver.com");
        testGetterSetter.getUserIdx();

        //모든 필드의 생성자 자동 생성
        TestAllArgsConstructor testAllArgsConstructor = new TestAllArgsConstructor(1, "신혜란", "hyeran9712@naver.com");

        //NullPointerException 발생
        //TestNonNull testNonNull = new TestNonNull(0, null, null);
        TestNonNull testNonNull2 = new TestNonNull();

        //@NonNull, final 붙은 키워드의 생성자 자동 생성
        TestRequiredArgsConstructor testRequiredArgsConstructor = new TestRequiredArgsConstructor("신혜란", "hyeran9712@naver.com");

        //Builder 클래스 생성
        TestBuilder.TestBuilderBuilder builder = new TestBuilder.TestBuilderBuilder();

        //Builder 메소드로 build
        TestBuilder.builder()
                .userIdx(1)
                .name("신혜란")
                .email("hyeran9712@naver.com")
                .build();

        //immutable 객체
        TestValue testValue = new TestValue(0, "신혜란", "hyeran9712@naver.com");
        //@Wither
        //값을 변경한 새로운 객체를 만들어줌
        TestValue testValue1 = testValue.withUserIdx(1);
    }
}
