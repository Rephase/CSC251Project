/**
 * The Policy class models an insurance policy that holds a policy number, a
 * provider name, and references a PolicyHolder to retrieve personal information.
 * It also calculates the insurance price based on certain criteria.
 */
public class Policy {

    // Constants used in price calculation
    public static final double BASE_FEE = 600.0;
    public static final double AGE_SURCHARGE = 75.0;
    public static final double SMOKER_SURCHARGE = 100.0;
    public static final double BMI_THRESHOLD = 35.0;
    public static final double BMI_SURCHARGE_RATE = 20.0;

    // Fields related to the policy itself
    private int policyNumber;
    private String providerName;

    // A reference to the person who holds this policy
    private PolicyHolder policyHolder;

    /**
     * No-argument constructor that initializes a Policy with default values.
     */
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyHolder = new PolicyHolder(); // Default policyholder
    }

    /**
     * Constructor that initializes a Policy with the specified values.
     *
     * @param policyNumber The policy number
     * @param providerName The provider name
     * @param policyHolder The PolicyHolder object containing personal data
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = policyHolder;
    }

    // --------------------
    // Getters and Setters
    // --------------------
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

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    /**
     * Calculates and returns the price of this insurance policy.
     * <ul>
     *   <li>Base fee: $600.00</li>
     *   <li>Additional $75.00 if the PolicyHolder is over 50 years old</li>
     *   <li>Additional $100.00 if the PolicyHolder is a smoker</li>
     *   <li>Additional fee for BMI over 35: (BMI - 35) * $20.00</li>
     * </ul>
     *
     * @return the total insurance price as a double
     */
    public double calculateInsurancePrice() {
        double totalPrice = BASE_FEE;

        // Check the age
        if (policyHolder.getAge() > 50) {
            totalPrice += AGE_SURCHARGE;
        }

        // Check smoking status
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            totalPrice += SMOKER_SURCHARGE;
        }

        // Check BMI
        double bmi = policyHolder.calculateBMI();
        if (bmi > BMI_THRESHOLD) {
            totalPrice += (bmi - BMI_THRESHOLD) * BMI_SURCHARGE_RATE;
        }

        return totalPrice;
    }
}
