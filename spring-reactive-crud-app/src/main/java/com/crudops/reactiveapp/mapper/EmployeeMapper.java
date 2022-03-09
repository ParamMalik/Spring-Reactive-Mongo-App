package com.crudops.reactiveapp.mapper;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import com.crudops.reactiveapp.model.EmployeeModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Mono;


@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeModel toEmployeeModel(EmployeeDTO employeeDTO);

    EmployeeDTO toEmployeeDTO(EmployeeModel employeeModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updateEmployeeFromDto(EmployeeDTO employeeDTO, @MappingTarget EmployeeModel entity);


}
