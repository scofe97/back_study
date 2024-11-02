package network.chatting;

import java.util.ArrayList;
import java.util.List;

public class ChatSessionManager {

    private List<ChatSession> sessionList = new ArrayList<>();

    public synchronized List<ChatSession> getList() {
        return sessionList;
    }

    public synchronized void add(ChatSession session) {
        sessionList.add(session);
    }

    public synchronized void remove(ChatSession session) {
        sessionList.remove(session);
    }

    public synchronized void closeAll() {
        for (ChatSession session : sessionList) {
            session.close();
        }

        sessionList.clear();
    }
}
