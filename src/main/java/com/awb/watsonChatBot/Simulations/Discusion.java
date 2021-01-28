package com.awb.watsonChatBot.Simulations;

import com.awb.watsonChatBot.Dtos.ContextV2;
import com.awb.watsonChatBot.Business.MessagingService;
import com.ibm.watson.assistant.v2.model.*;

import java.util.List;


public class Discusion {
    public Discusion(ContextV2 context) {
        this.context = context;
    }

    ContextV2 context;

    public void runContextualized(){

        //Contextualizes messaging
        MessageInput input1 = new MessageInput.Builder()
                .text("Salam")
                .build();
        MessageResponse messageResponse1 = MessagingService.createContextualizedMessage(context.getAssistant(), context.getSessionId(),input1);

        MessageInput input2;

// second message
        input2 = new MessageInput.Builder()
                .text("labas")
                .build();
         MessageResponse messageResponse2 = MessagingService.createContextualizedMessage(context.getAssistant(), context.getSessionId(),input2);

        System.out.println(messageResponse1);
        System.out.println(messageResponse2);
    }

    public void runStateLess(){

//StateLess Messaging
        MessageResponseStateless messageResponseStateless= MessagingService.createStateLessMessage(context.getAssistant());
        List<RuntimeResponseGeneric> responseGeneric = messageResponseStateless.getOutput().getGeneric();
        if(responseGeneric.size() > 0) {
            if(responseGeneric.get(0).responseType().equals("text")) {
                System.out.println(responseGeneric.get(0).text());
            }
        }
    }

}
