package com.awb.watsonChatBot.model;


import java.io.Serializable;



public class ConversationRequest implements Serializable {

String inputMessage;
String inputMessageType;

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessageType() {
        return inputMessageType;
    }

    public void setInputMessageType(String inputMessageType) {
        this.inputMessageType = inputMessageType;
    }

    @Override
    public String toString() {
        return "ConversationRequest{" +
                "inputMessage='" + inputMessage + '\'' +
                ", inputMessageType='" + inputMessageType + '\'' +
                '}';
    }
}
