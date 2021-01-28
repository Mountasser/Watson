package com.awb.watsonChatBot.Business;

import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.*;

public interface MessagingService {
    static  MessageInputStateless createTextInput(String text){
        return new MessageInputStateless.Builder()
                .messageType("text")
                .text(text)
                .build();
    }
    static MessageResponse createContextualizedMessage(Assistant assistant, String sessionId, MessageInput input) {
        MessageContext context = new MessageContext.Builder()
                .build();
        // first message
        MessageOptions messageOptions = new MessageOptions.Builder()
                .assistantId(AssistantService.assistantId)
                .sessionId(sessionId)
                .input(input)
                .context(context)
                .build();

        return assistant.message(messageOptions).execute().getResult();
    }

    static MessageResponseStateless createStateLessMessage(Assistant assistant) {
        MessageStatelessOptions messageOptions = new MessageStatelessOptions.Builder(AssistantService.assistantId)
                .build();
        return assistant.messageStateless(messageOptions)
                .execute()
                .getResult();
    }

}
