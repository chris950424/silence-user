package com.silence.useradmin.application.assemble;

import com.silence.useradmin.domain.entity.UserAdmin;
import com.silence.useradmin.ui.entity.command.AddUserAdminCommand;
import com.silence.useradmin.ui.entity.command.UpdateUserAdminCommand;
import com.silence.useradmin.ui.entity.command.UserAdminAndRoleCommand;
import com.silence.useradmin.ui.entity.dto.UserAdminDTO;
import com.silence.api.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * PermissionAssemble
 *
 * @author leo
 * @version 1.1.0
 * @date 2022/1/7
 */
@Mapper
public interface UserAdminAssemble {
    UserAdminAssemble INSTANCE = Mappers.getMapper(UserAdminAssemble.class);


    UserAdmin uaarcToUserAdmin(UserAdminAndRoleCommand uaarc);

    List<UserAdminDTO> userAdminsToUserAdminDTOS(List<UserAdmin> userAdmins);

    UserDto userAdminToUserDto(UserAdmin userAdminByUserAdminName);

    UserAdmin auacToUserAdmin(AddUserAdminCommand uac);

    UserAdmin uuacToUserAdmin(UpdateUserAdminCommand uuac);
}
