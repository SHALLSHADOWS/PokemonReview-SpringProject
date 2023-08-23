package com.PokemonReviewProject.api.Exceptions;

public class PokemonNotFoundException extends  RuntimeException {
    public  static  final  long serialVerisionUID = 1;

    public  PokemonNotFoundException(String message){
        super(message);
    }


}
