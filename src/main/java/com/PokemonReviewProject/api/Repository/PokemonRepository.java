package com.PokemonReviewProject.api.Repository;

import com.PokemonReviewProject.api.Model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
