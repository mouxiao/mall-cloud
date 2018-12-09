package com.mall.web.support.feign;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


/**
 * @author mouxiao
 * @remark
 * @date 2018/12/4 0004
 */
@Configuration
public class FeignConfiguration {


    @Bean
    public Logger.Level getLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public Decoder decoder(){
        return new ResponseEntityDecoder(new SpringDecoder(messageConverter()));
    }

    @Bean
    public Encoder encoder (){
        return new SpringEncoder(messageConverter());
    }

    /**
     * ps:使用feign契约的话，不能使用原来的spring注解的方式，
     * 否则会报 Method getLinksForTrack not annotated with HTTP method type (ex. GET, POST)错误
     * 应该使用注解@requstLine的方式
     * @return
     */
    @Bean
    public Contract contract(){
        return new Contract.Default();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }

    public ObjectFactory<HttpMessageConverters> messageConverter(){
        return new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return new HttpMessageConverters(new MessageConverter());
            }
        };
    }

    class MessageConverter extends MappingJackson2HttpMessageConverter{
        MessageConverter(){
            super();
        }

    }


}
