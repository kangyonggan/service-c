package com.kangyonggan.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author kyg
 */
@SpringBootApplication
@RestController("/")
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 获取用户信息
     *
     * @param username 用户名
     * @return 返回用户的基本信息
     */
    @GetMapping("userInfo")
    public Map<String, Object> userInfo(@RequestParam String username) {
        log.info("获取用户信息：{}", username);
        Map<String, Object> userInfo = new HashMap<>(8);

        Random random = new Random();
        userInfo.put("userId", UUID.randomUUID().toString());
        userInfo.put("joinDate", System.currentTimeMillis() - random.nextInt(10000));
        userInfo.put("fullName", "康永敢");
        userInfo.put("mobileNo", "18819920317");

        return userInfo;
    }

    /**
     * 用户账单查询
     *
     * @param username 用户名
     * @return 返回用户的本月账单
     */
    @GetMapping("queryOrders")
    public List<Map<String, Object>> queryOrders(@RequestParam String username) {
        log.info("用户账单查询：{}", username);
        List<Map<String, Object>> orders = new ArrayList<>();

        // 模拟大的响应体
        Random random = new Random();
        for (int i = 0; i < 5000; i++) {
            Map<String, Object> order = new HashMap<>(8);
            order.put("orderNo", UUID.randomUUID().toString());
            order.put("tradeDate", System.currentTimeMillis() - random.nextInt(10000));
            order.put("amount", random.nextDouble() * 1000);
            order.put("status", random.nextBoolean() ? "success" : "failure");

            orders.add(order);
        }

        return orders;
    }
}
