package com.fsd.sba.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
