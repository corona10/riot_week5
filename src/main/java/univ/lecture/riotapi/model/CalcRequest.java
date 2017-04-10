package univ.lecture.riotapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by corona10 on 2017. 4. 10..
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalcRequest {
    private int teamId;
    private long now;
    private double result;
}
