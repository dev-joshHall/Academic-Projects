package hall;

/**
 * Demonstration of a Singleton Class 'Policy'
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Creating first Policy instance...\n");
        Policy lifeInsurancePolicy = Policy.getInstance();

        System.out.println("Trying to create new instance...");
        Policy homeInsurancePolicy = Policy.getInstance();

        String id = "143";
        String name = "Johnny Newman";
        System.out.printf("\nSetting policy ID to %s...\n%n", id);
        lifeInsurancePolicy.setPolicyID(id);
        System.out.printf("Setting policy holder name to %s...\n%n", name);
        lifeInsurancePolicy.setPolicyHolderName(name);

        System.out.print("Policy ID: ");
        System.out.println(lifeInsurancePolicy.getPolicyID());
        System.out.print("Policy Holder Name: ");
        System.out.println(lifeInsurancePolicy.getPolicyHolderName());
        System.out.println("Policy Description:");
        System.out.println(lifeInsurancePolicy.getDescription());
    }
}
