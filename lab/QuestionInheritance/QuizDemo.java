package lab.QuestionInheritance;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizDemo {
    private ArrayList<QA> questionList = new ArrayList<>();

    private void add(QA question) {
        questionList.add(question);
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questionList.size(); i++) {
            QA q = questionList.get(i);
            q.displayQuestion();
            String answer = scanner.next();
            questionList.get(i).checkAnswer(answer);
            if (q.checkAnswer(answer)) {
                System.out.print("correct");
            } else {
                System.out.println("incorrect");
                q.displayAnswer();
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QuizDemo quiz = new QuizDemo();
        // Add basic question
        QA question1 = new QA("How many states are there?", "50");
        quiz.add(question1);

        // Add choice question
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("a. Sacramento");
        choices.add("b. San Francisco");
        QA question2 = new ChoiceQA("What is the capital of California?", "a", choices);
        quiz.add(question2);

        // Add number range question
        QA question3 = new NumberRangeQA("Give a number close to 50", "50", 10);
        quiz.add(question3);

        // Run the quiz
        quiz.run();

/*        // create an object of superclass (QA) and use it
        QA qa = new QA("How many states are there?", "50");
        qa.displayQuestion();

        // create an object of subclass (ChoiceQA) and use it.
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("a. Sacramento");
        choices.add("b. San Francisco");

        QA cqa = new ChoiceQA("What is the capital of California?", "a", choices);
        cqa.displayQuestion();
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        if (cqa.checkAnswer(answer)) {
            System.out.println("correct");
        } else {
            System.out.println("incorrect");
            cqa.displayAnswer();
        }*/
    }
}
