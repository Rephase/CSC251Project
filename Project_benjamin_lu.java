import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_benjamin_lu {

    public static void main(String[] args) {
        // Create an ArrayList to store Policy objects
        ArrayList<Policy> policies = new ArrayList<>();

        try {
            // Create a Scanner to read from the file
            File file = new File("PolicyInformation.txt");
            Scanner fileReader = new Scanner(file);

            // Read the file until no more lines remain
            while (fileReader.hasNextLine()) {

                // Read and parse the first line (Policy Number).
                // We should also handle blank lines if present.
                String policyNumStr = fileReader.nextLine().trim();
                if (policyNumStr.isEmpty()) {
                    // If this line is empty, skip it and continue.
                    // (Some files might have blank lines between records.)
                    continue;
                }

                int policyNumber = Integer.parseInt(policyNumStr);
                String providerName = fileReader.nextLine().trim();
                String firstName = fileReader.nextLine().trim();
                String lastName = fileReader.nextLine().trim();
                int age = Integer.parseInt(fileReader.nextLine().trim());
                String smokingStatus = fileReader.nextLine().trim();
                double height = Double.parseDouble(fileReader.nextLine().trim());
                double weight = Double.parseDouble(fileReader.nextLine().trim());

                // Create a new Policy object with these details
                Policy policy = new Policy(
                        policyNumber, 
                        providerName, 
                        firstName, 
                        lastName, 
                        age, 
                        smokingStatus, 
                        height, 
                        weight
                );

                // Add the Policy to our list
                policies.add(policy);
            }

            fileReader.close(); // Close the scanner

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'PolicyInformation.txt' was not found.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error: A numeric value could not be parsed. Check file formatting.");
            return;
        }

        // Counters for smoker vs. non-smoker
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // Display policy information and count smoking status
        for (Policy policy : policies) {

            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyHolderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyHolderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyHolderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " 
                               + policy.getPolicyHolderSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getPolicyHolderHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getPolicyHolderWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f%n", policy.calculateInsurancePrice());
            System.out.println(); // Blank line separating each policy's details

            // Increment smoker/non-smoker counters
            if (policy.getPolicyHolderSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Display the final counts
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
