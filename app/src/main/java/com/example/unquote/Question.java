package com.example.unquote;

public class Question {
    int correctAnswer;
    int playerAnswer;
    int imageId;
    String questionText;
    String answer1;
    String answer2;
    String answer3;
    String answer4;

    public Question(int imageIdentifier, String questionString, String answerOne, String answerTwo,
                    String answerThree, String answerFour, int correctAnswerIndex) {
        imageId = imageIdentifier;
        questionText = questionString;
        answer1 = answerOne;
        answer2 = answerTwo;
        answer3 = answerThree;
        answer4 = answerFour;
        correctAnswer = correctAnswerIndex;
        playerAnswer = -1;
    }

    boolean isCorrect() {
        return correctAnswer == playerAnswer;
    }
}
