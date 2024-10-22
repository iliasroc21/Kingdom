package org.tp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class KingDom {
    private String king;
    private List<Country> countries;
    public String report(){
        StringBuilder report = new StringBuilder();
        report.append(king).append(":|");
        for(Country country  :countries){
            report.append(country.toString()).append(", ");
        }
        report.setLength(report.length() - 2);
        report.append("|");

        return report.toString() ;
    }
    public int currentPower(){
        return countries.stream().mapToInt(Country::getTotalSoldiers).sum();
    }

    public void moveAramyToNearestCountry(Country nearest) {

        if(nearest==null)return ;
        int soldiersToMove =0;
        for(Country country : countries){
            if(!country.getCountryName().equals(nearest.getCountryName())){
                 soldiersToMove += country.getCities().stream()
                        .mapToInt(
                            city->{
                                city.setSoliders(city.getSoliders()/2);
                                return city.getSoliders();
                    }).sum();


            }
        }
        nearest.setSoldiersOnEdges(
                nearest.getSoldiersOnEdges()+soldiersToMove);
    }
}
