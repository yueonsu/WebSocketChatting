package chat.config;

import chat.model.RoomEntity;
import chat.model.UserEntity;
import chat.room.RoomController;
import chat.room.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.*;

public class EchoHandler extends TextWebSocketHandler {

    @Autowired
    private RoomService service;

    HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵
    HashMap<String, Object> roomSave = new HashMap<>();
    HashMap<String, Object> rmaster = new HashMap<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //메시지 발송
        String msg = message.getPayload();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = mapper.readValue(msg, Map.class);

        String sessionKey = String.valueOf(session.getId());
        roomSave.put(sessionKey, map.get("room"));
        Set<Map.Entry<String, Object>> entrySet = roomSave.entrySet();
        if(entrySet.size() <= 1) {
            System.out.println("--rmaster opertaion--");
            rmaster.put(session.getId(), map.get("room"));
        }
        System.out.println(entrySet.size());



        String strRoom = null;
        String strMapRoom = null;
        for(String key : sessionMap.keySet()) {
            WebSocketSession wss = sessionMap.get(key);
            System.out.println(key.toString());
            try {
                switch (map.get("cmd")) {
                    case "CMD_ENTER":
                        sessionKey = String.valueOf(wss);
                        strRoom = String.valueOf(roomSave.get(key));
                        strMapRoom = map.get("room");
                        if(strMapRoom.equals(strRoom)) {
                            wss.sendMessage(new TextMessage(map.get("msg")));
                        }
                        break;
                    case "CMD_SEND_MSG":
                        sessionKey = String.valueOf(wss);
                        strRoom = String.valueOf(roomSave.get(key));
                        strMapRoom = map.get("room");
                        if(strMapRoom.equals(strRoom)) {
                            wss.sendMessage(new TextMessage(map.get("uid") + ": " + map.get("msg")));
                        }
                        break;
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //소켓 연결
        super.afterConnectionEstablished(session);
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //소켓 종료
        String roomId = String.valueOf(roomSave.get(session.getId()));
        for(String key1 : rmaster.keySet()) {
            Object room = rmaster.get(key1);
            if(roomId == room) {
                for(String key2 : roomSave.keySet()) {
                    if(roomId == roomSave.get(key2)) {
                        RoomEntity re = new RoomEntity();
                        re.setIroom(Integer.parseInt(roomId));
                        delete(re);
                        sessionMap.remove(roomSave.remove(key2));
                    }
                }
            }
        }

        System.out.println("WEB Socket finished");
        System.out.println("roomId : " + roomId);

//        sessionMap.remove(session.getId());

        super.afterConnectionClosed(session, status);
    }

    public void delete(RoomEntity entity) {
        System.out.println("delete-Room : " + entity);
        int result = service.closeRoom(entity);
        System.out.println(result);
    }
}
