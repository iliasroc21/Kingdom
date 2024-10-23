package org.tp.factory;

import org.tp.model.Country;
import org.tp.model.Map;

public class MapFactory {
    private static MapFactory instance ;
    private MapFactory(){

    }
    public static MapFactory getInstance(){
        if(instance ==null){
            synchronized (MapFactory.class){
                if(instance==null)instance = new MapFactory();
            }
        }
        return instance;
    }
    public Map create(){
        return createMap();
    }
    private  Map createMap(){
        return new Map();
    }
}
