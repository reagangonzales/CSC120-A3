// To be able to get user input
import java.util.Scanner;

/* This program simulates a conversation with the user,
     * allowing for a specified number of interaction rounds.
     * It responds to user inputs by replacing certain words
     * with their mirrored counterparts or using canned responses
     * if no mirrored words are detected.
     *
     * @param arguments command line arguments not used
     */
class Conversation {
    
    public static void main(String[] arguments) {
        Scanner input = new Scanner(System.in); // Scanner object

        // Ask for the number of conversation rounds
        System.out.println("How many rounds?");
        int rounds = input.nextInt(); // Read user input
        input.nextLine(); // Clear the newline character

        // Array of canned responses
        String[] canned = {
            "Interesting, tell me more",
            "Why do you think that",
            "Mmm-hm",
            "Can you elaborate",
            "I see"
        };

        System.out.println("Hi there! What's on your mind?");
        
        // Initialize transcript array to hold both user inputs and bot responses
        String[] transcript = new String[2 * rounds + 2]; // 2 slots for each round + 2 for greeting and goodbye

        // Store initial bot greeting in the transcript
        transcript[0] = "Hi there! What's on your mind?";

        // Mirrored Words
        String[] mirroredWords = {"I", "you", "me", "am", "my", "your", "are"};
        String[] mirroredWith = {"you", "I", "you", "are", "your", "my", "am"};

        // Conversation loop
        //help
        for (int i = 0; i < rounds; i++) {
            // User Input
            String userInput = input.nextLine();

            // Store in Transcript
            transcript[i * 2 + 1] = userInput;

            // Split user input into words by splitting by space
            String[] words = userInput.split(" ");
            // String class to make response
            String userResponse = new String();
            boolean hasMirroredWord = false;

            // Loop through each word in users input
            for (String word : words) {
                boolean replaced = false;
                // Check if mirrored word
                for (int j = 0; j < mirroredWords.length; j++) {
                    if (word.equals(mirroredWords[j])) {
                        // Replace mirrored word
                        word = mirroredWith[j];
                        hasMirroredWord = true;
                        replaced = true;
                        break; // Exit loop once replacement is made
                    }
                }
                userResponse += word + " ";
            }
            if (!hasMirroredWord) {
                userResponse = canned[(int) Math.random() * canned.length];
            }
            // Store bot response in transcript
            transcript[i * 2 + 2] = userResponse;
            // Print bot response
            System.out.println(userResponse + "?");
        }

        // Goodbye message
        String goodbye = "See ya!";
        System.out.println(goodbye);

        // Store goodbye message in transcript
        transcript[2 * rounds + 1] = goodbye;

        // Print transcript
        System.out.println("\nTRANSCRIPT:");
        for (String line : transcript) {
            System.out.println(line);
        }
        input.close();
    }
}
