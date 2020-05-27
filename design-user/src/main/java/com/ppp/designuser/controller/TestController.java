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
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/1.0")
    public String test1() {
        return "hello world!--client - b";
    }

    @RequestMapping("/2.0/{id}")
    public String test2(@PathVariable("id") String id) {
        return "hello world!--client - b 且id=" + id;
    }
}
