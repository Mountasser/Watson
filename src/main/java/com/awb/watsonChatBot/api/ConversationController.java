package com.awb.watsonChatBot.api;


import com.awb.watsonChatBot.Business.ContextService;
import com.awb.watsonChatBot.Business.LogService;
import com.awb.watsonChatBot.Dtos.ContextV1;
import com.awb.watsonChatBot.Dtos.ConversationDto;
import com.awb.watsonChatBot.Mapper.LogConversationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ConversationController {

    @Autowired
    LogService logService;
    final ContextV1 contextV1 = ContextService.initializeContextV1();


    @RequestMapping("/getAllConversations")
    public List<ConversationDto> getAllConversations() {

        logService.addAllConversations(contextV1.getWorkSpaceId(),contextV1.getAssistant());

        List<ConversationDto> conversationDtos = logService.getAllConversationsFromRepository().stream().map(LogConversationMapper::map).collect(Collectors.toList());
        return conversationDtos;
    }
}
