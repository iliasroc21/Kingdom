package org.tp.builder;

import org.tp.model.City;
import org.tp.model.Country;

import java.util.List;

public class CountryBuilder {
    private String country ;
    private List<City> cities;

    public Country build(){
        return new Country(country , cities , 0 );
    }
}
