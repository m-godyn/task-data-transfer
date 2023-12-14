package pl.milgodyn.taskdatatransfer.infrastructure.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordinatesResponse {

    String lat;
    String lon;
    String name;
    @JsonProperty("display_name")
    String displayName;
    Address address;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Address(String country) {
    }
}
