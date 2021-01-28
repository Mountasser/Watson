package com.awb.watsonChatBot.Mapper;

import com.awb.watsonChatBot.Dtos.ConversationDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.assistant.v1.model.Log;
import com.ibm.watson.assistant.v1.model.MessageRequest;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.model.RuntimeIntent;
import com.awb.watsonChatBot.model.Conversation;
import com.awb.watsonChatBot.model.ConversationRequest;
import com.awb.watsonChatBot.model.ConversationResponse;
import com.awb.watsonChatBot.Dtos.Intent;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public interface LogConversationMapper {


    static Conversation map(Log log){

        Conversation conversation = new Conversation();
        conversation.setConversation_id(log.getRequest().context().getConversationId());
        conversation.setConversationRequest(map(log.getRequest()));
        conversation.setConversationResponse(map(log.getResponse()));
        conversation.setLogId(log.getLogId());
        conversation.setRequestTimestamp(log.getRequestTimestamp());
        conversation.setResponseTimestamp(log.getResponseTimestamp());
        return conversation;
    }

    static ConversationRequest map(MessageRequest messageRequest){

        ConversationRequest conversationRequest = new ConversationRequest();
        conversationRequest.setInputMessage(messageRequest.input().getText());
        return conversationRequest;
    }
    static ConversationDto map(Conversation conversation){

        ConversationDto conversationDto = new ConversationDto();
        conversationDto.setConversation_id(conversation.getConversation_id());
        conversationDto.setInputMessage(conversation.getConversationRequest().getInputMessage());
        conversationDto.setOutputMessage(conversation.getConversationResponse().getOutputMessage());
        conversationDto.setOutputMessageType(conversation.getConversationResponse().getOutputMessageType());
        conversationDto.setRequestTimestamp(conversation.getRequestTimestamp());
        conversationDto.setRequestTimestamp(conversation.getResponseTimestamp());
        conversationDto.setIntentList(new Gson().fromJson(conversation.getConversationResponse().getIntentList(),new TypeToken<List<Intent>>(){}.getType()));
        return conversationDto;
    }
    static ConversationResponse map(MessageResponse messageResponse){

        ConversationResponse conversationResponse = new ConversationResponse();
        conversationResponse.setOutputMessage(messageResponse.getOutput().toString());
        conversationResponse.setIntentList(new Gson().toJson(CollectionUtils.emptyIfNull(messageResponse.getIntents()).stream().map(LogConversationMapper::map).collect(Collectors.toList())));
        return conversationResponse;
    }
    static Intent map(RuntimeIntent runtimeIntent){

        Intent intent = new Intent();
        intent.setConfidence(runtimeIntent.confidence());
        intent.setIntent(runtimeIntent.intent());
        return intent;
    }
}
