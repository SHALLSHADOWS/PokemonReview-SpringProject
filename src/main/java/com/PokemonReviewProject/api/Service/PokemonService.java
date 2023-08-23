package com.PokemonReviewProject.api.Service;

import com.PokemonReviewProject.api.Dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);

    List<PokemonDto> findAll();

    PokemonDto finById(int id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, int id);

    void deletePokemon(int id);

}
