package ra.jsp.service;

import ra.jsp.model.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomerService {
    private static  final List<Customer> customers = new ArrayList<>();
    static {
        customers.add(new Customer(1, "Nguyễn Văn A", "HCM City", "0947853446","A@gmail.com", "error.jpg"));
        customers.add(new Customer(2, "Nguyễn Văn B", "HCM City", "0947853446","A@gmail.com", "error.jpg"));
        customers.add(new Customer(3, "Nguyễn Văn C", "HCM City", "0947853446","A@gmail.com", "error.jpg"));
    }

    public List<Customer> findAll(){
        return customers;
    }

    public Customer findById(Integer id){
        return customers.stream().filter(c->c.getId() == id).findFirst().orElse(null);
    }

    public void save(Customer  customer){
        if (customer.getId() == 0){
            // tạo mơi
            int newId = customers.stream().map(Customer::getId).max(Comparator.naturalOrder()).orElse(0)+1;
            customer.setId(newId);
            customers.add(customer);
        }{
            customers.set(customers.indexOf(findById(customer.getId())),customer);
        }
    }
    public void deleteById(Integer id){
        customers.remove(findById(id));
    }
}
