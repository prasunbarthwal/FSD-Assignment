package com.fsd.fsdcapsule.dao;

import com.fsd.fsdcapsule.model.ParentTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentTaskRepository extends JpaRepository <ParentTask,Long>{

}
