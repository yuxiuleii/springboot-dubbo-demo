package com.example.springbootdubbointerface.feign;

import com.example.springbootdubbointerface.feign.fallback.IEchoFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "producer-server", contextId = "IEchoFeign", fallback = IEchoFeignFallback.class)
public interface IEchoFeign {
    @GetMapping("/hello")
    void hello();
}
