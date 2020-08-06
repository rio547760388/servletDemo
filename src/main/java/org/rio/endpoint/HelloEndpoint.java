package org.rio.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.rio.bean.Users;
import org.rio.bean.common.Result;
import org.rio.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mloong
 * @version 0.0.1
 * <p></p>
 * @since 2020/8/3
 **/
@RestController("mvc")
@Slf4j
public class HelloEndpoint {

    @Autowired
    private UsersService usersService;

    @Value("${org.rio.test:-1}")
    private Long test;

    @Autowired
    Environment environment;

    @GetMapping("hello")
    public Result<Users> hello() {
        log.info("test: {}, {}", test, environment.getActiveProfiles());

        log.info("controller: {}", this);

        return Result.succ(usersService.findById(1L));
    }
}
