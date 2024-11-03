package chat.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static util.MyLogger.log;

public class SessionManager {

    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session) {
        sessions.add(session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }

        sessions.clear();
    }

    public void sendAll(String message) {
        for (Session session : sessions) {
            try {
                session.send(message);
            } catch (IOException e) {
                log(e);
            }
        }
    }

    public synchronized List<String> getALlUserNames() {
        return sessions.stream()
                .map(Session::getUserName)
                .filter(Objects::nonNull)
                .toList();
    }
}
