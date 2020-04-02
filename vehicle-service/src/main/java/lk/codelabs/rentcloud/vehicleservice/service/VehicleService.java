package lk.codelabs.rentcloud.vehicleservice.service;

import java.util.List;

import lk.codelabs.rentcloud.model.entity.vehicle.Vehicle;

/**
 * @author Krishantha Dinesh
 * krishantha@krishantha.com
 * www.krishantha.com
 * twitter @krishantha
 * on 15-October-2019 06:10
 * @Project rentcloudmodel
 */
public interface VehicleService {
    Vehicle save(Vehicle customer);

    Vehicle findById(int id);

    List<Vehicle> findAll();
}
