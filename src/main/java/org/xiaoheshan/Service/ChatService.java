package org.xiaoheshan.Service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/chat")
public interface ChatService {
    @GET
    @Path("/{message}")
    @Produces("application/json")
    String chat(@PathParam("message") String message);

}
