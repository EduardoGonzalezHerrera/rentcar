package lk.codelabs.rentcloud.customerservice.controller;


import lk.codelabs.rentcloud.customerservice.service.CustomerService;
import lk.codelabs.rentcloud.model.dto.customer.CustomerDTO;
import lk.codelabs.rentcloud.model.entity.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author Krishantha Dinesh
 * krishantha@krishantha.com
 * www.krishantha.com
 * twitter @krishantha
 * on 15-October-2019 04:09
 * @Project rentcloudmodel
 */

@RestController
@RequestMapping("/services/customers")
public class CustomerServiceController {


    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO) {
    	Customer customer=customerService.save(customerDTO);
    	return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
    }
    

    @GetMapping(value = "/{id}",
    		    produces={MediaType.APPLICATION_XML_VALUE,
    		    		  MediaType.APPLICATION_JSON_VALUE 
    					 } 
    			)
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
    	Customer customer=customerService.findById(id);        
    	if(customer == null)
    		return new ResponseEntity<Customer>(customer,HttpStatus.NOT_FOUND );
    	return new ResponseEntity<Customer>(customer,HttpStatus.OK );
    }
    

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
    	List<Customer> list=customerService.findAll();
    	return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
    }
    
    @GetMapping(value="/searchByName")
    public ResponseEntity<List<Customer>> searchByLastName(@RequestParam String firstName,
    													   @RequestParam String lastName){
    	List<Customer> list=customerService.findByName(firstName, lastName);
    	if(list == null)
    		return new ResponseEntity<List<Customer>>(list,HttpStatus.NOT_FOUND );
    	return new ResponseEntity<List<Customer>>(list,HttpStatus.OK ); 
    }
    
    
    
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO ){
    	Customer customer=customerService.update(customerDTO);
    	if(customer == null)
    		return new ResponseEntity<Customer>(customer,HttpStatus.NOT_FOUND );
    	return new ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id){
    	customerService.delete(id);
    	return ResponseEntity.noContent().build();
    }



}
