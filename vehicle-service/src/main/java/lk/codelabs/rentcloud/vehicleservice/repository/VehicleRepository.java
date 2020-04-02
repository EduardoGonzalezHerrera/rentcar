package lk.codelabs.rentcloud.vehicleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lk.codelabs.rentcloud.model.entity.vehicle.Vehicle;

/**
 * @author Krishantha Dinesh
 * krishantha@krishantha.com
 * www.krishantha.com
 * twitter @krishantha
 * on 15-October-2019 06:08
 * @Project rentcloudmodel
 */
public interface VehicleRepository extends JpaRepository<Vehicle,Integer> {
}
