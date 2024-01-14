package org.xiaoheshan.Service;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.xiaoheshan.pojo.Movie;
import org.xiaoheshan.pojo.ReqEntity;

@Path("/querymovie")
public interface QueryMovie {

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Movie queryMovie(ReqEntity movieName);
}
