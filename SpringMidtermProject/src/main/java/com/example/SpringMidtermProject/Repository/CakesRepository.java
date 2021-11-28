package com.example.SpringMidtermProject.Repository;

import com.example.SpringMidtermProject.Entity.Cakes;
import org.springframework.data.repository.CrudRepository;

public interface CakesRepository extends CrudRepository<Cakes, Long> {
    Cakes findById(Integer cakesid);
    Cakes findByIsActive(Boolean isActive);
//    Order findByUserId(Integer userId);
//    Order findDriverIdAndCarId(Integer driverId, Integer carId);
//    void cancelOrder(Integer orderId);
}
