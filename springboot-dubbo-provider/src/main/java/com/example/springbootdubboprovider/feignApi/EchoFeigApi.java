package com.example.springbootdubboprovider.feignApi;

import com.example.springbootdubbointerface.feign.IEchoFeign;

public class EchoFeigApi implements IEchoFeign {
    @Override
    public void hello() {
        System.out.println("Feign: hello" + "!!!");
    }
}
