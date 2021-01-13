package com.example.unquote;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.content.DialogInterface;


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

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(1);
            }
        });

        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(2);
            }
        });

        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(3);
            }
        });

        answer4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerSelected(4);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getCurrentQuestion().playerAnswer != -1) {
                    onAnswerSubmission();
                }
                else {
                    AlertDialog.Builder invalidAnswerDialog = new AlertDialog.Builder(MainActivity.this);
                    invalidAnswerDialog.setCancelable(true);
                    invalidAnswerDialog.setTitle("No Selection Made");
                    invalidAnswerDialog.setMessage("Please Choose an answer");
                    invalidAnswerDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    invalidAnswerDialog.create().show();
                }

            }
        });

        startNewGame();
    }

    ArrayList<Question> questionList = new ArrayList<Question>();

    public void  startNewGame(){
        Question question1 = new Question(R.mipmap.img_quote_0,
                "Pretty good advice,and perhaps a scientist did say it… Who actually did?",
                "Albert Einstein",
                "Isaac Newton",
                "Rita Mae Brown",
                "Rosalind Franklin",
                3);
        Question question2 = new Question(R.mipmap.img_quote_1,
                "Was honest Abe honestly quoted? Who authored this pithy bit of wisdom?",
                "Edward Stieglitz",
                "Maya Angelou",
                "Abraham Lincoln",
                "Ralph Waldo Emerson",
                1);
        Question question3 = new Question(R.mipmap.img_quote_2,
                "Easy advice to read, difficult advice to follow — who actually",
                "Martin Luther King Jr.",
                "Mother Teresa",
                "Fred Rogers",
                "Oprah Winfrey ",
                2);
        Question question4 = new Question(R.mipmap.img_quote_3,
                "Insanely inspiring,insanely incorrect(maybe). Who is the true source of this inspiration?",
                "Nelson Mandela",
                "Harriet Tubman",
                "Mahatma Gandhi",
                "Nicholas Klein",
                4);
        Question question5 = new Question(R.mipmap.img_quote_4,
                "A peace worth striving for — who actually reminded us of this?",
                "Malala Yousafzai",
                "Martin Luther King Jr.",
                "Liu Xiaobo",
                "Dalai Lama",
                2);
        Question question6 = new Question(R.mipmap.img_quote_5,
                "Unfortunately, true — but did Marilyn Monroe convey it or did someone else?",
                "Laurel Thatcher Ulrich",
                "Eleanor Roosevelt",
                "Marilyn Monroe",
                "Queen Victoria",
                1);
        Question question7 = new Question(R.mipmap.img_quote_6,
                "Here’s the truth, Will Smith did say this, but in which movie?",
                "Independence Day",
                "Bad Boys",
                "Men In Black",
                "The Pursuit of Happiness",
                3);
        Question question8 = new Question(R.mipmap.img_quote_7,
                "Which TV funny gal actually quipped this 1-liner?",
                "Ellen Degeneres",
                "Amy Poehler",
                "Betty White",
                "Tina Fay",
                4);
        Question question9 = new Question(R.mipmap.img_quote_8,
                "This mayor won’t get my vote — but did he actually give this piece of advice? And if not, who did?",
                "Forrest Gump, Forrest Gump",
                "Dorry, Finding Nemo",
                "Esther Williams",
                "The Mayor, Jaws",
                2);
        Question question10 = new Question(R.mipmap.img_quote_9,
                "Her heart will go on, but whose heart is it?",
                "Whitney Houston",
                "Diana Ross",
                "Celine Dion",
                "Mariah Carey",
                1);
        Question question11 = new Question(R.mipmap.img_quote_10,
                "He’s the king of something alright — to whom does this self-titling line belong to?",
                "Tony Montana, Scarface",
                "Joker, The Dark Knight",
                "Lex Luthor, Batman v Superman",
                "Jack, Titanic",
                4);
        Question question12 = new Question(R.mipmap.img_quote_11,
                "Is “Grey” synonymous for “wise”? If so, maybe Gandalf did preach this advice. If not, who did?",
                "Yoda, Star Wars",
                "Gandalf The Grey, Lord of the Rings",
                "Dumbledore, Harry Potter",
                "Uncle Ben, Spider-Man",
                1);
        Question question13 = new Question(R.mipmap.img_quote_12,
                "Houston, we have a problem with this quote — which space-traveler does this catch-phrase actually belong to?",
                "Han Solo, Star Wars",
                "Captain Kirk, Star Trek",
                "Buzz Lightyear, Toy Story",
                "Jim Lovell, Apollo 13",
                3);
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);
        questionList.add(question7);
        questionList.add(question8);
        questionList.add(question9);
        questionList.add(question10);
        questionList.add(question11);
        questionList.add(question12);
        questionList.add(question13);
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
        if (questionList.size() == 0) {
            String gameOverMessage = getGameOverMessage(totalCorrect, totalQuestions);
            System.out.println(gameOverMessage);
            AlertDialog.Builder gameOverDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            gameOverDialogBuilder.setCancelable(false);
            gameOverDialogBuilder.setTitle("Game Over!");
            gameOverDialogBuilder.setMessage(gameOverMessage);
            gameOverDialogBuilder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startNewGame();
                }
            });
            gameOverDialogBuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            gameOverDialogBuilder.create().show();
        }
        else {
            chooseNewQuestion(questionList.size());
            displayQuestion(getCurrentQuestion());
        }
    }

    public void displayQuestionsRemaining() {
        questionsRemainingTextView.setText(String.valueOf(questionList.size()));
    }

    public void displayQuestion(Question question) {
        questionImageView.setImageResource(question.imageId);
        questionTextView.setText(question.questionText);
        answer1Button.setText(question.answer1);
        answer2Button.setText(question.answer2);
        answer3Button.setText(question.answer3);
        answer4Button.setText(question.answer4);
    }

    public void onAnswerSelected(int answer) {
        Question currentQuestion = getCurrentQuestion();
        currentQuestion.playerAnswer = answer;
        Button answerButton = indexToButtonMap(answer);
        String answerString = indexToAnswerString(answer,currentQuestion);
        resetAnswerButtons(currentQuestion);
        answerButton.setText("✔ " + answerString);
    }

    public Button indexToButtonMap(int answer) {
        Button answerButton;
        switch (answer) {
            case 1:
                answerButton = answer1Button;
                break;
            case 2:
                answerButton = answer2Button;
                break;
            case 3:
                answerButton = answer3Button;
                break;
            case 4:
                answerButton = answer4Button;
                break;
            default:
                answerButton = answer1Button;
                break;
        }
        return answerButton;
    }

    public String indexToAnswerString(int answer, Question question) {
        String answerString;
        switch (answer) {
            case 1:
                answerString = question.answer1;
                break;
            case 2:
                answerString = question.answer2;
                break;
            case 3:
                answerString = question.answer3;
                break;
            case 4:
                answerString = question.answer4;
                break;
            default:
                answerString = question.answer1;
                break;
        }
        return answerString;
    }

    public void resetAnswerButtons(Question currentQuestion) {
        answer1Button.setText(currentQuestion.answer1);
        answer2Button.setText(currentQuestion.answer2);
        answer3Button.setText(currentQuestion.answer3);
        answer4Button.setText(currentQuestion.answer4);
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