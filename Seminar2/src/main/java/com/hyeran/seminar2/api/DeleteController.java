package com.hyeran.seminar2.api;

import com.hyeran.seminar2.model.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("delete")
public class DeleteController {

    @DeleteMapping("")  //리소스를 삭제하는 요청에 사용
    public String deleteUser(@RequestBody final User user) {
        return "delete success";
    }
}
