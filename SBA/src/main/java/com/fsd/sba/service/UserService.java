package com.fsd.sba.service;

import com.fsd.sba.dto.UserDTO;

import java.util.List;

public interface UserService {

     List<UserDTO> findAll();

     UserDTO findUser(Long id);

     void saveUser(UserDTO userDTO);

     void updateUser(UserDTO userDTO);

/*
     void delUser(Long id);
*/

}
