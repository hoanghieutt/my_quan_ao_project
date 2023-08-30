package com.example.duancore.service;


import com.example.duancore.entity.ChatLieu;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAllChatLieu();
    ChatLieu detailChatLieu(String id);
    void  addChatLieu(ChatLieu chatLieu);
    void deleteChatLieu(String id);
    void  updateChatLieu(ChatLieu chatLieu);
}
