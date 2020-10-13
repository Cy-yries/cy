package com.cy.web.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.web.entity.User;
import com.cy.web.mapper.UserMapper;
import com.cy.web.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Author Yin
 * @Date 2020/10/5 9:29
 * @Version 1.0
 **/
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
