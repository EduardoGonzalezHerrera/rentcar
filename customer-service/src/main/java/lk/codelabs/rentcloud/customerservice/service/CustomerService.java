package lk.codelabs.rentcloud.customerservice.service;

import java.util.List;

import lk.codelabs.rentcloud.model.dto.customer.CustomerDTO;
import lk.codelabs.rentcloud.model.entity.customer.Customer;



/**
 * @author Krishantha Dinesh
 * krishantha@krishantha.com
 * www.krishantha.com
 * twitter @krishantha
 * on 15-October-2019 04:28
 * @Project rentcloudmodel
 */
public interface CustomerService {
    Customer save(CustomerDTO customer);

    Customer findById(int id);

    List<Customer> findByName(String firstName,String lastName);
    
    List<Customer> findAll();
    
    Customer update(CustomerDTO customer);
    
    void delete(int id);
    
    
}
