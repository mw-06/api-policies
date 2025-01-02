package com.api.policies.modules.employee.infrastructure.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity()
@Table(name = "employee_employees")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "second_last_name", length = 50)
    private String secondLastName;

    @Column(name = "position", nullable = false, length = 100)
    private String position;
}
