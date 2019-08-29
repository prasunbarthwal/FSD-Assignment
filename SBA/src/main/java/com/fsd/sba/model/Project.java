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
@Entity(name = "project")
public class Project implements Serializable {

    private static final long serialVersionUID =1L;


    @Id
    @Column(name="project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @OneToOne(mappedBy = "parentTask")
    private User task;*/

    /*@OneToOne
    @MapsId
    private User task;*/

    @Column(name = "start_date")
    //  @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "end_date")
    //@Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @Column(name = "priority")
    private Integer priority;


    @Column(name="project")
    private String projectName;

}
