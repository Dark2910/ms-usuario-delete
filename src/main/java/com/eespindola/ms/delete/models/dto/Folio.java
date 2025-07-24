package com.eespindola.ms.delete.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Folio {

    @JsonProperty("folioRequest")
    private String folioRequest;

}

