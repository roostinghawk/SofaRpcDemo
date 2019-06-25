package me.liuwei.demo.application;

import com.alipay.sofa.rpc.config.ConsumerConfig;
import me.liuwei.demo.service.DemoService;

/**
 * @author admin
 * @date 2019/6/25
 */
public class Client {
    public static void main(String[] args) {
        ConsumerConfig<DemoService> consumerConfig = new ConsumerConfig<DemoService>()
                .setInterfaceId(DemoService.class.getName()) // 指定接口
                .setProtocol("bolt") // 指定协议
                .setDirectUrl("bolt://127.0.0.1:12200"); // 指定直连地址
        // 生成代理类
        DemoService helloService = consumerConfig.refer();
        while (true) {
            System.out.println(helloService.sayHello("world"));
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
        }
    }
}