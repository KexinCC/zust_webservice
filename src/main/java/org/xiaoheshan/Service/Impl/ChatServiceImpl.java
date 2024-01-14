package org.xiaoheshan.Service.Impl;

import org.xiaoheshan.OpenAIAPI;
import org.xiaoheshan.Service.ChatService;
import org.xiaoheshan.pojo.ResEntity;

public class ChatServiceImpl implements ChatService {
    @Override
    public ResEntity chat(String message) {
        return OpenAIAPI.invokeApi(message);
    }
}
