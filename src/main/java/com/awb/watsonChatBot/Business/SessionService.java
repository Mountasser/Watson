package com.awb.watsonChatBot.Business;

import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;

public interface SessionService {

    static String  createSession(Assistant assistant, String assistantId){
        CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(assistantId).build();
        return assistant.createSession(createSessionOptions).execute().getResult().getSessionId();
    }

    static void  deleteSession(String assistantId, String sessionId, Assistant assistant) {

        DeleteSessionOptions options = new DeleteSessionOptions.Builder(assistantId, sessionId).build();
        assistant.deleteSession(options).execute();
    }
}
