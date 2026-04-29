package team.fromsulaiman.quizSystem.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public List<Question> getQuestions() {
        return questions;
    }
}