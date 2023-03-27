package com.silence.auth.infrastructure.sercurity.service;


import com.alibaba.fastjson.JSON;
import com.silence.api.UserDto;
import com.silence.auth.infrastructure.facade.UserFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * SpringDataUserDetailsService
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/28
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Resource
    private UserFacade userFacade;



    /**
     * 根据 账号查询用户信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String clientId = ((User) authentication.getPrincipal()).getUsername();
        UserDto userDto;
        List<String> permissions;
        userDto = userFacade.getUserByUseName(username, clientId);
        if (userDto == null) {
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        permissions = userFacade.findPermissionsByUserId(userDto.getId(), clientId);
        //根据用户的id查询用户的权限
        //将permissions转成数组
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        //将userDto转成json
        String principal = JSON.toJSONString(userDto);
        return User.withUsername(principal).password(userDto.getPassword()).authorities(permissionArray).build();
    }

}
