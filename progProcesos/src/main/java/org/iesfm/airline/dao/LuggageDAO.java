package org.iesfm.airline.dao;

import org.iesfm.airline.entity.Luggage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LuggageDAO {
    private Map<String, Map<String, Map<Integer, Luggage>>> luggage = new HashMap<>();


    public List<Luggage> listLuggage(String flightId, String nif) {
        return new ArrayList<>(getLuggage(flightId, nif).values());
    }


    public boolean existLuggage(String flightId, String nif, int luggageId) {
        return getLuggage(flightId, nif).containsKey(luggageId);
    }


    public boolean addLuggage(String flightId, String nif, Luggage luggage) {
        if (existLuggage(flightId, nif, luggage.getId())) {
            return false;
        } else {
            getLuggage(flightId, nif).put(luggage.getId(), luggage);
            return true;
        }
    }

    public Luggage getLuggage(String flightId, String nif, int luggageId) {
        return getLuggage(flightId, nif).get(luggageId);
    }


    public boolean updateLuggage(String flightNumber, String nif, Luggage luggage) {
        if (existLuggage(flightNumber, nif, luggage.getId())) {
            getLuggage(flightNumber, nif).put(luggage.getId(), luggage);
            return true;
        } else {
            return false;
        }
    }

    private Map<Integer, Luggage> getLuggage(String flightId, String nif) {
        luggage.putIfAbsent(flightId, new HashMap<>());
        luggage.get(flightId).putIfAbsent(nif, new HashMap<>());
        return luggage.get(flightId).get(nif);
    }
}
