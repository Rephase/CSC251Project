/**
 * The Policy class models an insurance policy for one person.
 * It includes information such as policy number, provider name, policyholder’s
 * personal details, and methods to calculate BMI and insurance price.
 */
public class Policy {

    // Constants used in price calculation
    public static final double BASE_FEE = 600.0;
    public static final double AGE_SURCHARGE = 75.0;
    public static final double SMOKER_SURCHARGE = 100.0;
    public static final double BMI_THRESHOLD = 35.0;
    public static final double BMI_SURCHARGE_RATE = 20.0;

    // Instance variables for policy attributes
    private int policyNumber;
    private String providerName;
    private String policyHolderFirstName;
    private String policyHolderLastName;
    private int policyHolderAge;
    private String policyHolderSmokingStatus; // "smoker" or "non-smoker"
    private double policyHolderHeight; // in inches
    private double policyHolderWeight; // in pounds

    /**
     * No-argument constructor that initializes the Policy object with default values.
     */
    public Policy() {
        policyNumber = 0;
        providerName = "";
        policyHolderFirstName = "";
        policyHolderLastName = "";
        policyHolderAge = 0;
        policyHolderSmokingStatus = "non-smoker"; // default status
        policyHolderHeight = 0;
        policyHolderWeight = 0;
    }

    /**
     * Constructor that initializes the Policy object with given values.
     *
     * @param policyNumber              The policy number.
     * @param providerName              The name of the provider.
     * @param policyHolderFirstName     The policyholder's first name.
     * @param policyHolderLastName      The policyholder's last name.
     * @param policyHolderAge           The policyholder's age.
     * @param policyHolderSmokingStatus The policyholder's smoking status ("smoker" or "non-smoker").
     * @param policyHolderHeight        The policyholder's height in inches.
     * @param policyHolderWeight        The policyholder's weight in pounds.
     */
    public Policy(int policyNumber, String providerName, String policyHolderFirstName,
                  String policyHolderLastName, int policyHolderAge, String policyHolderSmokingStatus,
                  double policyHolderHeight, double policyHolderWeight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolderFirstName = policyHolderFirstName;
        this.policyHolderLastName = policyHolderLastName;
        this.policyHolderAge = policyHolderAge;
        this.policyHolderSmokingStatus = policyHolderSmokingStatus;
        this.policyHolderHeight = policyHolderHeight;
        this.policyHolderWeight = policyHolderWeight;
    }

    // Accessor (getter) and Mutator (setter) methods for each field

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyHolderFirstName() {
        return policyHolderFirstName;
    }

    public void setPolicyHolderFirstName(String policyHolderFirstName) {
        this.policyHolderFirstName = policyHolderFirstName;
    }

    public String getPolicyHolderLastName() {
        return policyHolderLastName;
    }

    public void setPolicyHolderLastName(String policyHolderLastName) {
        this.policyHolderLastName = policyHolderLastName;
    }

    public int getPolicyHolderAge() {
        return policyHolderAge;
    }

    public void setPolicyHolderAge(int policyHolderAge) {
        this.policyHolderAge = policyHolderAge;
    }

    public String getPolicyHolderSmokingStatus() {
        return policyHolderSmokingStatus;
    }

    public void setPolicyHolderSmokingStatus(String policyHolderSmokingStatus) {
        this.policyHolderSmokingStatus = policyHolderSmokingStatus;
    }

    public double getPolicyHolderHeight() {
        return policyHolderHeight;
    }

    public void setPolicyHolderHeight(double policyHolderHeight) {
        this.policyHolderHeight = policyHolderHeight;
    }

    public double getPolicyHolderWeight() {
        return policyHolderWeight;
    }

    public void setPolicyHolderWeight(double policyHolderWeight) {
        this.policyHolderWeight = policyHolderWeight;
    }

    /**
     * Calculates and returns the Body Mass Index (BMI) of the policyholder.
     * Formula: BMI = (Weight in pounds * 703) / (Height in inches)^2.
     *
     * @return The BMI as a double.
     */
    public double calculateBMI() {
        // Avoid division by zero if height is not set
        if (policyHolderHeight == 0) {
            return 0;
        }
        double bmi = (policyHolderWeight * 703.0) / (policyHolderHeight * policyHolderHeight);
        return bmi;
    }

    /**
     * Calculates and returns the price of the insurance policy.
     * The calculation is based on the following:
     * - Base fee: $600.00
     * - Additional fee of $75.00 if the policyholder is over 50 years old.
     * - Additional fee of $100.00 if the policyholder is a smoker.
     * - Additional fee for BMI over 35: (BMI - 35) * $20.00.
     *
     * @return The total insurance price as a double.
     */
    public double calculateInsurancePrice() {
        double totalPrice = BASE_FEE;

        // Additional fee for age over 50
        if (policyHolderAge > 50) {
            totalPrice += AGE_SURCHARGE;
        }

        // Additional fee for smokers
        if (policyHolderSmokingStatus.equalsIgnoreCase("smoker")) {
            totalPrice += SMOKER_SURCHARGE;
        }

        // Calculate additional fee if BMI exceeds the threshold
        double bmi = calculateBMI(); // Calculate BMI fresh each time
        if (bmi > BMI_THRESHOLD) {
            totalPrice += (bmi - BMI_THRESHOLD) * BMI_SURCHARGE_RATE;
        }

        return totalPrice;
    }
}
