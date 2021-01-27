import Utils.AssistantUtils;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        final Assistant assistant = AssistantUtils.createAssistant();
        final String sessionId = AssistantUtils.createSession(assistant, AssistantUtils.assistantId);

        //Contextualizes messaging
  /*      MessageInput input1 = new MessageInput.Builder()
                .text("Bismillah")
                .build();
        MessageResponse messageResponse1 = AssistantUtils.createContextualizedMessage(assistant, sessionId,input1);

        MessageInput input2;

// second message
        input2 = new MessageInput.Builder()
                .text("Alhamdoulilah")
                .build();
         MessageResponse messageResponse2 = AssistantUtils.createContextualizedMessage(assistant, sessionId,input2);

        System.out.println(messageResponse1);
        System.out.println(messageResponse2);
*/
//StateLess Messaging
    /*    MessageResponseStateless messageResponseStateless= AssistantUtils.createStateLessMessage(assistant);
        List<RuntimeResponseGeneric> responseGeneric = messageResponseStateless.getOutput().getGeneric();
        if(responseGeneric.size() > 0) {
            if(responseGeneric.get(0).responseType().equals("text")) {
                System.out.println(responseGeneric.get(0).text());
            }

    }*/
        MessageInputStateless messageInputStateless = AssistantUtils.createTextInput("");
        AssistantUtils.createContextualizedMessageV2(assistant, sessionId, messageInputStateless, AssistantUtils.createContext());
    }

}