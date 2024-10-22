package org.tp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int soliders ;
    private int citizens;

    @Override
    public String toString() {
        return soliders+"-"+citizens ;
    }
}
