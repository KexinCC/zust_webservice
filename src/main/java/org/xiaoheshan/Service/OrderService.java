package org.xiaoheshan.Service;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.xiaoheshan.pojo.Order;

@Path("/orders")
public interface OrderService {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    Order getOrder(@PathParam("id") String id);
}
