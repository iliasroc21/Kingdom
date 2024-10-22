package org.tp.builder;

import lombok.NoArgsConstructor;
import org.tp.model.City;
import org.tp.model.Country;
import org.tp.model.KingDom;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class KingDomBuilder {
    private String king ;
    private List<Country> countries= new ArrayList<>();
    public KingDomBuilder addKing(String king){
        this.king= king;
        return this;
    }
    public KingDomBuilder addCountry(String country ,String...cityData){
        countries.add(new Country(country ).addCities(cityData));
        return this;
    }
    public KingDomBuilder addSoldiersOnEdges(String soldiersOnEdges){
        for(Country country  : countries){
            country.setSoldiersOnEdges(Integer.parseInt(soldiersOnEdges));
        }
        return this;
    }
    public KingDom build(){
        return new KingDom(king, countries);
    }
}