package com.example.springbootdubboprovider.dubboApi;

import com.example.springbootdubbointerface.dubbo.IEchoDubbo;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class EchoDubboApi implements IEchoDubbo {
    @Override
    public void hello() {
        System.out.println("Dubbo: hello" + "!!!");
    }
}
