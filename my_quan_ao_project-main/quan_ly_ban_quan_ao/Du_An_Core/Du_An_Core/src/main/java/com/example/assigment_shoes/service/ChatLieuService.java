package com.example.assigment_shoes.service;







import com.example.assigment_shoes.entity.ChatLieu;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAllChatLieu();
    ChatLieu detailChatLieu(String id);
    void  addChatLieu(ChatLieu chatLieu);
    void deleteChatLieu(String id);
    void  updateChatLieu(ChatLieu chatLieu);
}
