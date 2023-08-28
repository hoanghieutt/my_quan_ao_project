package com.example.duancore.service.Impl;


import com.example.duancore.entity.ChatLieu;
import com.example.duancore.repository.ChatLieuRepository;
import com.example.duancore.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getAllChatLieu() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu detailChatLieu(String id) {
        for (ChatLieu chatLieu : chatLieuRepository.findAll()) {
            if (chatLieu.getMaCL().equals(id)) {
                return chatLieu;
            }
        }
        return null;
    }

    @Override
    public void addChatLieu(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }

    @Override
    public void deleteChatLieu(String id) {
        ChatLieu chatLieu = detailChatLieu(id);
        chatLieuRepository.delete(chatLieu);
    }

    @Override
    public void updateChatLieu(ChatLieu chatLieu) {
        chatLieuRepository.save(chatLieu);
    }
}
