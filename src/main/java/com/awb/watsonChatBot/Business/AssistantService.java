package com.awb.watsonChatBot.Business;

import com.ibm.watson.assistant.v2.Assistant;

public interface AssistantService {

    String assistantId = "54e6ab5d-284d-4d37-b294-598a3aa8f540";
    String workSpaceId = "c35b32b3-3534-4aec-860e-5aa486b140bf";
    String  endpoint = "https://api.eu-de.assistant.watson.cloud.ibm.com/instances/949c2cbb-63c9-4df8-99fd-1eb3d3b1bc4f";

    static Assistant createAssistantV2(){
        Assistant assistant = new Assistant("2020-04-01");
        assistant.setServiceUrl(endpoint);
        return assistant;
    }
    static com.ibm.watson.assistant.v1.Assistant createAssistantV1(){
        com.ibm.watson.assistant.v1.Assistant assistant = new com.ibm.watson.assistant.v1.Assistant("2020-04-01");
        assistant.setServiceUrl(endpoint);
        return assistant;
    }
}
