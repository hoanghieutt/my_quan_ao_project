package com.example.assigment_shoes.service.Impl;



import com.example.assigment_shoes.entity.ChatLieu;
import com.example.assigment_shoes.repository.ChatLieuRepository;
import com.example.assigment_shoes.service.ChatLieuService;
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
