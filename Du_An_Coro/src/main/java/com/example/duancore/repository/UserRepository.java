package com.example.duancore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.duancore.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    User findByEmailAndPassword(String email, String password);

    User findByMaNV(String maNV);

}
