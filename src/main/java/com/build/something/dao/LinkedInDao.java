package com.build.something.dao;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;

import java.util.EnumMap;
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

    public Map<String, String> getPerson(String fname, String lname) {
        Map<String, String> peopleMap = new HashMap<String, String>();
        Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
        searchParameters.put(SearchParameter.FIRST_NAME, fname);
        searchParameters.put(SearchParameter.LAST_NAME, lname);

        People people = client.searchPeople(searchParameters);
        for (Person person : people.getPersonList()) {
            peopleMap.put(person.getFirstName(), person.getCurrentStatus());

        }
        return peopleMap;
    }

    public static void main(String a[]) {
        final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance("kgaqqwflejmf", "EiekpaNtuGYuD49B");
        final LinkedInApiClient client = factory.createLinkedInApiClient("bec92e2f-b9c5-4a17-9305-87949edf42c8", "abe041a5-84f9-4a87-99aa-9171c99fbd45");
        LinkedInDao dao = new LinkedInDao(factory, client);
        System.out.print(dao.getPerson("ajay", "sridharan"));
    }
}
