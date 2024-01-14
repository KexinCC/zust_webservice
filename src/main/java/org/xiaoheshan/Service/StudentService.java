package org.xiaoheshan.Service;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import org.xiaoheshan.pojo.Student;


@Path("/students")
public interface StudentService {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    Student getStudent(@PathParam("id") String id);
}
