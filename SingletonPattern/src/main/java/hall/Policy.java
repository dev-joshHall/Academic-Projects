package hall;

public class Policy {
    private volatile static Policy uniqueInstance;

    private String policyID = "No ID";
    private String policyHolderName = "No Holder";

    private Policy() {}

    public static Policy getInstance() {
        if (uniqueInstance == null) {
            synchronized (Policy.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Policy();
                } else {
                    System.out.println("Policy already instantiated. Cannot create new instance of singleton class.");
                }
            }
        } else {
            System.out.println("Policy already instantiated. Cannot create new instance of singleton class.");
        }
        return uniqueInstance;
    }

    public String getDescription() {
        return String.format("Policy with holder '%s' and ID '%s'", this.policyHolderName, this.policyID);
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public String getPolicyID() {
        return policyID;
    }

    public void setPolicyID(String newID) {
        this.policyID = newID;
    }

    public void setPolicyHolderName(String newName) {
        this.policyHolderName = newName;
    }
}
