package com.example.springbootdubbointerface.feign.fallback;

import com.example.springbootdubbointerface.feign.IEchoFeign;
import org.springframework.stereotype.Component;

@Component
public class IEchoFeignFallback implements IEchoFeign {
    @Override
    public void hello() {
        System.out.println("Feign: hello" + "!!!");
    }
}
