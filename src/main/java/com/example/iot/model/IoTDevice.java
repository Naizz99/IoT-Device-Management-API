package com.example.iot.model;

import java.time.LocalDateTime;
import lombok.*;

/**
 * Represents an IoT device with its basic details and status.
 * Utilizes Lombok to reduce boilerplate code for getters, setters, constructors, etc.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IoTDevice {

    private String id;

    private String name;

    private String type;

    private boolean active;

    private LocalDateTime lastCommunication;
}
