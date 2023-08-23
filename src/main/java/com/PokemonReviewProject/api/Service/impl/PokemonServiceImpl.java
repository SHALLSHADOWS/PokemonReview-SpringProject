package com.PokemonReviewProject.api.Service.impl;

import com.PokemonReviewProject.api.Dto.PokemonDto;
import com.PokemonReviewProject.api.Exceptions.PokemonNotFoundException;
import com.PokemonReviewProject.api.Model.Pokemon;
import com.PokemonReviewProject.api.Repository.PokemonRepository;
import com.PokemonReviewProject.api.Service.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl  implements PokemonService {
    private PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto){
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDto pokemonResponse = new PokemonDto();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());
    return pokemonResponse;
    }

    @Override
    public List<PokemonDto> findAll() {



        List<Pokemon> allPokemon = pokemonRepository.findAll();
       return allPokemon.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
    }

    @Override
    public PokemonDto finById(int id) {

        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("Pokemon with the id "+id+ " Not Found"));

        return   mapToDto(pokemon);



    }

    @Override
    public PokemonDto updatePokemon(PokemonDto pokemonDto, int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("Pokemon with the id "+id+ " Not Found"));

        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        Pokemon updatePokemon = pokemonRepository.save(pokemon);

        return mapToDto(updatePokemon);


    }

    @Override
    public void deletePokemon(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(()-> new PokemonNotFoundException("Pokemon with the id "+id+ " Not Found"));

        pokemonRepository.delete(pokemon);
    }

    private  PokemonDto mapToDto(Pokemon pokemon){
        PokemonDto pokemonDto = new PokemonDto();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());

        return pokemonDto;
    }

    private  Pokemon mapToEtity(PokemonDto pokemonDto){
        Pokemon pokemon = new Pokemon();

        pokemon.setId(pokemonDto.getId());
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());

        return pokemon;

    }

}
