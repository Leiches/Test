package hmf2.hmfboot1.service;

import hmf2.hmfboot1.domain.Location;
import java.util.List;
import java.util.Optional;

public interface LocationService {
    Location createLocation(Location location);
    Optional<Location> getLocationById(Long id);
    List<Location> getAllLocations();
    Location updateLocation(Long id, Location location);
    void deleteLocation(Long id);
}