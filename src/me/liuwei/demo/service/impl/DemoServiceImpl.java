package me.liuwei.demo.service.impl;

import me.liuwei.demo.service.DemoService;

/**
 * @author admin
 * @date 2019/6/25
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String string) {
        System.out.println("Server receive: " + string);
        return "hello " + string + " ！";
    }
}
