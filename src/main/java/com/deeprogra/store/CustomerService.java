package com.deeprogra.store;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AiService aiService;

    public CustomerService(CustomerRepository customerRepository, AiService aiService) {
        this.customerRepository = customerRepository;
        this.aiService = aiService;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        String prompt = """
                Based on the programming tech stack %s that %s has given
                Provide a full learning path and recommendations for this person.
                """.formatted(
                customer.getTechStack(),
                customer.getName());
        String chatRes = aiService.chat(prompt);
        customer.setLearningPathRecommendation(chatRes);
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        id + " not found"));
    }

    public void deleteCustomer(Integer id) {
        boolean exists = customerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    id + " not found");
        }
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Integer id, Customer update) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
        customer.setName(update.getName());
        customer.setTechStack(update.getTechStack());
        customerRepository.save(customer);
    }

}
