package hmf2.hmfboot1.service.impl;

import hmf2.hmfboot1.domain.Location;
import hmf2.hmfboot1.repository.LocationRepository;
import hmf2.hmfboot1.service.LocationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location updateLocation(Long id, Location updated) {
        return locationRepository.findById(id)
                .map(loc -> {
                    loc.setName(updated.getName());
                    return locationRepository.save(loc);
                })
                .orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}