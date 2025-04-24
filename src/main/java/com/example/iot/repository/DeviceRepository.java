package com.example.iot.repository;

import org.springframework.stereotype.Repository;
import com.example.iot.model.IoTDevice;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory repository for managing IoT devices.
 * Uses a thread-safe ConcurrentHashMap for storing device data.
 */
@Repository
public class DeviceRepository {

    // Thread-safe map to store devices using their ID as the key
    private final Map<String, IoTDevice> deviceMap = new ConcurrentHashMap<>();

    /**
     * Retrieves all devices currently stored.
     *
     * @return list of all IoT devices
     */
    public List<IoTDevice> findAll() {
        return new ArrayList<>(deviceMap.values());
    }

    /**
     * Finds a device by its ID.
     *
     * @param id: the ID of the device
     * @return Optional containing the device if found, or empty otherwise
     */
    public Optional<IoTDevice> findById(String id) {
        return Optional.ofNullable(deviceMap.get(id));
    }

    /**
     * Saves a new device or updates an existing one.
     *
     * @param device: the device to save
     * @return the saved device
     */
    public IoTDevice save(IoTDevice device) {
        deviceMap.put(device.getId(), device);
        return device;
    }

    /**
     * Updates a device with a new instance.
     *
     * @param id: the ID of the device to update
     * @param device: the updated device
     * @return the previous device instance if present, or null
     */
    public IoTDevice update(String id, IoTDevice device) {
        return deviceMap.replace(id, device);
    }

    /**
     * Deletes a device by ID.
     *
     * @param id: the ID of the device to delete
     * @return the removed device, or null if it didn't exist
     */
    public IoTDevice delete(String id) {
        return deviceMap.remove(id);
    }
}
