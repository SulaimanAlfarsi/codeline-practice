package team.fromsulaiman.quizSystem.model;

import java.util.List;

public class Question {

    private String questionText;
    private String correctAnswer;
    private List<String> options;

    public Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }
}
