package com.mer.questgame.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class QuestionTreeNode {

    private String context;
    private String correctAnswer;
    private String wrongAnswer;
    private QuestionTreeNode first;
    private QuestionTreeNode second;
    private boolean gameIsOver;
}
