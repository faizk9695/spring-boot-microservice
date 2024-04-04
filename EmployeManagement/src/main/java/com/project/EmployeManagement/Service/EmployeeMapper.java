package com.project.EmployeManagement.Service;

import com.project.EmployeManagement.DTO.EmployeeDto;
import com.project.EmployeManagement.modal.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EmployeeDto toDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public Employee toEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    public List<EmployeeDto> toDTOList(List<Employee> employees) {
        return employees.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

