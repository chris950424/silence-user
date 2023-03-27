package com.silence;

import com.silence.auth.client.EnableAuthStarterConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * AdminApplication
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAuthStarterConfiguration
@MapperScan("com.silence.useradmin.**.dao")
public class UserAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserAdminApplication.class, args);
    }
}
