import java.util.*;

public class QuizApp {
    static Scanner sc = new Scanner(System.in);
    static int score = 0;
    static int questionNumber = 0;
    static final int TIMER_SECONDS = 10; // time per question in seconds

    // Define the Question class
    static class Question {
        String questionText;
        String[] options;
        char correctAnswer;

        public Question(String questionText, String[] options, char correctAnswer) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public void displayQuestion() {
            System.out.println("\nQuestion " + (questionNumber + 1) + ": " + questionText);
            for (int i = 0; i < options.length; i++) {
                System.out.println((char) ('A' + i) + ". " + options[i]);
            }
        }

        public boolean checkAnswer(char answer) {
            return Character.toUpperCase(answer) == correctAnswer;
        }
    }

    // A simple timer that counts down
    static boolean runTimer(int seconds) {
        try {
            System.out.println("You have " + seconds + " seconds to answer.");
            for (int i = seconds; i > 0; i--) {
                Thread.sleep(1000);
                System.out.print(i + " ");
            }
            System.out.println("\nTime's up!");
            return false;
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted");
            return false;
        }
    }

    // Display the result after the quiz
    static void displayResult(int totalQuestions) {
        System.out.println("\nQuiz finished!");
        System.out.println("Your Score: " + score + " out of " +(2* totalQuestions));
        System.out.println("Percentage: " + ((score * 100) / (2* totalQuestions)) + "%");
    }

    public static void main(String[] args) {
System.out.println("\n------WELCOME TO JAVA QUIZ------");
System.out.println("---- Quiz Rules----\nR1.The Quiz contain 10 java Question.\nR2.Each question contain 2 marks.\nR3.Time to solve each question is 10 seconds\n");


        // Define the questions
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
    "Which of the following is not a valid data type in Java?",
    new String[]{"int", "float", "char", "real"}, 'D'));

        questions.add(new Question(
                "Which keyword is used to define a class in Java?",
                new String[]{" function", " class", "struct", "define"},
                'B'
        ));
        questions.add(new Question(
                " Which of these operators is used to allocate memory for an object in Java?",
                new String[]{"malloc ", "calloc", "new ", "delete "},
                'C'
        ));

questions.add(new Question(
                "Which method is the entry point for a Java program?",
                new String[]{"main()", "start()", "init() ", "run() "},
                'A'
        ));

questions.add(new Question(
                "Which of the following is not a valid access modifier in Java? ",
                new String[]{" public", " private", "internal ", "protected "},
                'C'
        ));

questions.add(new Question(
                "What is the default value of a local variable in Java? ",
                new String[]{"1. Zero", "2.Null", "3. False", "4.No default value "},
                'D'
        ));

questions.add(new Question(
                "Which of the following is a reserved keyword in Java? ",
                new String[]{"default", "implements", "object", "includes "},
                'B'
        ));

questions.add(new Question(
                "Which method can be used to find the length of a string in Java?",
                new String[]{"length() ", "size()", "getLength()", "strlen() "},
                'A'
        ));
questions.add(new Question(
                "What does the 'final' keyword do when applied to a variable in Java? ",
                new String[]{"Makes the variable constant ", "Allows the variable to change dynamically", " Creates an abstract method ", "Implements an interface "},
                'A'
        ));
questions.add(new Question(
                "What does JVM stands for in java? ",
                new String[]{"Java visual Machine", "Java virtual Machine", " Java Variable Machine", "Java Version Machine "},
                'B'
        ));

Scanner scanner = new Scanner(System.in);
System.out.println("Enter 'Start'  to continue the quiz ");
    String option = scanner.next();

switch(option)
{
 case "Start" :     for (Question question : questions) {
            questionNumber++;
            question.displayQuestion();
            
            // Timer for the question
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    // Skipping user input on timeout
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, TIMER_SECONDS * 1000);  // Schedule the task for timer

            System.out.print("Enter your answer (A/B/C/D): ");
            long startTime = System.currentTimeMillis();
            char answer = Character.toUpperCase(sc.next().charAt(0));
            long endTime = System.currentTimeMillis();

            timer.cancel();  // Cancel timer if user inputs answer

            if ((endTime - startTime) / 1000 < TIMER_SECONDS) { // Check if answered in time
                if (question.checkAnswer(answer)) {
                    System.out.println("Correct!");
                    score=score+2;
                } else {
                    System.out.println("Wrong! The correct answer was " + question.correctAnswer);
                }
            } else {
                System.out.println("You ran out of time! The correct answer was " + question.correctAnswer);
            }
        }

        displayResult(questions.size());  // Display the result at the end
    }
}
}
