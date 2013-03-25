package com.build.something.facade;

import com.build.something.dao.LinkedInDao;
import com.google.code.linkedinapi.schema.People;
import com.google.code.linkedinapi.schema.Person;
import com.google.common.base.Functions;
import com.google.common.collect.Ordering;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ajaypromodh
 * Date: 13-03-24
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class PeopleRanker {
    private final LinkedInDao linkedInDao;
    // private final SolrDao solrDao;


    public PeopleRanker(LinkedInDao linkedInDao) {
        this.linkedInDao = linkedInDao;
    }

    public List<String> getSortedPeopleList(String firstName, String lastName) {
        //TODO: Talk to solrDao that would give a list of people salary pair. Then sort them on a logic
        People linkedInPeople = linkedInDao.getPerson(firstName, lastName);
        Map<String, BigDecimal> personSalaryMap = new HashMap<String, BigDecimal>();
        for (Person person : linkedInPeople.getPersonList()) {
            String key = person.getFirstName() + "_" + person.getLastName() + "_" + person.getCurrentStatus();
            personSalaryMap.put(key, getSalary(person));
        }
        Map<String, String> mockPeopleList = new HashMap<String, String>();
        List<String> sortedPeople = Ordering.natural().onResultOf(Functions.forMap(personSalaryMap)).immutableSortedCopy(personSalaryMap.keySet());
        return sortedPeople;
    }

    private BigDecimal getSalary(Person person) {

        return BigDecimal.ZERO;
    }
}
