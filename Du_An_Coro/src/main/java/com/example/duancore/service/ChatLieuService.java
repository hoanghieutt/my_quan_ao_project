package com.example.duancore.service;


import com.example.duancore.entity.ChatLieu;
//<<<<<<< HEAD
//=======
import com.example.duancore.entity.MauSac;
import org.springframework.data.domain.Page;
//>>>>>>> f5bb65c8d8fbc07712882e439361e06a69fc3e4c

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAllChatLieu();
    ChatLieu detailChatLieu(String id);
    void  addChatLieu(ChatLieu chatLieu);
    void deleteChatLieu(String id);
    void  updateChatLieu(ChatLieu chatLieu);
//<<<<<<< HEAD
//=======
    Page<ChatLieu> findPage(Integer pageNo, Integer pageSize);
    List<ChatLieu>sreach(String ten, String trangThai);
//>>>>>>> f5bb65c8d8fbc07712882e439361e06a69fc3e4c
}
