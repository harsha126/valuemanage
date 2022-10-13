package com.valuemanage.api.v1.mapper;

import com.valuemanage.api.v1.model.DistributorDTO;
import com.valuemanage.domain.Distributor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DistributorListMapper {
    DistributorListMapper INSTANCE = Mappers.getMapper(DistributorListMapper.class);

    DistributorDTO DistributorToDistributorDTO(Distributor distributor);
}
