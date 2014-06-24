package com.matthewtomich.phonebook.resources;

import com.matthewtomich.phonebook.dto.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewtomich on 21/06/2014.
 */

@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    /**
     * @param id contact-id
     * Standard JSON
     */
    @GET
    @Path("/{id}")
    @Produces("application/vnd.tag-v1+json")
    public Response getContact(@PathParam("id") int id) {
        return Response
                .ok(new Contact( id, "Joe", "Bloggs", "999999")).build();
    }

    /**
     * Accept Custom Version
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces("application/vnd.tag-v2+json")
    public Response getContactV2(@PathParam("id") int id) {
        return Response
                .ok(new Contact( id, "Jim", "Bloggs", "00000000")).build();
    }

    /**
     * Custom Header
     */
    @GET
    @Path("/{id}/header")
    @Produces("application/json")
    public Response getContact(@HeaderParam("tag-api-version") String version) {

        Contact contact = null;

        if ( version.equals("1.0") ) {
            contact = new Contact( 1, "Joe", "Bloggs", "1111111");
        }

        if ( version.equals("1.1") ) {
            contact = new Contact( 2, "Jim", "Smith", "999999");
        }

        return Response
                .ok(contact).build();

    }


    /**
     * Listing
     * @return
     */
    @GET
    @Produces("application/json")
    public Response getContactList() {

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact( 1, "Joe", "Bloggs", "999999"));
        contacts.add(new Contact( 2, "Jim", "Bloggs", "999999"));
        return Response
                .ok(contacts).build();
    }

    @POST
    public Response createContact( @FormParam("name") String name,@FormParam("phone") String phone) {
        return Response
                .created(null)
                .build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        return Response.noContent().build();
    }


    @PUT
    @Path("/{id}")
    public Response updateContact(Contact contact) {
        return Response
                .ok(new Contact( contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getPhone())).build();
    }

}
