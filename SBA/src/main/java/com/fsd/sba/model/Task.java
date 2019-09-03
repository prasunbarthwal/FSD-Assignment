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
@Entity(name = "task")

public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", updatable = false, nullable = false)
    private Long id;

    /*@Column(name="parent_id")
    private Long parentId;
*/
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "task")
    private String task;

    @Column(name = "task_status")
    private String status;

    @Column(name = "start_date")
    //  @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "end_date")
    //@Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @Column(name = "priority")
    private Integer priority;

   /* @OneToOne(cascade = CascadeType.ALL)
    // @OneToOne(mappedBy = "task",cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    //@ToString.Exclude
    private ParentTask parentTask;*/

}
