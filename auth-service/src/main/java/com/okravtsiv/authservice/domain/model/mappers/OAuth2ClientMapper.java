package com.okravtsiv.authservice.domain.model.mappers;

import com.okravtsiv.authservice.domain.model.dto.OAuth2ClientDTO;
import com.okravtsiv.authservice.domain.model.entity.OAuth2Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AuthGrantTypeMapper.class, AuthorityMapper.class, RedirectUriMapper.class, ResourceMapper.class, ScopeMapper.class})
public abstract class OAuth2ClientMapper {

    public static final OAuth2ClientMapper INSTANCE = Mappers.getMapper(OAuth2ClientMapper.class);

    public abstract OAuth2ClientDTO entityToDto(OAuth2Client oAuth2Client);

    public abstract OAuth2Client dtoToEntity(OAuth2ClientDTO oAuth2ClientDTO);
}
