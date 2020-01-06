package com.okravtsiv.authservice.domain.model.mappers;

import com.okravtsiv.authservice.domain.model.dto.ResourceDTO;
import com.okravtsiv.authservice.domain.model.entity.Resource;
import com.okravtsiv.authservice.domain.repository.ResourceRepository;
import com.okravtsiv.authservice.domain.service.ResourceService;
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
public abstract class ResourceMapper {

    public static final ResourceMapper INSTANCE = Mappers.getMapper(ResourceMapper.class);

    private static ResourceService resourceService;

    @Mappings({@Mapping(target="resource", source="value")})
    public abstract ResourceDTO entityToDto(Resource resource);

    @Mappings({@Mapping(target="value", source="resource")})
    public abstract Resource dtoToEntity(ResourceDTO resourceDTO);

    public Set<Resource> stringsToResources(Set<String> strings) {
        Set<Resource> resources = resourceService.findByValues(strings);

        if(resources.size() < strings.size()) {
            strings.removeAll(resources.stream().map(Resource::getValue).collect(Collectors.toSet()));
            throw new IllegalArgumentException("Provided resource " + strings + " is not valid.");
        }

        return resources;
    }

    public Set<String> resourcesToStrings(Set<Resource> entities) {
        Set<String> emptySet = new HashSet<>();
        if(!CollectionUtils.isEmpty(entities)) {
            emptySet = entities.stream().map(Resource::getValue).collect(Collectors.toSet());
        }
        return emptySet;
    }

    @Autowired
    public void setResourceService(ResourceService resourceService) {
        ResourceMapper.resourceService = resourceService;
    }
}
