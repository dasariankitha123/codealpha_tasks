import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== AI CHATBOT =====");
        System.out.println("Hello! I am your AI Chatbot.");
        System.out.println("Type 'bye' to exit.");

        while (true) {

            System.out.print("\nYou: ");
            String input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Bot: Hello! How can I help you?");
            }
            else if (input.contains("name")) {
                System.out.println("Bot: My name is Java AI Chatbot.");
            }
            else if (input.contains("java")) {
                System.out.println("Bot: Java is a popular programming language.");
            }
            else if (input.contains("how are you")) {
                System.out.println("Bot: I am fine. Thank you!");
            }
            else if (input.contains("college")) {
                System.out.println("Bot: College is a great place to learn new skills.");
            }
            else if (input.contains("bye")) {
                System.out.println("Bot: Goodbye! Have a nice day.");
                break;
            }
            else {
                System.out.println("Bot: Sorry, I don't understand that.");
            }
        }

        sc.close();
    }
}