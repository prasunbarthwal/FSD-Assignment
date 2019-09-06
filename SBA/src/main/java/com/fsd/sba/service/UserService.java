package com.fsd.sba.service;

import com.fsd.sba.dto.UserDTO;
import com.fsd.sba.model.User;

import java.util.List;

public interface UserService {

     List<UserDTO> findAll();

     UserDTO findUser(Long id);

     User saveUser(UserDTO userDTO);

     User updateUser(UserDTO userDTO);

/*
     void delUser(Long taskId);
*/

}
