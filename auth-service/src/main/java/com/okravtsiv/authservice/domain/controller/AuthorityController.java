package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.dto.AuthorityDTO;
import com.okravtsiv.authservice.domain.model.entity.Authority;
import com.okravtsiv.authservice.domain.model.mappers.AuthorityMapper;
import com.okravtsiv.authservice.domain.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @PostMapping
    public ResponseEntity createAuthority(@RequestBody AuthorityDTO authorityDTO) {
        Authority authority = AuthorityMapper.INSTANCE.dtoToEntity(authorityDTO);
        authorityService.save(authority);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorityDTO> getAuthority(@PathVariable Long id) {
        return ResponseEntity.ok(AuthorityMapper.INSTANCE.entityToDto(authorityService.getOne(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        authorityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
