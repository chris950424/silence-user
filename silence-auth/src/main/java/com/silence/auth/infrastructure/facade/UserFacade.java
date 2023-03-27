package com.silence.auth.infrastructure.facade;

import com.silence.api.UserService;
import com.silence.auth.infrastructure.facade.costant.ClientTypeEnum;
import com.silence.api.UserDto;
import com.silence.auth.infrastructure.feign.UseApi;
import com.silence.auth.infrastructure.feign.UserAdminApi;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * UserFacade
 *
 * @author leo
 * @version 1.1.0
 * @date 2021/12/29
 */
@Component
public class UserFacade {


    private static final Log log = LogFactory.getLog(UserFacade.class);

    @Resource
    private UseApi userService;

    @Resource
    private UserAdminApi adminService;

//    @Resource
//    private UserAdminService adminService;

    public UserDto getUserByUseName(String username, String clientId) {
        log.info("用户名:" + username + "客户端：" + clientId, null);
        if (clientId.contains(ClientTypeEnum.ADMIN.getCode())) {
            return adminService.getUserAdminByUserAdminName(username);
        } else {
            return userService.getUserByUserName(username);

        }
    }

    public List<String> findPermissionsByUserId(String id, String clientId) {
        log.info("用户id:" + id + "客户端：" + clientId, null);
        if (clientId.contains(ClientTypeEnum.ADMIN.getCode())) {
            return adminService.findPermissionsByUserAdminId(id);
        } else {
            return userService.findPermissionsByUserId(id);
        }
    }


    public int register(UserDto dto) {
        return userService.addUser(dto);
    }
}
