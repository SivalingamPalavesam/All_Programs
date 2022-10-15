package com.location_api.services;

import java.util.List;

import com.location_api.models.Location;

public interface LocationService 
{
	Location createLocation(Location location);

	void modifyLocation(Location location);

	void deleteLocation(String id);

	List<Location> getAll();

	Location getById(String id);

	List<Location> getFilteredLocations(String id, Double radius, Boolean isFilterByAddressId, Double lon, Double lat);
}
