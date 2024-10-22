package org.tp.builder;

import org.tp.model.KingDom;
import org.tp.model.Map;
import org.tp.model.War;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WarBuilder {
    private List<KingDom> kingdoms = new ArrayList<>();
    private Map map ;
    public WarBuilder addKingDom(KingDom kingDom){
        kingdoms.add(kingDom);
        return this;
    }
    public WarBuilder addMap(String mapData){
        this.map = new Map();
        String[] routes = mapData.split(",");
        for(String route : routes){
            map.addRoute(route);
        }
        return this;
    }
    public War build(){
        return new War(kingdoms , map);
    }
}
