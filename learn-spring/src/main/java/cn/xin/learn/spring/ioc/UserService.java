package cn.xin.learn.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xin
 * @description: TODO
 * @date 2025年03月16日
 */
@Service
public class UserService {
    @Autowired
    private AbstractUser abstractUser;
    
}
