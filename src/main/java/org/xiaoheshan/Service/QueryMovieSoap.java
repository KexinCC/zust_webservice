package org.xiaoheshan.Service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.xiaoheshan.pojo.Movie;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface QueryMovieSoap {

    @WebMethod(action = "queryMovie")
    public Movie queryMovie(String movieName);
}
