package univ.lecture.riotapi.model;

import lombok.*;

/**
 * Created by corona10 on 2017. 4. 10..
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalcRequest {
    private int teamId;
    private long now;
    private double result;
}
