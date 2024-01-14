package org.xiaoheshan.Service.Impl;

import jakarta.jws.WebService;
import org.xiaoheshan.Service.ChatSoapService;
import org.xiaoheshan.pojo.ResEntity;
import org.xiaoheshan.util.OpenAIAPI;

@WebService(endpointInterface = "org.xiaoheshan.Service.ChatSoapService",
        serviceName = "ChatSoapService")
public class ChatSoapImpl implements ChatSoapService {
    @Override
    public ResEntity sendMessage(String message) {
        return OpenAIAPI.invokeApi(message);
    }
}
