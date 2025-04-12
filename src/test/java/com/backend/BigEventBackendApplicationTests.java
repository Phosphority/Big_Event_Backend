package com.backend;

import com.backend.utils.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BigEventBackendApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(System.getenv("OSS_ACCESS_KEY_SECRET"));
        System.out.println(System.getenv("OSS_ACCESS_KEY_ID"));
    }

}
