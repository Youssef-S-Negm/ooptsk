package com.youssef.quiz;

import com.youssef.quiz.model.Question;
import com.youssef.quiz.model.Quiz;
import com.youssef.quiz.model.User;

import java.util.*;

public class QuizApplication {
    private User user;
    private Quiz quiz;
    private final ArrayList<Question> questionsBank = new ArrayList<>();

    public QuizApplication() {
        fillQuestionsBank();
    }

    public static void main(String[] args) {
        QuizApplication app = new QuizApplication();

        app.start();
    }

    private void fillQuestionsBank() {
        questionsBank.add(new Question(
                "Which feature of OOP indicates code reusability?",
                new String[]{"Abstraction", "Polymorphism", "Encapsulation", "Inheritance"},
                3));

        questionsBank.add(new Question(
                "Which of the following is a type of polymorphism in Java?",
                new String[]{"Compile time polymorphism", "Execution time polymorphism",
                        "Multiple polymorphism", "Multilevel polymorphism"},
                0));

        questionsBank.add(new Question(
                "When does method overloading is determined?",
                new String[]{"At run time", "At compile time", "At coding time", "At execution time"},
                1));

        questionsBank.add(new Question(
                "Which concept of Java is a way of converting real world objects in terms of class?",
                new String[]{"Abstraction", "Polymorphism", "Encapsulation", "Inheritance"},
                0));

        questionsBank.add(new Question(
                "Which concept of Java is achieved by combining methods and attribute into a class?",
                new String[]{"Abstraction", "Polymorphism", "Encapsulation", "Inheritance"},
                2));

        questionsBank.add(new Question(
                " What is it called if an object has its own lifecycle and there is no owner?",
                new String[]{"Aggregation", "Composition", "Encapsulation", "Association"},
                3));

        questionsBank.add(new Question(
                " What is the purpose of the \"super\" keyword?",
                new String[]{"To call the parent class constructor", "To reference the current class instance",
                        "To define an abstract method", "To access private members of a superclass"},
                0));

        questionsBank.add(new Question(
                "What is the result of using the \"equals()\" method in Java?",
                new String[]{"It compares object references", "It compares object content",
                        "It must be overridden in every class", "It compares class types"},
                1));

        questionsBank.add(new Question(
                "In Java, what is the visibility of a \"protected\" attribute?",
                new String[]{"Accessible only within its own package", "Accessible only within subclasses",
                        "Accessible within its own package and subclasses", "Accessible from anywhere"},
                2));

        questionsBank.add(new Question(
                "What is the purpose of the \"instanceof\" operator in Java?",
                new String[]{"To check the type of an object", "To create an instance of a class",
                        "To cast an object to a different type", "To compare two objects"},
                0));
    }

    private void start() {
        Scanner in = new Scanner(System.in);

        while (true) {
            if (user == null) {
                registerUser(in);
            }

            generateQuiz();
            displayQuiz(in);
            evaluateQuiz();

            if (shouldExit(in)) {
                break;
            }

            clearUserAnswers();
        }
    }

    private void registerUser(Scanner in) {
        System.out.print("Enter username: ");

        String name = in.nextLine();
        user = new User(name);
    }

    private void generateQuiz() {
        quiz = new Quiz(generateQuestions());
    }

    private void displayQuiz(Scanner in) {
        for (int i = 0; i < 5; i++) {
            System.out.print("\n" + (i + 1) + "/" + 5 + " ");

            quiz.displayQuestion(i);

            user.recordAnswer(registerAnswer(in));
        }
    }

    private void evaluateQuiz() {
        int score = quiz.calculateScore(user.getAnswers());

        System.out.println("\n" + user.getName() + ", you scored " + score + " out of 5.");
    }

    private boolean shouldExit(Scanner in) {
        System.out.print("\nEnter \"c\" to continue or \"e\" to exit: ");

        String input = in.next();

        if (input.equals("e"))
            return true;

        if (input.equals("c"))
            return false;

        System.out.println("Invalid input!");
        return shouldExit(in);
    }

    private void clearUserAnswers() {
        user.getAnswers().clear();
    }

    private ArrayList<Question> generateQuestions() {
        Set<Integer> chosenQuestions = new HashSet<>(5);
        ArrayList<Question> generatedQuestions = new ArrayList<>(5);
        System.out.println("Generating questions....");

        while (chosenQuestions.size() < 5) {
            int random = (int) (Math.random() * questionsBank.size());

            if (!chosenQuestions.contains(random)) {
                chosenQuestions.add(random);
                generatedQuestions.add(questionsBank.get(random));
            }
        }

        return generatedQuestions;
    }

    private int registerAnswer(Scanner in) {
        System.out.print("Enter your answer: ");

        try {
            int answer = in.nextInt();

            if (answer > -1 && answer < 4) {
                return answer;
            }
        } catch (InputMismatchException exception) {
            System.out.println(user.getName() + ", You must enter a number!");
            in.nextLine();
        }

        System.out.println("Invalid input, accepted range [0 - 3]");
        return registerAnswer(in);
    }

}
