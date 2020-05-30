package com.ppp.designuser.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangli@elane.cn
 * @Despriction:
 * @Package: com.yangli.eurekaclienta.controller
 * @Date:Created in 2020/2/10 20:05
 * @Modify By:
 */
@RestController
//@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String test1() {
        return "hello world!--client - b";
    }

    @RequestMapping("/admin")
    public String test2() {
        return "admin *******";
    }

    @RequestMapping("/user")
    public String test3() {
        return "user ******";
    }
}
