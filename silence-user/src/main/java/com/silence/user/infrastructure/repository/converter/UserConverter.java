package com.silence.user.infrastructure.repository.converter;


import com.silence.user.domain.entity.User;
import com.silence.user.infrastructure.repository.DO.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * CategoryConverter
 *
 * @author leo
 * @version 1.1.0
 * @date 2022/1/8
 */
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserDO userToUserDO(User user);

    User userDoToUser(UserDO userDO);
}
