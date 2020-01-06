package com.okravtsiv.authservice.domain.model.mappers;

import com.okravtsiv.authservice.domain.model.dto.ScopeDTO;
import com.okravtsiv.authservice.domain.model.entity.Scope;
import com.okravtsiv.authservice.domain.service.ScopeService;
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
public abstract class ScopeMapper {

    public static final ScopeMapper INSTANCE = Mappers.getMapper(ScopeMapper.class);

    private static ScopeService scopeService;

    @Mappings({@Mapping(target="scope", source="value")})
    public abstract ScopeDTO entityToDto(Scope scope);

    @Mappings({@Mapping(target="value", source="scope")})
    public abstract Scope dtoToEntity(ScopeDTO scopeDTO);

    public Set<Scope> stringsToScopes(Set<String> strings) {
        Set<Scope> scopes = scopeService.findByValues(strings);

        if(scopes.size() < strings.size()) {
            strings.removeAll(scopes.stream().map(Scope::getValue).collect(Collectors.toSet()));
            throw new IllegalArgumentException("Provided scope " + strings + " is not valid.");
        }

        return scopes;
    }

    public Set<String> scopesToStrings(Set<Scope> entities) {
        Set<String> emptySet = new HashSet<>();
        if(!CollectionUtils.isEmpty(entities)) {
            emptySet = entities.stream().map(Scope::getValue).collect(Collectors.toSet());
        }
        return emptySet;
    }

    @Autowired
    public void setScopeService(ScopeService scopeService) {
        ScopeMapper.scopeService = scopeService;
    }
}
