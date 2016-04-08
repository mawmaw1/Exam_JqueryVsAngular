/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.DataFactory;
import model.Member;

/**
 * REST Web Service
 *
 * @author Magnus
 */
@Path("member")
public class MemberEndpoint {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    DataFactory df = new DataFactory();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MemberEndpoint
     */
    public MemberEndpoint() {
    }

    /**
     * Retrieves representation of an instance of rest.MemberEndpoint
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/complete")
    @Produces(MediaType.APPLICATION_JSON)

    public String getJson() {
        JsonArray result = new JsonArray();
        List<Member> members = df.getMembers();
        for (Member member : members) {
            JsonObject p1 = new JsonObject();
            p1.addProperty("id", member.getId());
            p1.addProperty("age", member.getAge());
            p1.addProperty("eyeColor", member.getEyeColor());
            p1.addProperty("name", member.getName());
            p1.addProperty("email", member.getEmail());

            JsonArray friends = new JsonArray();
            List<Member> friendslist = member.getFriends();
            for (Member m : friendslist) {
                JsonObject p2 = new JsonObject();
                p2.addProperty("id", m.getId());
                p2.addProperty("age", m.getAge());
                p2.addProperty("eyeColor", m.getEyeColor());
                p2.addProperty("name", m.getName());
                p2.addProperty("email", m.getEmail());
                friends.add(p2);
            }
            p1.add("friends", friends);

            result.add(p1);
        }
        return gson.toJson(result);
    }

    /**
     * PUT method for updating or creating an instance of MemberEndpoint
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
