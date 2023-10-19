package com.example.springbootdubboconsumer.web;

import com.example.springbootdubbointerface.dubbo.IEchoDubbo;
import com.example.springbootdubbointerface.feign.IEchoFeign;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/test")
public class EchoApi {
    @DubboReference
    private IEchoDubbo echoDubbo;

//    private final IEchoFeign echoFeign;
//
//    @GetMapping("/feign")
//    public void echoFeign(){
//        StopWatch watch = new StopWatch();
//        watch.start();
//        IntStream.range(0, 100).forEach(a -> {
//            echoFeign.hello();
//        });
//    }
    @GetMapping("/dubbo")
    public void echoDubbo(){
        echoDubbo.hello();
    }
}
