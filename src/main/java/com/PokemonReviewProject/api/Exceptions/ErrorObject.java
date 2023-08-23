package com.PokemonReviewProject.api.Exceptions;

import lombok.Data;

import java.security.Timestamp;
import java.util.Date;

@Data
public class ErrorObject {
    private  Integer satusCode;

    private String message;

    private Date timeStamp ;
}
