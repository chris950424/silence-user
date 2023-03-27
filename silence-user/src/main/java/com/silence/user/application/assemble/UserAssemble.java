package com.silence.user.application.assemble;

import com.silence.api.UserDto;
import com.silence.user.domain.entity.User;
import com.silence.user.ui.entity.command.AddUserCommend;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



/**
 * PermissionAssemble
 *
 * @author leo
 * @version 1.1.0
 * @date 2022/1/7
 */
@Mapper
public interface UserAssemble {
    UserAssemble INSTANCE = Mappers.getMapper(UserAssemble.class);

    User aucToUser(AddUserCommend uac);

    UserDto userToUserDto(User userByUsername);
}
