package com.awb.watsonChatBot.Dtos;


import com.awb.watsonChatBot.Business.AssistantService;

public class ContextV1 {
    final com.ibm.watson.assistant.v1.Assistant assistant;
    String workSpaceId = AssistantService.workSpaceId;

    public ContextV1(com.ibm.watson.assistant.v1.Assistant assistant) {
        this.assistant = assistant;
    }

    public com.ibm.watson.assistant.v1.Assistant getAssistant() {
        return assistant;
    }

    public String getWorkSpaceId() {
        return workSpaceId;
    }
}