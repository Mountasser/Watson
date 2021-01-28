package com.awb.watsonChatBot.Dtos;

import java.util.List;

public class ConversationDto {

    String logId;
    String conversation_id;
    String requestTimestamp;
    String responseTimestamp;
    String outputMessage;
    String outputMessageType;
    List<Intent> intentList;
    String inputMessage;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
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

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessageType() {
        return outputMessageType;
    }

    public void setOutputMessageType(String outputMessageType) {
        this.outputMessageType = outputMessageType;
    }

    public List<Intent> getIntentList() {
        return intentList;
    }

    public void setIntentList(List<Intent> intentList) {
        this.intentList = intentList;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }
}
