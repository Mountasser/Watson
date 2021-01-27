package Utils;

import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.*;

public interface AssistantUtils {

      String assistantId = "54e6ab5d-284d-4d37-b294-598a3aa8f540";
      String  endpoint = "https://api.eu-de.assistant.watson.cloud.ibm.com/instances/949c2cbb-63c9-4df8-99fd-1eb3d3b1bc4f";

     static String  createSession(Assistant assistant, String assistantId){
        CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(assistantId).build();
        return assistant.createSession(createSessionOptions).execute().getResult().getSessionId();
    }

     static void  deleteSession(String assistantId, String sessionId, Assistant assistant) {

        DeleteSessionOptions options = new DeleteSessionOptions.Builder(assistantId, sessionId).build();
        assistant.deleteSession(options).execute();
    }
     static Assistant  createAssistant(){
        Assistant assistant = new Assistant("2020-04-01");
        assistant.setServiceUrl(AssistantUtils.endpoint);
        return assistant;
    }
     static MessageResponse createContextualizedMessage(Assistant assistant, String sessionId, MessageInput input) {
        MessageContext context = new MessageContext.Builder()
                .build();
        // first message
        MessageOptions messageOptions = new MessageOptions.Builder()
                .assistantId(AssistantUtils.assistantId)
                .sessionId(sessionId)
                .input(input)
                .context(context)
                .build();

        return assistant.message(messageOptions).execute().getResult();
    }

     static MessageResponseStateless createStateLessMessage(Assistant assistant) {
        MessageStatelessOptions messageOptions = new MessageStatelessOptions.Builder(AssistantUtils.assistantId)
                .build();
        return assistant.messageStateless(messageOptions)
                .execute()
                .getResult();
    }
    static MessageResponseStateless createContextualizedMessageV2( Assistant assistant,String sessionId, MessageInputStateless input,MessageContextStateless context) {

        MessageStatelessOptions messageOptions = new MessageStatelessOptions.Builder(assistantId)
                .input(input)
                .context(context)
                .build();
        return  assistant.messageStateless(messageOptions)
                .execute()
                .getResult();
    }

   static  MessageInputStateless createTextInput(String text){
        return new MessageInputStateless.Builder()
                .messageType("text")
                .text(text)
                .build();
    }
    static MessageContextStateless createContext(){
        return new MessageContextStateless.Builder()
                .build();
    }
}
