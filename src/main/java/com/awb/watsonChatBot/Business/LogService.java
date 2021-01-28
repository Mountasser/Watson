package com.awb.watsonChatBot.Business;

import com.awb.watsonChatBot.Mapper.LogConversationMapper;
import com.awb.watsonChatBot.Repository.ConversationRepository;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.*;
import com.awb.watsonChatBot.model.Conversation;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LogService {

    @Autowired
    ConversationRepository conversationRepository;

    public LogService() {
    }

    public static LogCollection retrieveLogsV2(Assistant assistant){
        ListLogsOptions options = new ListLogsOptions.Builder(AssistantService.assistantId).build();
        return assistant.listLogs(options).execute().getResult();
    }
    public static com.ibm.watson.assistant.v1.model.LogCollection retrieveLogsV1(String assistantId, com.ibm.watson.assistant.v1.Assistant assistant){
        com.ibm.watson.assistant.v1.model.ListLogsOptions options = new com.ibm.watson.assistant.v1.model.ListLogsOptions.Builder(assistantId).build();
        return  assistant.listLogs(options).execute().getResult();
    }
    public List<Conversation> getAllConversationsFromWatson(String assistantId, com.ibm.watson.assistant.v1.Assistant assistant){
        return CollectionUtils.emptyIfNull(retrieveLogsV1(assistantId,assistant).getLogs()).stream().map(LogConversationMapper::map)
.collect(Collectors.toList());
    }
    public List<Conversation> getAllConversationsFromRepository(){
        return conversationRepository.getAllConversations();
    }
    public  void addAllConversations(String assistantId, com.ibm.watson.assistant.v1.Assistant assistant){
        getAllConversationsFromWatson(assistantId,assistant).stream().forEach(
                (conversation)-> conversationRepository.addConversation(conversation)
        );
    }

}
