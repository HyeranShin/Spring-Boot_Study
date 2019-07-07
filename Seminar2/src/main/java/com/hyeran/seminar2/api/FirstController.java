package com.hyeran.seminar2.api;

import org.springframework.web.bind.annotation.*;

/*
@RestController: REST를 위한 전용 Controller 기능을 부여하는 Annotation
@RestController = @Controller + @ResponseBody
반환값을 JSON으로 변환해준다.

@Controller: 템플릿을 이용해서 HTML 페이지를 렌더링하고 표시해준다.
@ResponseBody: 반환값을 JSON으로 변환해준다.
 */
@RestController
public class FirstController {

    /*
    @GetMapping: Get 메소드 전용 Controller Annotation
    리소스를 조회하는 요청에 사용
     */
    @GetMapping("") //URL Mapping을 지정
    public String hello() {
        return "hello world!";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "")
//    public String hello2() {
//        return "Nice to Meet You!";
//    }

    //"/"은 처음만 생략 가능
    @GetMapping("1")
    public String hello2() {
        return "hello world!!";
    }

    @GetMapping("/get1")
    public String get1() {
        return "1";
    }

    @GetMapping("/get1/신혜란")
    public String get2() {
        return "신혜란";
    }

    /*
    @PathVariable
    1. URL에서 각 구분자에 들어가는 값을 처리할 때 사용
    2. /뒤에 특정 값 {}을 name이라는 Parameter로 받으라는 의미
    3. /{name}의 값을 @PathVariable(value="name")으로 받고
    4. 이것을 다시 String name으로 변환
     */
    @GetMapping("/name/{name}")
    public String getName(@PathVariable(value = "name") final String name) {
        return name;
    }

    /*
    @RequestParam
    1. QueryString을 처리할 때 사용
    2. /part?part=서버 에서 ?part와 같은 문법
    value: queryString의 key 값
    defaultValue: queryString 값이 없을 경우의 기본값
     */
    @GetMapping("/part")
    public String getPart(@RequestParam(value = "part", defaultValue = "") final String part) {
        return part;
    }

    /*
    여러 개의 QueryString
    1. 여러 개의 QueryString을 받을 수 있음
    2. 요청 시 QueryString key 값 사이를 &로 이어주면 됨
     */
    @GetMapping("/info")
    public String getPart2(
            @RequestParam(value = "name") final String name,
            @RequestParam(value = "type", defaultValue = "yb") final String type) {
        return name + "이고 " + type + "입니다.";
    }

    /*
    QueryString의 key값을 같게 하면 배열로 받을 수 있음
     */
    @GetMapping("/num")
    public int number(@RequestParam(value = "num") final int[] num) {
        int sum = 0;
        for(int i: num) {
            sum += i;
        }
        return sum;
    }
}
