package team.fromsulaiman.quizSystem.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {

    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void shuffleQuestions() {
        Collections.shuffle(questions);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}