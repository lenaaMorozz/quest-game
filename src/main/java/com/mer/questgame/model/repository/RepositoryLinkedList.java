package com.mer.questgame.model.repository;

import com.mer.questgame.model.QuestionTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class RepositoryLinkedList implements Repository {

    private final LinkedList<QuestionTreeNode> questions = new LinkedList<>();
    private final ArrayList<String> context = new ArrayList<>();
    private final ArrayList<String> answers = new ArrayList<>();

    @Override
    public QuestionTreeNode getFirstQuestionTreeNode() {
        if (questions.size() == 0) {
            fillQuestions();
        }
        return questions.getLast();
    }

    private void fillQuestions() {
        int j = 0;
        for (int i = context.size() - 1; i >= 0; i--) {
            if (questions.size() < 2) {
                questions.add(new QuestionTreeNode(context.get(i), answers.get(i * 2), answers.get(i * 2 + 1), null,
                        null, true));
            } else if (i % 2 != 0) {
                questions.add(new QuestionTreeNode(context.get(i), "", "", null, null,
                        true));
            } else {
                questions.add(new QuestionTreeNode(context.get(i), answers.get(i * 2), answers.get(i * 2 + 1),
                        questions.get(j), questions.get(j + 1), false));
                j += 2;
            }
        }
    }

    {
        context.add("Ты ощущаешь легкую слабость и головокружение. " +
                "Ты огляделся вокруг себя, судя по теням пальм, сейчас примерно полдень. " +
                "Ты решаешь в первую очередь заняться:");
        answers.add("добычей воды и еды");
        answers.add("строительством жилья");
        context.add("ПОРАЖЕНИЕ! Головокружение и слабость были следствием обезвоживания, последние силы ты потратил на " +
                "строительство жилья, поэтому твой организм не выдержал, и ты умер.");
        String emptyAnswer = "";
        answers.add(emptyAnswer);
        answers.add(emptyAnswer);
        context.add("Ты слышишь вдалеке звук ручья, направляешься в его сторону, по пути видишь высокую пальму, " +
                "на вершине которой находятся несколько кокосов. Ты выбираешь:");
        answers.add("идти дальше до ручья");
        answers.add("залезть на пальму и достать кокосы");
        context.add("ПОРАЖЕНИЕ! Ты срываешься с высокой пальмы, падаешь с большой высоты на землю, и огромный кокос разбивает тебе голову.");
        answers.add(emptyAnswer);
        answers.add(emptyAnswer);
        context.add("Ты наткнулся на ключ с чистой и прохладной водой. Ты напился вдоволь, но долго здесь оставаться ты не можешь, " +
                "начинает темнеть, твои дальнейшие действия:");
        answers.add("искать место для сна");
        answers.add("искать пропитание");
        context.add("ПОРАЖЕНИЕ! Ты нашел пальму с бананами, и вот же везение! Рядом с пальмой было много упавших бананов, " +
                "ты поел, тут же под пальмой решил переночевать и умер от переохлаждения.");
        answers.add(emptyAnswer);
        answers.add(emptyAnswer);
        context.add("Ты нашел хорошее место для сна, но начинает холодать, твои действия:");
        answers.add("искать, чем утеплиться");
        answers.add("лечь сразу спать");
        context.add("ПОРАЖЕНИЕ! Ты лег спать и умер от переохлаждения.");
        answers.add(emptyAnswer);
        answers.add(emptyAnswer);
        context.add("ПОБЕДА! Ты нашел чем утеплиться и смог пережить эту холодную ночь! Но ты очень голоден, оглядевшись," +
                " ты увидел упавшие кокосы. Ты смог выжить на необитаемом острове!");
        answers.add(emptyAnswer);
        answers.add(emptyAnswer);

    }
}
