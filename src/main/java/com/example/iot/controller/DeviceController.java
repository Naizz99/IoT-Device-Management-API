package com.example.iot.controller;

import com.example.iot.model.IoTDevice;
import com.example.iot.repository.DeviceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing IoT devices.
 * Provides endpoints to create, read, update, and delete devices.
 */
@RestController
@RequestMapping("/devices")
public class DeviceController {

    private final DeviceRepository deviceRepo;

    //Constructor for dependency injection of the device repository.
    public DeviceController(DeviceRepository deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    /**
     * Get all IoT devices.
     * 
     * @return list of all devices
     */
    @GetMapping
    public List<IoTDevice> getAllDevices() {
        return deviceRepo.findAll();
    }

    /**
     * Get a specific IoT device by ID.
     *
     * @param id: the ID of the device
     * @return the device if found, or 404 Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<IoTDevice> getDeviceById(@PathVariable String id) {
        return deviceRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Create a new IoT device.
     *
     * @param device: the device data to save
     * @return the saved device
     */
    @PostMapping
    public ResponseEntity<IoTDevice> createDevice(@RequestBody IoTDevice device) {
        return ResponseEntity.ok(deviceRepo.save(device));
    }

    /**
     * Update an existing IoT device by ID.
     *
     * @param id: the ID of the device to update
     * @param device: the updated device data
     * @return the updated device or 404 Not Found if the device doesn't exist
     */
    @PutMapping("/{id}")
    public ResponseEntity<IoTDevice> updateDevice(@PathVariable String id, @RequestBody IoTDevice device) {
        if (deviceRepo.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        device.setId(id); // ensure the ID is set before updating
        return ResponseEntity.ok(deviceRepo.update(id, device));
    }

    /**
     * Delete an IoT device by ID.
     *
     * @param id: the ID of the device to delete
     * @return 204 No Content if deleted, or 404 Not Found if the device doesn't exist
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable String id) {
        IoTDevice deleted = deviceRepo.delete(id);
        return deleted != null ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
