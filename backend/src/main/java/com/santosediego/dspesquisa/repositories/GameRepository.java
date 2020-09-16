package com.santosediego.dspesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santosediego.dspesquisa.entities.Game;

@Repository//Ou Component, porém o Repository é mais especififa para uma melhor semantica;
public interface GameRepository extends JpaRepository<Game, Long>{

}