package com.fsd.assignment.dao;

import com.fsd.assignment.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectJpaRepository extends CrudRepository<Subject,Long > {

        void delete(Subject deleted);

        List<Subject> findAll();


         Subject save(Subject persisted);
    Optional<Subject> findBySubject(Long id);


}
