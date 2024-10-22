package org.tp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class War {
    private List<KingDom> kingdoms;
    private Map map ;

    public void prepareAttack() {
        KingDom strongest = kingdoms.stream()
                .max(Comparator.comparingInt(KingDom::currentPower))
                .orElse(null);
        if(strongest!=null){
            //find the nearest kingdom
            Country nearest  = map.findNearestToKingdom(strongest);
            strongest.moveAramyToNearestCountry( nearest);
        }
    }
}
