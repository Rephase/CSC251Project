/**
 * The PolicyHolder class represents a person associated with an insurance policy.
 * It stores personal information such as name, age, smoking status,
 * height, weight, and provides a method to calculate BMI.
 */
public class PolicyHolder {

    // Fields describing the person
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;  // "smoker" or "non-smoker"
    private double height;         // in inches
    private double weight;         // in pounds

    /**
     * No-argument constructor that initializes a PolicyHolder with default values.
     */
    public PolicyHolder() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    /**
     * Full constructor that initializes a PolicyHolder with given values.
     *
     * @param firstName     The policyholder's first name
     * @param lastName      The policyholder's last name
     * @param age           The policyholder's age
     * @param smokingStatus The policyholder's smoking status ("smoker" or "non-smoker")
     * @param height        The policyholder's height in inches
     * @param weight        The policyholder's weight in pounds
     */
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // --------------------
    // Getters and Setters
    // --------------------
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculates and returns the Body Mass Index (BMI) of this PolicyHolder.
     * <p>
     * Formula: BMI = (weight in pounds * 703) / (height in inches)^2
     *
     * @return the BMI as a double
     */
    public double calculateBMI() {
        if (height == 0) {
            return 0;
        }
        return (weight * 703.0) / (height * height);
    }

    /**
     * Returns a string representation of the PolicyHolder's information,
     * including name, age, smoking status, height, weight, and BMI.
     */
    @Override
    public String toString() {
        return String.format(
            "Policyholder's First Name: %s\n" +
            "Policyholder's Last Name: %s\n" +
            "Policyholder's Age: %d\n" +
            "Policyholder's Smoking Status (Y/N): %s\n" +
            "Policyholder's Height: %.1f inches\n" +
            "Policyholder's Weight: %.1f pounds\n" +
            "Policyholder's BMI: %.2f\n",
            firstName,
            lastName,
            age,
            smokingStatus,
            height,
            weight,
            calculateBMI()
        );
    }
}
