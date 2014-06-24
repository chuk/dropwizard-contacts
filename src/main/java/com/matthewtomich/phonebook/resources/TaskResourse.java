package com.matthewtomich.phonebook.resources;

import com.matthewtomich.phonebook.dto.Contact;
import com.matthewtomich.phonebook.dto.Task;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by matthewtomich on 21/06/2014.
 */
public class TaskResourse {

    @GET
    @Path("/{id}")
    @Produces("application/vnd.tag-v1+json")
    public Response getTask(@PathParam("id") int id) {
        return Response
                .ok(new Task(9,"Task 1","Task Desc", new Date())).build();
    }
}
