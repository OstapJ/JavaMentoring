package com.epam.mentoring.creationalpatterns.factorymethod;

public class DataManager {

    /**
     * Represents the factory method which creates the appropriate
     * {@link DataHandler} depending on what type is requested
     */
    public static DataHandler getDataHandler(StorageType type) {
        switch (type) {
            case TEXTFILE:
                return new FileHandler();
            case DATABASE:
                return new DBHandler();
            default:
                throw new RuntimeException(String.format("DataHandler for %s type is not implemented", type));
        }
    }
}
