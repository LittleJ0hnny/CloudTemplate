package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.dto.ResourceDTO;
import com.okravtsiv.authservice.domain.model.entity.Resource;
import com.okravtsiv.authservice.domain.model.mappers.ResourceMapper;
import com.okravtsiv.authservice.domain.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping
    public ResponseEntity createResource(@RequestBody ResourceDTO resourceDTO) {
        Resource resource = ResourceMapper.INSTANCE.dtoToEntity(resourceDTO);
        resourceService.save(resource);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDTO> getResource(@PathVariable Long id) {
        return ResponseEntity.ok(ResourceMapper.INSTANCE.entityToDto(resourceService.getOne(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteResource(@PathVariable Long id) {
        resourceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
