package com.awb.watsonChatBot.model;

import org.dizitart.no2.IndexType;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

import java.io.Serializable;


@Indices({
        @Index(value = "logId", type = IndexType.Unique),
        @Index(value = "requestTimestamp", type = IndexType.NonUnique),
        @Index(value = "responseTimestamp", type = IndexType.NonUnique),
        @Index(value = "conversationRequest.inputMessage", type = IndexType.Fulltext),
        @Index(value = "conversationRequest.inputMessageType", type = IndexType.Fulltext),
        @Index(value = "conversationResponse.outputMessage", type = IndexType.Fulltext),
        @Index(value = "conversationResponse.outputMessageType", type = IndexType.Fulltext),
        @Index(value = "conversationResponse.intentList", type = IndexType.Fulltext),
 })
public class Conversation  implements Serializable {

    @Id
    String logId;
    String conversation_id;
    String requestTimestamp;
    String responseTimestamp;
    ConversationResponse conversationResponse;
    ConversationRequest conversationRequest;

    public String getLogId() {
        return logId;
    }

    @Override
    public String toString() {
        return "Conversation{" +
                "logId='" + logId + '\'' +
                ", conversation_id='" + conversation_id + '\'' +
                ", requestTimestamp='" + requestTimestamp + '\'' +
                ", responseTimestamp='" + responseTimestamp + '\'' +
                ", conversationResponse=" + conversationResponse.toString() +
                ", conversationRequest=" + conversationRequest.toString() +
                '}';
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(String requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public String getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(String responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public ConversationResponse getConversationResponse() {
        return conversationResponse;
    }

    public void setConversationResponse(ConversationResponse conversationResponse) {
        this.conversationResponse = conversationResponse;
    }

    public ConversationRequest getConversationRequest() {
        return conversationRequest;
    }

    public void setConversationRequest(ConversationRequest conversationRequest) {
        this.conversationRequest = conversationRequest;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }
}