package com.fsd.assignment.service.impl;

import com.fsd.assignment.dao.SubjectJpaRepository;
import com.fsd.assignment.entity.Subject;
import com.fsd.assignment.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectJpaRepository subjectJpaRepository;

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectJpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        subjectJpaRepository.deleteById(id);
    }

    @Override
    public void delete(Subject deleted) {

    }

    @Override
    public List<Subject> findAll() {
        return null;
    }

    @Override
    public Subject save(Subject persisted) {
        return null;
    }
}
