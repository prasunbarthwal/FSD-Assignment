package com.fsd.sba.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "parent_task")
public class ParentTask implements Serializable {

    private static final long serialVersionUID =1L;


    @Id
    @Column(name="parent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   /* @OneToOne(mappedBy = "parentTask")
    private Task task;*/

    /*@OneToOne
    @MapsId
    private Task task;*/

    @Column(name="parent_task")
    private String parentTask;

}
