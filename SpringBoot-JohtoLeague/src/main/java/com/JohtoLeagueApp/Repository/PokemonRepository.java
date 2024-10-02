package com.JohtoLeagueApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JohtoLeagueApp.Entities.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
