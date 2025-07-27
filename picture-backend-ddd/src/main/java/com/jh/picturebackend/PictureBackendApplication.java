package com.jh.picturebackend;

import org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

//关闭分库分表
@SpringBootApplication(exclude = {ShardingSphereAutoConfiguration.class})
@EnableAsync
@MapperScan("com.jh.picturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class PictureBackendApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(PictureBackendApplication.class, args);
    }

}
