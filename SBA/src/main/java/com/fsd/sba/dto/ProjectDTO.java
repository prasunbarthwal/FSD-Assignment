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
public class ProjectDTO {

    private Long projectId;

    private String projectName;

    private String manager;

    private Long userId;

    private Integer priority;

    private Integer totalTask;

    private Integer completedTask;

    private LocalDate startDate;

    private LocalDate endDate;
}
