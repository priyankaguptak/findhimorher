package com.build.something.dao;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.FacetField;
import com.google.code.linkedinapi.client.enumeration.ProfileField;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.PeopleSearch;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LinkedInDao {
    private final LinkedInApiClientFactory factory;
    private final LinkedInApiClient client;


    public LinkedInDao(LinkedInApiClientFactory factory, LinkedInApiClient client) {
        this.factory = factory;
        this.client = client;
    }

    public People getPerson(String firstName, String lastName) {
        Map<String, String> peopleMap = new HashMap<String, String>();
        Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
        searchParameters.put(SearchParameter.FIRST_NAME, firstName);
        searchParameters.put(SearchParameter.LAST_NAME, lastName);
        PeopleSearch peopleSearch = client.searchPeople(searchParameters, EnumSet.of(ProfileField.FIRST_NAME, ProfileField.LAST_NAME, ProfileField.ID, ProfileField.HEADLINE, ProfileField.LOCATION, ProfileField.LOCATION_COUNTRY, ProfileField.LOCATION_NAME, ProfileField.INDUSTRY, ProfileField.POSITIONS_COMPANY_NAME), EnumSet.of(FacetField.NAME, FacetField.CODE, FacetField.BUCKET_NAME, FacetField.BUCKET_CODE, FacetField.BUCKET_COUNT));
        People people = peopleSearch.getPeople();

        return peopleSearch.getPeople();
    }

    public static void main(String a[]) {
        final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance("kgaqqwflejmf", "EiekpaNtuGYuD49B");
        final LinkedInApiClient client = factory.createLinkedInApiClient("bec92e2f-b9c5-4a17-9305-87949edf42c8", "abe041a5-84f9-4a87-99aa-9171c99fbd45");
        LinkedInDao dao = new LinkedInDao(factory, client);
        System.out.print(dao.getPerson("Alex", "Field"));
    }
}
