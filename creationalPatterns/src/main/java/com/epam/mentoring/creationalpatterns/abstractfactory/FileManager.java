package com.epam.mentoring.creationalpatterns.abstractfactory;

public abstract class FileManager {

    abstract TextFileHandler getFileHandler();
    abstract TextDBHandler getDBHandler();
}
