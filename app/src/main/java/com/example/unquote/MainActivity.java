package com.example.unquote;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int currentQuestionIndex;
    int totalCorrect;
    int totalQuestions;

    TextView questionTextView;
    ImageView questionImageView;
    TextView questionsRemainingTextView;
    Button answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button answer4Button;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_unquote_icon);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setElevation(0);

        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.textview_main_question);
        questionImageView = findViewById(R.id.imageview_main_quote_image);
        questionsRemainingTextView = findViewById(R.id.textview_main_question_count);
        answer1Button = findViewById(R.id.button_main_answer1);
        answer2Button = findViewById(R.id.button_main_answer2);
        answer3Button = findViewById(R.id.button_main_answer3);
        answer4Button = findViewById(R.id.button_main_answer4);
        submitButton = findViewById(R.id.button_main_submit);

        startNewGame();
    }

    ArrayList<Question> questionList = new ArrayList<Question>();

    public void  startNewGame(){
        Question ques1 = new Question(R.mipmap.img_quote_0, "How tall is the Eiffel tower?",
                "1024 ft", "1063 ft", "1124 ft","1163 ft",
                1);
        Question ques2 = new Question(R.mipmap.img_quote_1, "Who invented the computer " +
                "algorithm?", "Charles Babbage", "John Carmack", "Alan " +
                "Turing","Ada Lovelace", 3);
        Question ques3 = new Question(R.mipmap.img_quote_1, "What is the name for the " +
                "patch of skin found on your elbow?", "Elbow Skin", "Fascia " +
                "Elbora", "Wenis", "Todd", 2);
        questionList.add(ques1);
        questionList.add(ques2);
        questionList.add(ques3);
        totalCorrect = 0;
        totalQuestions = questionList.size();
        Question firstQuestion = chooseNewQuestion(questionList.size());
         displayQuestion(firstQuestion);
         displayQuestionsRemaining();
    }

    public Question chooseNewQuestion(int totalQuestions){
        currentQuestionIndex = generateRandomNumber(totalQuestions);
        return questionList.get(currentQuestionIndex);
    }

    public Question getCurrentQuestion(){
        return questionList.get(currentQuestionIndex);
    }

    public void onAnswerSubmission(){
        if (getCurrentQuestion().isCorrect()){
            totalCorrect += 1;
        }
        questionList.remove(getCurrentQuestion());
         displayQuestionsRemaining();
        if (questionList.size() == 0){
            System.out.println(getGameOverMessage(totalCorrect, totalQuestions));
            startNewGame();
        }
        else{
            chooseNewQuestion(questionList.size());
        }
        displayQuestion(getCurrentQuestion());
    }

    public void displayQuestionsRemaining() {
        questionsRemainingTextView.setText(String.valueOf(questionList.size()));
    }

    public void displayQuestion(Question question) {
        Log.i(TAG, "I am a logging pro! " + R.mipmap.img_quote_0);
        questionImageView.setImageResource(question.imageId);
        questionTextView.setText(question.questionText);
        answer1Button.setText(question.answer1);
        answer2Button.setText(question.answer2);
        answer3Button.setText(question.answer3);
        answer4Button.setText(question.answer4);
    }

    int generateRandomNumber(int max) {
        double randomNumber = Math.random();
        double result = max * randomNumber;
        return (int) result;
    }

    String getGameOverMessage(int totalCorrect, int totalQuestions) {
        if (totalCorrect == totalQuestions) {
            return "You got all " + totalQuestions + " right! You won!";
        } else {
            return "You got " + totalCorrect + " right out of " + totalQuestions + ". Better luck next time!";
        }
    }
}