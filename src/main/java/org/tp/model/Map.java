package org.tp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Map {
    private HashMap<Set<String>, Integer> map = new HashMap<>();
    public void addRoute(String route){
        String[] params = route.split(":");
        Set<String> routes  =new HashSet<>();
        routes.add(params[0]);
        routes.add(params[2]);
        map.put(routes, Integer.valueOf(params[1]));
    }

    public Country findNearestToKingdom(KingDom strongest) {
        int shortestDistance = Integer.MAX_VALUE;
        String nearestCountry = null ;
        Country result = null ;
        for(Country country :strongest.getCountries()){
            for(Set<String> routes : map.keySet()){
                int distance = map.get(routes);
                if(routes.contains(country.getCountryName())){
                    String otherCountry =  routes.stream().filter(
                            other->!other.equals(country.getCountryName())).
                            findFirst()
                            .orElse(null);
                    boolean otherCountryNotInStrongestKingdom = strongest.getCountries().stream()
                            .noneMatch(c -> c.getCountryName().equals(otherCountry));
                    if(otherCountry!=null && otherCountryNotInStrongestKingdom &&
                            distance < shortestDistance){
                        shortestDistance = distance;
                        nearestCountry = otherCountry;
                        result = country ;
                    }
                }
            }
        }
//        for(Set<String> routes  : map.keySet()){
//            int distance = map.get(routes);
//            // iterate over all the countries in the strongest kingdom
//            for(Country country : strongest.getCountries()){
//                if(routes.contains(country.getCountryName())){
//                    String otherCountry = routes.stream()
//                            .filter(c -> !c.equals(country.getCountryName()))
//                            .findFirst()
//                            .orElse(null);
//                    boolean otherCountryNotInStrongestKingdom = strongest.getCountries().stream()
//                            .noneMatch(c -> c.getCountryName().equals(otherCountry));
//                    if (otherCountry != null && !otherCountryNotInStrongestKingdom  && distance < shortestDistance) {
//                        shortestDistance = distance;
//                        nearestCountry = otherCountry;
//                    }
//                }
//            }
//        }
        return result;
    }
}
