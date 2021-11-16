package com.citysight.repository;


import com.citysight.dto.LocationDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.citysight.entities.Location;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    @Modifying
    @Transactional
    @Query("update Location a set a.name=?1, a.address=?2, a.description=?3, a.directions=?4, a.latitude=?5, a.longitude=?6 where a.locationId=?7")
    void updatedLocation(String name, String address, String description, String direction, String latitude, String longitude, int id);

}
