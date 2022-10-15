package com.location_api.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.location_api.models.Location;
@Repository
public interface LocationRepository  extends JpaRepository<Location ,String>
{	
	 List<Location> findByLatBetweenAndLngBetween(Double minLat, Double maxLat, Double minLon, Double maxLon);

}
