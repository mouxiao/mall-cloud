package com.mall.gateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mouxiao
 * @remark
 * @date 2018/12/6 0006 15:35
 */
@RestController
public class HystrixCommandController  {

    @RequestMapping("/fallback")
    public String fallback(){
        System.out.println("------------------------------熔断机制-----------------------------------");
        return "error";
    }

    @HystrixCommand(commandKey = "fetchIngredients")
    public String fetchIngredients(){
        return "error";
    }



}
