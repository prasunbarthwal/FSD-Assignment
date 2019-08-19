package com.fsd.fsdcapsule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tasks")

public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", updatable = false, nullable = false)
    private Long id;

    /*@Column(name="parent_id")
    private Long parentId;
*/
    @Column(name = "task")
    private String task;

    @Column(name = "start_date")
    //  @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(name = "end_date")
    //@Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @Column(name = "priority")
    private Integer priority;

    @OneToOne(cascade = CascadeType.ALL)
    // @OneToOne(mappedBy = "task",cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    //@ToString.Exclude
    private ParentTask parentTask;

}
