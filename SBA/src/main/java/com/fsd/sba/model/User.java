package com.fsd.sba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "lname")
    private String lastName;

    @Column(name = "fname")
    private String firstName;

    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "project_id")
    private Integer projectId;

   /* @OneToOne(cascade = CascadeType.ALL)
    // @OneToOne(mappedBy = "task",cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    //@ToString.Exclude
    private Project project;*/

}
