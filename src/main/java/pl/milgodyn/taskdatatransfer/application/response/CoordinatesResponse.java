package pl.milgodyn.taskdatatransfer.application.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Value
@Builder
public class CoordinatesResponse {

    String capital;
    BigDecimal latitude;
    BigDecimal longitude;
    String country;
    @JsonProperty("display_name")
    String displayName;
}
