package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.dto.ScopeDTO;
import com.okravtsiv.authservice.domain.model.entity.Scope;
import com.okravtsiv.authservice.domain.model.mappers.ScopeMapper;
import com.okravtsiv.authservice.domain.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scopes")
public class ScopeController {

    @Autowired
    private ScopeService scopeService;

    @PostMapping
    public ResponseEntity createScope(@RequestBody ScopeDTO scopeDTO) {
        Scope scope = ScopeMapper.INSTANCE.dtoToEntity(scopeDTO);
        scopeService.save(scope);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScopeDTO> getScope(@PathVariable Long id) {
        return ResponseEntity.ok(ScopeMapper.INSTANCE.entityToDto(scopeService.getOne(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteScope(@PathVariable Long id) {
        scopeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
