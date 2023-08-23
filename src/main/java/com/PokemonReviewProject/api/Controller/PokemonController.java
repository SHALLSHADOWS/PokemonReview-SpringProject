package com.PokemonReviewProject.api.Controller;
import com.PokemonReviewProject.api.Dto.PokemonDto;
import com.PokemonReviewProject.api.Model.Pokemon;
import com.PokemonReviewProject.api.Service.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {
    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public ResponseEntity<List<PokemonDto>> getPokemons(){
        List<PokemonDto> pokemons = new ArrayList<>();

        pokemons = pokemonService.findAll();

        return ResponseEntity.ok(pokemons);


    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDto> pokemonDetail(@PathVariable int id ) {
        PokemonDto pokemonDto = pokemonService.finById(id);
        return  ResponseEntity.ok(pokemonDto);


    }

    @PostMapping ("pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto){

        PokemonDto pokemonCreatead = pokemonService.createPokemon(pokemonDto);

        return new ResponseEntity<>(pokemonCreatead, HttpStatus.CREATED);

    }

    @PutMapping ("pokemon/{id}/update")

    public  ResponseEntity<PokemonDto> updatePokemon(@RequestBody PokemonDto pokemonDto,@PathVariable("id") int pokemonId){

        PokemonDto pokemon = pokemonService.updatePokemon(pokemonDto,pokemonId);

        return ResponseEntity.ok(pokemon);
    }

    @DeleteMapping ("pokemon/{id}/delete")

    public  ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){

         pokemonService.deletePokemon(pokemonId);

        return ResponseEntity.ok(" Pokemon deleted Succefuly");
    }
// simple comment


}
