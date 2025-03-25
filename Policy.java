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
    private double policyHolderHeight;        // in inches
    private double policyHolderWeight;        // in pounds

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
     * Constructor that initializes the Policy object with the specified values.
     *
     * @param policyNumber              the policy number
     * @param providerName              the name of the provider
     * @param policyHolderFirstName     the policyholder's first name
     * @param policyHolderLastName      the policyholder's last name
     * @param policyHolderAge           the policyholder's age
     * @param policyHolderSmokingStatus the policyholder's smoking status ("smoker" or "non-smoker")
     * @param policyHolderHeight        the policyholder's height in inches
     * @param policyHolderWeight        the policyholder's weight in pounds
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

    /**
     * Retrieves the policy number.
     *
     * @return the current policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     *
     * @param policyNumber the new policy number
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Retrieves the name of the provider.
     *
     * @return the current provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the name of the provider.
     *
     * @param providerName the new provider name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Retrieves the policyholder's first name.
     *
     * @return the policyholder's first name
     */
    public String getPolicyHolderFirstName() {
        return policyHolderFirstName;
    }

    /**
     * Sets the policyholder's first name.
     *
     * @param policyHolderFirstName the new first name for the policyholder
     */
    public void setPolicyHolderFirstName(String policyHolderFirstName) {
        this.policyHolderFirstName = policyHolderFirstName;
    }

    /**
     * Retrieves the policyholder's last name.
     *
     * @return the policyholder's last name
     */
    public String getPolicyHolderLastName() {
        return policyHolderLastName;
    }

    /**
     * Sets the policyholder's last name.
     *
     * @param policyHolderLastName the new last name for the policyholder
     */
    public void setPolicyHolderLastName(String policyHolderLastName) {
        this.policyHolderLastName = policyHolderLastName;
    }

    /**
     * Retrieves the policyholder's age.
     *
     * @return the policyholder's age
     */
    public int getPolicyHolderAge() {
        return policyHolderAge;
    }

    /**
     * Sets the policyholder's age.
     *
     * @param policyHolderAge the new age of the policyholder
     */
    public void setPolicyHolderAge(int policyHolderAge) {
        this.policyHolderAge = policyHolderAge;
    }

    /**
     * Retrieves the policyholder's smoking status.
     *
     * @return the policyholder's smoking status ("smoker" or "non-smoker")
     */
    public String getPolicyHolderSmokingStatus() {
        return policyHolderSmokingStatus;
    }

    /**
     * Sets the policyholder's smoking status.
     *
     * @param policyHolderSmokingStatus the new smoking status ("smoker" or "non-smoker")
     */
    public void setPolicyHolderSmokingStatus(String policyHolderSmokingStatus) {
        this.policyHolderSmokingStatus = policyHolderSmokingStatus;
    }

    /**
     * Retrieves the policyholder's height in inches.
     *
     * @return the policyholder's height
     */
    public double getPolicyHolderHeight() {
        return policyHolderHeight;
    }

    /**
     * Sets the policyholder's height.
     *
     * @param policyHolderHeight the new height (in inches) of the policyholder
     */
    public void setPolicyHolderHeight(double policyHolderHeight) {
        this.policyHolderHeight = policyHolderHeight;
    }

    /**
     * Retrieves the policyholder's weight in pounds.
     *
     * @return the policyholder's weight
     */
    public double getPolicyHolderWeight() {
        return policyHolderWeight;
    }

    /**
     * Sets the policyholder's weight.
     *
     * @param policyHolderWeight the new weight (in pounds) of the policyholder
     */
    public void setPolicyHolderWeight(double policyHolderWeight) {
        this.policyHolderWeight = policyHolderWeight;
    }

    /**
     * Calculates and returns the Body Mass Index (BMI) of the policyholder.
     * <p>
     * Formula: BMI = (Weight in pounds * 703) / (Height in inches)^2.
     * 
     * @return the BMI as a double
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
     * Calculates and returns the price of the insurance policy based on:
     * <ul>
     *   <li>Base fee: $600.00</li>
     *   <li>Additional fee of $75.00 if the policyholder is over 50 years old</li>
     *   <li>Additional fee of $100.00 if the policyholder is a smoker</li>
     *   <li>Additional fee for BMI over 35: (BMI - 35) * $20.00</li>
     * </ul>
     *
     * @return the total insurance price as a double
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
        double bmi = calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            totalPrice += (bmi - BMI_THRESHOLD) * BMI_SURCHARGE_RATE;
        }

        return totalPrice;
    }
}
