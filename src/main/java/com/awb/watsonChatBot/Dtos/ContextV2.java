package com.awb.watsonChatBot.Dtos;

import com.ibm.watson.assistant.v2.Assistant;

public class ContextV2 {
    final Assistant assistant;
    final String sessionId;

    public ContextV2(Assistant assistant, String sessionId) {
        this.assistant = assistant;
        this.sessionId = sessionId;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public String getSessionId() {
        return sessionId;
    }
}
