package com.example.unit_test_app.mapping;

import com.example.unit_test_app.dto.UnitTestEntityDto;
import com.example.unit_test_app.model.UnitTestEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnitTestEntityMapper {
    UnitTestEntityMapper MAPPER = Mappers.getMapper( UnitTestEntityMapper.class );

    UnitTestEntity unitTestEntityDtoToUnitTestEntity(UnitTestEntityDto employeeDto);
    UnitTestEntityDto unitTestEntityToUnitTestEntityDto(UnitTestEntity employee);
}
