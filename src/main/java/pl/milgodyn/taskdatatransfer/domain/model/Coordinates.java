package pl.milgodyn.taskdatatransfer.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Coordinates {

    private String capital;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String country;
    private String displayName;
}
