package com.mer.questgame.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Player {
    private String name;
    private int quantityGames = 1;
}
