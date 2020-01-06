package com.okravtsiv.authservice.domain.model.mappers;

import com.okravtsiv.authservice.domain.model.dto.UserDTO;
import com.okravtsiv.authservice.domain.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AuthorityMapper.class)
public abstract class UserMapper {

    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserDTO entityToDto(User user);

    public abstract User dtoToEntity(UserDTO userDTO);
}
