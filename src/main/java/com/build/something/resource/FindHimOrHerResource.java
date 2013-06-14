package com.build.something.resource;

import com.build.something.facade.PeopleRanker;
import com.build.something.view.AccessDenied;
import com.build.something.view.HomeView;
import com.build.something.view.Viewer;
import com.yammer.metrics.annotation.Metered;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/search/people")
@Produces(MediaType.TEXT_HTML)
public class FindHimOrHerResource {
    private final PeopleRanker peopleRanker;

    public FindHimOrHerResource(PeopleRanker peopleRanker) {
        this.peopleRanker = peopleRanker;
    }

    @GET
    @Metered
    //@Produces(MediaType.APPLICATION_JSON)
    public Viewer getSortedPeople(@QueryParam("id") String id) {
//        List<String> peopleList = null;
//        try {
//            peopleList = peopleRanker.getSortedPeopleList(fName, lName);
//
//        } catch (Exception ex) {
//            return Response.status(HttpURLConnection.HTTP_INTERNAL_ERROR).entity(ex).build();
//        }
        Viewer result = null;
        if (id != null && id.equalsIgnoreCase("really")) {
            result = new HomeView("secret viewer");

        } else {
            result = new AccessDenied("Need a secret key to view this page!");
        }

        return result;
    }
}
