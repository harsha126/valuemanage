package com.valuemanage.api.v1.mapper;

import com.valuemanage.api.v1.model.RepresentativeDTO;
import com.valuemanage.domain.Representative;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RepresentativeListMapper {
    RepresentativeListMapper INSTANCE = Mappers.getMapper(RepresentativeListMapper.class);

    RepresentativeDTO RepresentativeToRepresentativeDTO(Representative representative);
}
