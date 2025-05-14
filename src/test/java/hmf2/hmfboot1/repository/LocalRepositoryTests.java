package hmf2.hmfboot1.repository;

import hmf2.hmfboot1.domain.Location;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LocationRepositoryTests {

    @Autowired
    private LocationRepository locationRepository;

    @Test
    void testCreateAndFindLocation() {
        Location location = new Location("Stadium 1");
        location = locationRepository.save(location);
        assertNotNull(location.getId());

        Optional<Location> found = locationRepository.findById(location.getId());
        assertTrue(found.isPresent());
        assertEquals("Stadium 1", found.get().getName());
    }
}