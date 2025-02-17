import java.util.Scanner;

public class Project_benjamin_lu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter all necessary information
        System.out.print("Please enter the Policy Number: ");
        int policyNumber = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Please enter the Provider Name: ");
        String providerName = sc.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = sc.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double height = sc.nextDouble();

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double weight = sc.nextDouble();

        // Create an instance of Policy using the full-argument constructor
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);

        // Outputting policy results
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getPolicyHolderFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getPolicyHolderLastName());
        System.out.println("Policyholder’s Age: " + policy.getPolicyHolderAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getPolicyHolderSmokingStatus());
        System.out.printf("Policyholder’s Height: %.1f inches%n", policy.getPolicyHolderHeight());
        System.out.printf("Policyholder’s Weight: %.1f pounds%n", policy.getPolicyHolderWeight());
        System.out.printf("Policyholder’s BMI: %.2f%n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f%n", policy.calculateInsurancePrice());

        sc.close();
    }
}
