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

            while (fileReader.hasNextLine()) {
                // Read the 8 lines for one policy
                String policyNumStr = fileReader.nextLine().trim();
                if (policyNumStr.isEmpty()) {
                    // If you encounter an empty line, you can skip or break out
                    // but typically we just continue
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

                // Create a Policy object with the retrieved data
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

                // Add the Policy object to the ArrayList
                policies.add(policy);
            }

            // Close the file reader
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file PolicyInformation.txt was not found.");
            System.out.println("Make sure the file path is correct and try again.");
            return;  // Exit main if file not found
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from the file. Check the file format.");
            return;  // Exit main if incorrect format
        }

        // Now, output information for each policy
        // (This mimics what the old demo class did for a single policy,
        //  but we now do it for *all* the policies we read.)

        for (Policy policy : policies) {
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
            System.out.println();  // blank line separator
        }
    }
}
