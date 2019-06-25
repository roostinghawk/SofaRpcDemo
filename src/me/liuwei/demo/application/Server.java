package me.liuwei.demo.application;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;
import me.liuwei.demo.service.DemoService;
import me.liuwei.demo.service.impl.DemoServiceImpl;

/**
 * @author admin
 * @date 2019/6/25
 */
public class Server {

    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig()
                .setProtocol("bolt") // 设置一个协议，默认bolt
                .setPort(12200) // 设置一个端口，默认12200
                .setDaemon(false); // 非守护线程

        ProviderConfig<DemoService> providerConfig = new ProviderConfig<DemoService>()
                .setInterfaceId(DemoService.class.getName()) // 指定接口
                .setRef(new DemoServiceImpl()) // 指定实现
                .setServer(serverConfig); // 指定服务端

        providerConfig.export(); // 发布服务
    }
}
