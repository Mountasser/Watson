package com.awb.watsonChatBot.model;

import java.io.Serializable;



public class ConversationResponse implements Serializable {
    String outputMessage;
    String outputMessageType;
    String intentList;

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

    public String getIntentList() {
        return intentList;
    }

    public void setIntentList(String intentList) {
        this.intentList = intentList;
    }

    @Override
    public String toString() {
        return "ConversationResponse{" +
                "outputMessage='" + outputMessage + '\'' +
                ", outputMessageType='" + outputMessageType + '\'' +
                ", intentList='" + intentList + '\'' +
                '}';
    }
}
