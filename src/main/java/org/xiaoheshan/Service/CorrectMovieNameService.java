package org.xiaoheshan.Service;

import jakarta.ws.rs.*;

@Path("/moivename")
public interface CorrectMovieNameService {

    @GET
    @Path("/{movieName}")
    @Produces("application/json")
    String getMovieName(@PathParam("movieName") String movieName);
}
