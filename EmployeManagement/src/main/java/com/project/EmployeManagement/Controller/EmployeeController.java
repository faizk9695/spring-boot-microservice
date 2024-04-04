package com.project.EmployeManagement.Controller;

import com.project.EmployeManagement.DTO.EmployeeDto;
import com.project.EmployeManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

@GetMapping(value="attendance")
    public ResponseEntity<String>attendanceMarked(){
    RestTemplate httpJavaClient = new RestTemplate();
    ResponseEntity<String> response = httpJavaClient.exchange("http://localhost:8086/api/hrms/checkin",
            HttpMethod.GET, null, String.class);
    return new ResponseEntity<>(response.getBody(), HttpStatus.CREATED);
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto employeeDTO) {
        boolean savedEmployee = employeeService.addEmployee(employeeDTO);
        RestTemplate httpJavaClient = new RestTemplate();
        ResponseEntity<String> response = httpJavaClient.exchange("http://localhost:8085/api/v1/email",
                HttpMethod.GET, null, String.class);
        return new ResponseEntity<>(response.getBody(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDTO) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee Deleted",HttpStatus.NO_CONTENT);
    }
}

