package com.fsd.sba.service.impl;

import com.fsd.sba.dao.UserRepository;
import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.User;
import com.fsd.sba.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = users.stream().map(user -> UserDTO.builder()
                .userId(user.getUserId())
                .empId(user.getEmpId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName()).build()).collect(Collectors.toList());
        return userDTOList;

    }

    @Override
    public UserDTO findUser(Long id) {
        User user = userRepository.getOne(id);
        return UserDTO.builder()
                .userId(user.getUserId())
                .empId(user.getEmpId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName()).build();
    }

    @Override
    public User saveUser(UserDTO userDTO) {

        User user = User.builder()
                .empId(userDTO.getEmpId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .build();
        user = userRepository.save(user);
        return user;

    }

    @Override
    public User updateUser(UserDTO userDTO) {

        User user = userRepository.getOne(userDTO.getUserId());

        user.setEmpId(userDTO.getEmpId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());

        user = userRepository.save(user);

        return user;

    }

    /*@Override
    public void delUser(Long id) {

    }*/
}
