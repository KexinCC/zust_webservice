package org.xiaoheshan.Service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.xiaoheshan.pojo.ResEntity;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ChatSoapService {
    @WebMethod(action = "sendMessage")
    public ResEntity sendMessage(String message);

}
