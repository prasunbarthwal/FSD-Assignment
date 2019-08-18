package com.fsd.fsdcapsule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Calendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {

    private Long id;

    private String task;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer priority;

    private String  parentTask;
}
