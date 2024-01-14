package org.xiaoheshan.Service.Impl;

import org.xiaoheshan.OpenAIAPI;
import org.xiaoheshan.Service.ChatService;

public class ChatServiceImpl implements ChatService {
    @Override
    public String chat(String message) {
        return OpenAIAPI.invokeApi(message);
    }
}
