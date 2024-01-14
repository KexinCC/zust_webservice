package org.xiaoheshan.Service;

import jakarta.ws.rs.*;
import org.xiaoheshan.pojo.ResEntity;

@Path("/sendMessage")
public interface ChatService {
    @GET
    @Path("/{message}")
    @Produces("application/json")
    ResEntity sendMessage(@PathParam("message") String message);

}
