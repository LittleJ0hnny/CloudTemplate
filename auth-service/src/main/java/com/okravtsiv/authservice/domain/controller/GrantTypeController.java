package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.dto.AuthGrantTypeDTO;
import com.okravtsiv.authservice.domain.model.entity.AuthGrantType;
import com.okravtsiv.authservice.domain.model.mappers.AuthGrantTypeMapper;
import com.okravtsiv.authservice.domain.service.AuthGrantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grantTypes")
public class GrantTypeController {

    @Autowired
    private AuthGrantTypeService authGrantTypeService;

    @PostMapping
    public ResponseEntity createAuthGrantType(@RequestBody AuthGrantTypeDTO authGrantTypeDTO) {
        AuthGrantType authGrantType = AuthGrantTypeMapper.INSTANCE.dtoToEntity(authGrantTypeDTO);
        authGrantTypeService.save(authGrantType);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthGrantTypeDTO> getAuthGrantType(@PathVariable Long id) {
        return ResponseEntity.ok(AuthGrantTypeMapper.INSTANCE.entityToDto(authGrantTypeService.getOne(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuthGrantType(@PathVariable Long id) {
        authGrantTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
