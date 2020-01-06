package com.okravtsiv.authservice.domain.model.mappers;

import com.okravtsiv.authservice.domain.model.dto.AuthGrantTypeDTO;
import com.okravtsiv.authservice.domain.model.entity.AuthGrantType;
import com.okravtsiv.authservice.domain.service.AuthGrantTypeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AuthGrantTypeMapper {

    public static final AuthGrantTypeMapper INSTANCE = Mappers.getMapper(AuthGrantTypeMapper.class);

    private static AuthGrantTypeService authGrantTypeService;

    @Mappings({@Mapping(target="grantType", source="value")})
    public abstract AuthGrantTypeDTO entityToDto(AuthGrantType authGrantType);

    @Mappings({@Mapping(target="value", source="grantType")})
    public abstract AuthGrantType dtoToEntity(AuthGrantTypeDTO authGrantTypeDTO);

    public Set<AuthGrantType> stringsToAuthGrantTypes(Set<String> strings) {
        Set<AuthGrantType> authGrantTypes = authGrantTypeService.findByValues(strings);

        if(authGrantTypes.size() < strings.size()) {
            strings.removeAll(authGrantTypes.stream().map(AuthGrantType::getValue).collect(Collectors.toSet()));
            throw new IllegalArgumentException("Provided auth grant type " + strings + " is not valid.");
        }

        return authGrantTypes;
    }

    public Set<String> authGrantTypesToStrings(Set<AuthGrantType> entities) {
        Set<String> emptySet = new HashSet<>();
        if(!CollectionUtils.isEmpty(entities)) {
            emptySet = entities.stream().map(AuthGrantType::getValue).collect(Collectors.toSet());
        }
        return emptySet;
    }

    @Autowired
    public void setAuthGrantTypeService(AuthGrantTypeService authGrantTypeService) {
        AuthGrantTypeMapper.authGrantTypeService = authGrantTypeService;
    }
}
