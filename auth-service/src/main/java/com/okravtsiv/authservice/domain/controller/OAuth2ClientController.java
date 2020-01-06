package com.okravtsiv.authservice.domain.controller;

import com.okravtsiv.authservice.domain.model.dto.OAuth2ClientDTO;
import com.okravtsiv.authservice.domain.model.entity.OAuth2Client;
import com.okravtsiv.authservice.domain.model.mappers.OAuth2ClientMapper;
import com.okravtsiv.authservice.domain.service.OAuth2ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth2clients")
public class OAuth2ClientController {

    @Autowired
    private OAuth2ClientService oAuth2ClientService;

    @PostMapping
    public ResponseEntity createClient(@RequestBody OAuth2ClientDTO oAuth2ClientDTO) {
        OAuth2Client oAuth2Client = OAuth2ClientMapper.INSTANCE.dtoToEntity(oAuth2ClientDTO);
        oAuth2ClientService.save(oAuth2Client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OAuth2ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(OAuth2ClientMapper.INSTANCE.entityToDto(oAuth2ClientService.getOne(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        oAuth2ClientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
