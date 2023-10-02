package OnlineQuizApplication;
//--ONLINE QUIZ APPLICATION--//
import java.util.*;

class Quiz {
    private String topic;
    private Map<String, String> questions;

    public Quiz(String topic) {
        this.topic = topic;
        this.questions = new HashMap<>();
    }

    public void addQuestion(String question, String correctAnswer) {
        questions.put(question, correctAnswer);
    }

    public String getTopic() {
        return topic;
    }

    public Map<String, String> getQuestions() {
        return questions;
    }
}

class QuizApp {
    private List<Quiz> quizzes;
    private Scanner scanner;

    public QuizApp() {
        quizzes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void createQuiz() {
        System.out.print("Enter the topic for the quiz: ");
        String topic = scanner.nextLine();
        Quiz quiz = new Quiz(topic);

        System.out.println("Enter questions and correct answers for the quiz. Enter 'q' to finish.");
        while (true) {
            System.out.print("Enter question: ");
            String question = scanner.nextLine();

            if (question.equals("q"))
                break;

            System.out.print("Enter correct answer: ");
            String correctAnswer = scanner.nextLine();
            quiz.addQuestion(question, correctAnswer);
        }

        quizzes.add(quiz);
        System.out.println("Quiz created successfully!");
    }

    public void startQuiz() {
        System.out.println("Available quizzes: ");
        for (int i = 0; i < quizzes.size(); i++) {
            System.out.println((i + 1) + ". " + quizzes.get(i).getTopic());
        }

        System.out.print("Select a quiz to start (1-" + quizzes.size() + "): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice < 1 || choice > quizzes.size()) {
            System.out.println("Invalid choice. Exiting quiz.");
            return;
        }

        Quiz selectedQuiz = quizzes.get(choice - 1);
        int score = 0;

        for (Map.Entry<String, String> entry : selectedQuiz.getQuestions().entrySet()) {
            System.out.println("Question: " + entry.getKey());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(entry.getValue())) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + entry.getValue() + "\n");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + selectedQuiz.getQuestions().size());
    }
}

public class Project2 {
    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create a quiz");
            System.out.println("2. Start a quiz");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    quizApp.createQuiz();
                    break;
                case 2:
                    quizApp.startQuiz();
                    break;
                case 3:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
