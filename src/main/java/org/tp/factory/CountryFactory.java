package org.tp.factory;

import org.tp.model.Country;

public final  class CountryFactory {
    private static CountryFactory instance ;
    public Country create(){
        return createCountry();
    }
    private CountryFactory(){
    }
    public static CountryFactory getInstance(){
        if(instance ==null){
            synchronized (CountryFactory.class){
                if(instance==null)instance = new CountryFactory();
            }
        }
        return instance;
    }
    private  Country createCountry(){
        return new Country();
    }
}
