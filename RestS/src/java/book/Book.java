/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author HP
 */
@Path("/book") //URI
public class Book {
//
//    @GET
//    @Produces(MediaType.TEXT_XML)
//    public String sayHelloXML() {
//        String response = "<?xml version='1.0'?>"
//                + "<hello>Hello XML</hello>";
//        return response;
//    }
//    
    @GET
    @Produces(MediaType.TEXT_XML)
    //XML.JSON
    @Path("{name}")
    public String sayHelloXML(@PathParam ("name") String name) {
        String response = "<?xml version='1.0'?>"
                + "<hello>Hello XML "+name+"</hello>";
        return response;
    }
    
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String sayHelloHTML(){
//    String response="<h1>Hello HTML</h1>";
//    return response;
//   }
//    
//        @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String sayHelloJSON(){
//    String response=null;
//    return response;
//   }
}
