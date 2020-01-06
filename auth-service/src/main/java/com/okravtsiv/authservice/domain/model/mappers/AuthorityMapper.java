package com.okravtsiv.authservice.domain.model.mappers;

import com.okravtsiv.authservice.domain.model.dto.AuthorityDTO;
import com.okravtsiv.authservice.domain.model.entity.Authority;
import com.okravtsiv.authservice.domain.service.AuthorityService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class AuthorityMapper {

    public static final AuthorityMapper INSTANCE = Mappers.getMapper(AuthorityMapper.class);

    private static AuthorityService authorityService;

    public abstract AuthorityDTO entityToDto(Authority authority);

    public abstract Authority dtoToEntity(AuthorityDTO authorityDTO);

    public Set<Authority> stringsToAuthorities(Set<String> strings) {
        Set<Authority> authorities = authorityService.findByAuthorityNames(strings);

        if(authorities.size() < strings.size()) {
            strings.removeAll(authorities.stream().map(Authority::getAuthority).collect(Collectors.toSet()));
            throw new IllegalArgumentException("Provided authoritie " + strings + " is not valid.");
        }

        return authorities;
    }

    public Set<String> authoritiesToStrings(Set<Authority> entities) {
        Set<String> emptySet = new HashSet<>();
        if(!CollectionUtils.isEmpty(entities)) {
            emptySet = entities.stream().map(Authority::getAuthority).collect(Collectors.toSet());
        }
        return emptySet;
    }

    @Autowired
    public void setAuthorityService(AuthorityService authorityService) {
        AuthorityMapper.authorityService = authorityService;
    }
}
