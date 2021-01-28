package com.awb.watsonChatBot.Business;

import com.awb.watsonChatBot.Dtos.ContextV1;
import com.awb.watsonChatBot.Dtos.ContextV2;
import com.ibm.watson.assistant.v2.Assistant;

public interface ContextService {
    static ContextV2 initializeContextV2(){
        final Assistant assistant = AssistantService.createAssistantV2();
        final String sessionId = SessionService.createSession(assistant, AssistantService.assistantId);
        return new ContextV2(assistant,sessionId);
    }
    static ContextV1 initializeContextV1(){
        final com.ibm.watson.assistant.v1.Assistant assistant = AssistantService.createAssistantV1();
        return new ContextV1(assistant);
    }

}
