package com.project.EmployeManagement.Repository;

import com.project.EmployeManagement.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employee, Long> {
    // You can define custom query methods here if needed
}
