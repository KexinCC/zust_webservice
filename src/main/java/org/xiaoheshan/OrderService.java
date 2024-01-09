package org.xiaoheshan;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;


@Path("/orders")
public interface OrderService {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    Order getOrder(@PathParam("id") String id);
}
