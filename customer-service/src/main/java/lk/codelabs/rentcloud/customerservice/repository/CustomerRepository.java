package lk.codelabs.rentcloud.customerservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lk.codelabs.rentcloud.model.entity.customer.Customer;

/**
 * @author Krishantha Dinesh
 * krishantha@krishantha.com
 * www.krishantha.com
 * twitter @krishantha
 * on 15-October-2019 04:17
 * @Project rentcloudmodel
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	@Query(value="select * from Customer c "
			   + "where c.lastName = :lastName and c.firstName=:firstName",nativeQuery=true)
	Optional<List<Customer>> findUserByName(@Param("firstName")String firstName,@Param("lastName")String lastName);
	
}
