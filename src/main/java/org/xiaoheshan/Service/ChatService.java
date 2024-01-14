package org.xiaoheshan.Service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.xiaoheshan.pojo.ResEntity;

@Path("/chat")
public interface ChatService {
    @GET
    @Path("/{message}")
    @Produces("application/json")
    ResEntity chat(@PathParam("message") String message);

}
