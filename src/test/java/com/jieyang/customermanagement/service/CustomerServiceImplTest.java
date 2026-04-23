package com.jieyang.customermanagement.service;

import com.jieyang.customermanagement.dao.CustomerRepository;
import com.jieyang.customermanagement.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    private CustomerRepository customerRepository;
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void findAll_shouldReturnCustomerList() {
        List<Customer> mockCustomers = Arrays.asList(
                new Customer(1, "Alice", "Johnson", "alice@example.com"),
                new Customer(2, "Bob", "Smith", "bob@example.com")
        );

        when(customerRepository.findAllByOrderByLastNameAsc()).thenReturn(mockCustomers);

        List<Customer> result = customerService.findAll();

        assertEquals(2, result.size());
        verify(customerRepository, times(1)).findAllByOrderByLastNameAsc();
    }

    @Test
    void findById_shouldReturnCustomerWhenFound() {
        Customer mockCustomer = new Customer(1, "Alice", "Johnson", "alice@example.com");

        when(customerRepository.findById(1)).thenReturn(Optional.of(mockCustomer));

        Customer result = customerService.findById(1);

        assertNotNull(result);
        assertEquals("Alice", result.getFirstName());
        verify(customerRepository, times(1)).findById(1);
    }

    @Test
    void findById_shouldThrowExceptionWhenNotFound() {
        when(customerRepository.findById(99)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            customerService.findById(99);
        });

        assertTrue(exception.getMessage().contains("Did not find customer id"));
        verify(customerRepository, times(1)).findById(99);
    }

    @Test
    void save_shouldReturnSavedCustomer() {
        Customer customer = new Customer("Alice", "Johnson", "alice@example.com");
        Customer savedCustomer = new Customer(1, "Alice", "Johnson", "alice@example.com");

        when(customerRepository.save(customer)).thenReturn(savedCustomer);

        Customer result = customerService.save(customer);

        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void deleteById_shouldCallRepositoryDelete() {
        customerService.deleteById(1);

        verify(customerRepository, times(1)).deleteById(1);
    }
}