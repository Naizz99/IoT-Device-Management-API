package com.example.iot;

import com.example.iot.model.IoTDevice;
import com.example.iot.repository.DeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for DeviceRepository using JUnit.
 */
public class DeviceRepositoryTest {

    private DeviceRepository repo;

    /**
     * Initialize a fresh repository instance before each test.
     */
    @BeforeEach
    void setUp() {
        repo = new DeviceRepository();
    }

    /**
     * Test saving a device and retrieving it by ID.
     * Verifies both presence and data integrity.
     */
    @Test
    void testSaveAndFindById() {
        IoTDevice device = new IoTDevice("1", "Sensor", "Temperature", true, LocalDateTime.now());
        repo.save(device);
        assertTrue(repo.findById("1").isPresent(), "Device should be found by ID");
        assertEquals("Sensor", repo.findById("1").get().getName(), "Device name should match");
    }

    /**
     * Test deleting a device by ID.
     * Ensures that the device is no longer retrievable.
     */
    @Test
    void testDelete() {
        IoTDevice device = new IoTDevice("2", "Cam", "Security", false, LocalDateTime.now());
        repo.save(device);
        repo.delete("2");
        assertTrue(repo.findById("2").isEmpty(), "Device should not exist after deletion");
    }

    /**
     * Test updating an existing device.
     * Confirms that the updated data is reflected in the repository.
     */
    @Test
    void testUpdate() {
        IoTDevice device = new IoTDevice("3", "Light", "LED", true, LocalDateTime.now());
        repo.save(device);
        device.setName("Light Updated"); // update the device name
        repo.update("3", device);
        assertEquals("Light Updated", repo.findById("3").get().getName(), "Device name should be updated");
    }
}
