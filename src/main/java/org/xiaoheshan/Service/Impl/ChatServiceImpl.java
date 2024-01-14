package org.xiaoheshan.Service.Impl;

import org.xiaoheshan.util.OpenAIAPI;
import org.xiaoheshan.Service.ChatService;
import org.xiaoheshan.pojo.ResEntity;

public class ChatServiceImpl implements ChatService {
    @Override
    public ResEntity sendMessage(String message) {
        return OpenAIAPI.invokeApi(message);
    }
}
