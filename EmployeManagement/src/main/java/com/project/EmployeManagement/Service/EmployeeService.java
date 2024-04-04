package com.project.EmployeManagement.Service;

import com.project.EmployeManagement.DTO.EmployeeDto;
import com.project.EmployeManagement.Repository.EmployeRepository;
import com.project.EmployeManagement.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    private final EmployeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Get all employees
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employeeMapper.toDTOList(employees);
    }

    // Get employee by ID
    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return employeeMapper.toDTO(optionalEmployee.get());
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    // Add a new employee
    public boolean addEmployee(EmployeeDto employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return true;
    }

    // Update an existing employee
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDTO) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setPhoneNumber(employeeDTO.getPhoneNumber());
            employee.setDepartment(employeeDTO.getDepartment());
            // You can update other fields as needed
            Employee updatedEmployee = employeeRepository.save(employee);
            return employeeMapper.toDTO(updatedEmployee);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

