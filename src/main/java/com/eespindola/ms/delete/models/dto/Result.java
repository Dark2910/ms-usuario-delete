package com.eespindola.ms.delete.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Result <T> extends Folio{

    @JsonProperty("isCorrect")
    private Boolean isCorrect;

    @JsonProperty("objects")
    private List<T> objects;

    @JsonProperty("object")
    private T object;

    @JsonPropertyOrder("exception")
    private Exception exception;

    @JsonProperty("message")
    private String message;

    public Result(String folioRequest, Boolean isCorrect, List<T> objects, T object, Exception exception, String message) {
        super(folioRequest);
        this.isCorrect = isCorrect;
        this.objects = objects;
        this.object = object;
        this.exception = exception;
        this.message = message;
    }

}
