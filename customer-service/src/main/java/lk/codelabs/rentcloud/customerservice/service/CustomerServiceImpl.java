package lk.codelabs.rentcloud.customerservice.service;

import lk.codelabs.rentcloud.customerservice.repository.CustomerRepository;
import lk.codelabs.rentcloud.model.entity.customer.Customer;
import lk.codelabs.rentcloud.model.dto.customer.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Krishantha Dinesh
 * krishantha@krishantha.com
 * www.krishantha.com
 * twitter @krishantha
 * on 15-October-2019 04:15
 * @Project rentcloudmodel
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(CustomerDTO customer) {
    	Customer entity=new Customer(customer.getFirstName(),
    			                     customer.getLastName(),
    			                     customer.getDlNumber(),
    			                     customer.getZipcode(),
    			                     customer.getLoyalities());
    	return customerRepository.save(entity);
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent())
            return customer.get();
        else
            return null;

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


	@Override
	public void delete(int id) {
		customerRepository.deleteById(id);
	}

	@Override
	public Customer update(CustomerDTO customer) {
		Optional<Customer> entity=customerRepository.findById(customer.getId());
		if(entity.isPresent() ) {
			entity.get().setFirstName(customer.getFirstName());
			entity.get().setLastName(customer.getLastName() );
			entity.get().setZipcode(customer.getZipcode() );
			entity.get().setDlNumber(customer.getDlNumber() );
			entity.get().setLoyalities(customer.getLoyalities() );
			return customerRepository.save(entity.get());
		}
		return null;
	}

	@Override
	public List<Customer> findByName(String firstName, String lastName) {
		Optional<List<Customer>>customer=customerRepository.findUserByName(firstName, lastName);
		if(customer.isPresent()){
			return customer.get();
		}
		return null;
	}
}
