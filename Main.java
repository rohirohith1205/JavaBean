import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// JavaBean Class for Customer
class Customer {
    private int id;
    private double balance;
    private String firstName;
    private String lastName;

    // Constructor
    public Customer(int id, double balance, String firstName, String lastName) {
        this.id = id;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

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

    @Override
    public String toString() {
        return "Customer [ID=" + id + ", Balance=" + balance + ", First Name=" + firstName + ", Last Name=" + lastName + "]";
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Create a list of customers
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(101, 5000.0, "Alice", "Brown"));
        customers.add(new Customer(102, 3000.0, "John", "Doe"));
        customers.add(new Customer(103, 7000.0, "Alice", "Smith"));
        customers.add(new Customer(104, 2000.0, "Alice", "Brown"));
        customers.add(new Customer(105, 1000.0, "John", "Brown"));

        // Sort the customers based on the criteria
        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                int firstNameComparison = c1.getFirstName().compareTo(c2.getFirstName());
                if (firstNameComparison != 0) return firstNameComparison;

                int lastNameComparison = c1.getLastName().compareTo(c2.getLastName());
                if (lastNameComparison != 0) return lastNameComparison;

                int idComparison = Integer.compare(c1.getId(), c2.getId());
                if (idComparison != 0) return idComparison;

                return Double.compare(c1.getBalance(), c2.getBalance());
            }
        });

        // Print sorted list
        System.out.println("Sorted Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
