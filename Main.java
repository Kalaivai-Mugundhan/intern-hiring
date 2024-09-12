import java.util.Scanner;

// Custom exception class
class InvalidInternException extends Exception {
    public InvalidInternException(String message) {
        super(message);
    }
}

// Candidate class
class Candidate {
    private String name;
    private String gender;
    private int percentage;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}

// Main class
public class Main {
    public static Candidate getCandidateDetails() throws InvalidInternException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the candidate details");

        System.out.println("Name:");
        String name = scanner.nextLine();

        System.out.println("Gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter percentage in 10th:");
        int percentage = scanner.nextInt();

        if (percentage < 50) {
            throw new InvalidInternException("Registration Failed. Percentage cannot be less than 50%.");
        } else {
            Candidate candidate = new Candidate();
            candidate.setName(name);
            candidate.setGender(gender);
            candidate.setPercentage(percentage);

            return candidate;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Intern Hiring Tool");

        try {
            Candidate candidate = getCandidateDetails();
            System.out.println("Registration Successful");
            // In a real application, save the candidate data to the database here
            System.out.println("Candidate Name: " + candidate.getName());
            System.out.println("Candidate Gender: " + candidate.getGender());
            System.out.println("Candidate Percentage: " + candidate.getPercentage());
        } catch (InvalidInternException e) {
            System.out.println(e.getMessage());
        }
    }
}
