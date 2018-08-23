package com.ctrip.framework.apollo.use.cases.dynamic.datasource;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.ctrip.framework.apollo.use.cases.dynamic.datasource.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by kl on 2018/6/25. Content :动态数据源实例
 */
@EnableApolloConfig
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        Callable<Object> task = () -> {
            while (true) {
                try {
                    System.err.println(userRepository.findById(1).get().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (Throwable ex) {
                    ex.printStackTrace();
                }
            }
        };
        Executors.newSingleThreadExecutor().submit(task);
    }
}
