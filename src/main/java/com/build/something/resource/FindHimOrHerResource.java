package com.build.something.resource;

import com.build.something.facade.PeopleRanker;
import com.yammer.metrics.annotation.Metered;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.HttpURLConnection;
import java.util.List;

@Path("/search/people")
public class FindHimOrHerResource {
    private final PeopleRanker peopleRanker;

    public FindHimOrHerResource(PeopleRanker peopleRanker) {
        this.peopleRanker = peopleRanker;
    }

    @GET
    @Metered
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSortedPeople(@QueryParam("fName") String fName,
                                    @QueryParam("lName") String lName,
                                    @QueryParam("association") String association) {
        List<String> peopleList = null;
        try {
            peopleList = peopleRanker.getSortedPeopleList(fName, lName);

        } catch (Exception ex) {
            return Response.status(HttpURLConnection.HTTP_INTERNAL_ERROR).entity(ex).build();
        }
        return Response.ok(peopleList).build();
    }
}
