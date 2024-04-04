package com.project.EmployeManagement.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    private long created_At;
    private long  update_At;

    private long deleted_At;

    private boolean isAttendanceMarked;

}
