package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.dto.RedirectUriDTO;
import com.okravtsiv.authservice.domain.model.entity.RedirectUri;
import com.okravtsiv.authservice.domain.model.mappers.RedirectUriMapper;
import com.okravtsiv.authservice.domain.service.RedirectUriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redirectUris")
public class RedirectUriController {

    @Autowired
    private RedirectUriService redirectUriService;

    @PostMapping
    public ResponseEntity createRedirectUri(@RequestBody RedirectUriDTO redirectUriDTO) {
        RedirectUri redirectUri = RedirectUriMapper.INSTANCE.dtoToEntity(redirectUriDTO);
        redirectUriService.save(redirectUri);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RedirectUriDTO> getRedirectUri(@PathVariable Long id) {
        return ResponseEntity.ok(RedirectUriMapper.INSTANCE.entityToDto(redirectUriService.getOne(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRedirectUri(@PathVariable Long id) {
        redirectUriService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
