package com.example.duancore.service.Impl;

import com.example.duancore.entity.User;
import com.example.duancore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public  UserService(UserRepository userRepository){

          this.userRepository = userRepository;

    }

    public User findByMaNV(String maNV) {

        return userRepository.findByMaNV(maNV);

    }

}
