package com.awb.watsonChatBot.Repository;

import com.awb.watsonChatBot.model.Conversation;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConversationRepository {


    Nitrite db = Nitrite.builder()
            .compressed()
            .openOrCreate("user", "password");

    // create an object repository
    ObjectRepository<Conversation> repository = db.getRepository(Conversation.class);

    public void addConversation(Conversation conversation){
        repository.insert(conversation);
    }
    public List<Conversation> getAllConversations(){
        return (repository.find()).toList();
    }

}
