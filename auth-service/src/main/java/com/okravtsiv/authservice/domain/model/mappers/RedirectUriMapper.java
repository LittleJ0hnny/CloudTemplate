package com.okravtsiv.authservice.domain.model.mappers;

import com.okravtsiv.authservice.domain.model.dto.RedirectUriDTO;
import com.okravtsiv.authservice.domain.model.entity.RedirectUri;
import com.okravtsiv.authservice.domain.service.RedirectUriService;
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
public abstract class RedirectUriMapper {

    public static final RedirectUriMapper INSTANCE = Mappers.getMapper(RedirectUriMapper.class);

    private static RedirectUriService redirectUriService;

    @Mappings({@Mapping(target="redirectUri", source="value")})
    public abstract RedirectUriDTO entityToDto(RedirectUri redirectUri);

    @Mappings({@Mapping(target="value", source="redirectUri")})
    public abstract RedirectUri dtoToEntity(RedirectUriDTO redirectUriDTO);

    public Set<RedirectUri> stringsToRedirectUris(Set<String> strings) {
        Set<RedirectUri> redirectUris = redirectUriService.findByValues(strings);

        if(redirectUris.size() < strings.size()) {
            strings.removeAll(redirectUris.stream().map(RedirectUri::getValue).collect(Collectors.toSet()));
            throw new IllegalArgumentException("Provided redirect uri " + strings + " is not valid.");
        }

        return redirectUris;
    }

    public Set<String> redirectUrisToStrings(Set<RedirectUri> entities) {
        Set<String> emptySet = new HashSet<>();
        if(!CollectionUtils.isEmpty(entities)) {
            emptySet = entities.stream().map(RedirectUri::getValue).collect(Collectors.toSet());
        }
        return emptySet;
    }

    @Autowired
    public void setRedirectUriService(RedirectUriService redirectUriService) {
        RedirectUriMapper.redirectUriService = redirectUriService;
    }
}
