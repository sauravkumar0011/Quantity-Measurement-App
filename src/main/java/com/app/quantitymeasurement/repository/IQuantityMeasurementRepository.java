package com.app.quantitymeasurement.repository;

import java.util.List;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    /**
     * Saves a {@link QuantityMeasurementEntity} to the repository.
     *
     * @param entity the quantity measurement entity to be stored
     */
    void save(QuantityMeasurementEntity entity);

    /**
     * Retrieves all stored quantity measurement entities.
     *
     * @return list of all stored {@link QuantityMeasurementEntity} objects
     */
    List<QuantityMeasurementEntity> getAllMeasurements();

    /**
     * Main method used for simple testing of the repository interface.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Testing IQuantityMeasurementRepository interface");
    }
}
