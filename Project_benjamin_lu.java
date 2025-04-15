import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Project_benjamin_lu {

    public static void main(String[] args) {
        // We'll store all the Policies here
        ArrayList<Policy> policyList = new ArrayList<>();

        // Variables to track smoker/non-smoker
        int smokerCount = 0;
        int nonSmokerCount = 0;

        try {
            // Open the file
            File file = new File("PolicyInformation.txt");
            Scanner fileReader = new Scanner(file);

            // Each policy is described by 8 lines in the file:
            // 1) Policy Number
            // 2) Provider Name
            // 3) Policyholder’s First Name
            // 4) Policyholder’s Last Name
            // 5) Age
            // 6) Smoking Status (smoker/non-smoker)
            // 7) Height in inches
            // 8) Weight in pounds
            while (fileReader.hasNextLine()) {
                // Read the next 8 lines (accounting for possible blank lines between records)
                String line = fileReader.nextLine().trim();
                if (line.isEmpty()) {
                    continue;  // skip any blank lines
                }

                int policyNumber = Integer.parseInt(line);
                String providerName = fileReader.nextLine().trim();
                String firstName = fileReader.nextLine().trim();
                String lastName = fileReader.nextLine().trim();
                int age = Integer.parseInt(fileReader.nextLine().trim());
                String smokingStatus = fileReader.nextLine().trim();
                double height = Double.parseDouble(fileReader.nextLine().trim());
                double weight = Double.parseDouble(fileReader.nextLine().trim());

                // Create a PolicyHolder
                PolicyHolder holder = new PolicyHolder(
                        firstName,
                        lastName,
                        age,
                        smokingStatus,
                        height,
                        weight
                );

                // Create a Policy
                Policy policy = new Policy(policyNumber, providerName, holder);

                // Add Policy to our list
                policyList.add(policy);
            }
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: PolicyInformation.txt file not found.");
            return;  // Exit program if file not found
        } catch (NumberFormatException e) {
            System.out.println("Error: Unable to parse a numeric value. Check file formatting.");
            return;  // Exit program if format is incorrect
        }

        // Print out each Policy's details
        for (Policy p : policyList) {
            // You can either call `System.out.println(p);` if you have a toString() method,
            // or manually print. Below demonstrates `System.out.println(p)`:
            System.out.println(p);
        }

        // Count smokers and non-smokers
        for (Policy p : policyList) {
            if (p.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Display final stats
        // Policy.getPolicyCount() returns how many Policy objects have been created so far.
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
