package com.awb.watsonChatBot.Simulations;

import com.awb.watsonChatBot.Business.LogService;
import com.awb.watsonChatBot.Dtos.ContextV1;
import com.awb.watsonChatBot.Dtos.ContextV2;
import com.ibm.watson.assistant.v1.Assistant;
import com.ibm.watson.assistant.v2.model.LogCollection;

public class RetrieveLogs {

    ContextV2 context;
    ContextV1 contextV1;
    LogService logService = new LogService();

    public RetrieveLogs(ContextV2 context) {
        this.context = context;
    }

    public RetrieveLogs(ContextV1 contextV1) {
        this.contextV1 = contextV1;
    }

    public void run(){
        LogCollection logCollection = LogService.retrieveLogsV2(context.getAssistant());
        System.out.println(logCollection);
    }
    public void run(Assistant assistant){
        com.ibm.watson.assistant.v1.model.LogCollection logCollection = LogService.retrieveLogsV1(contextV1.getWorkSpaceId(),assistant);
        System.out.println(logCollection);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logService.addAllConversations(contextV1.getWorkSpaceId(),assistant);
        logService.getAllConversationsFromRepository().stream().forEach(conver->System.out.println(conver));
    }
}
