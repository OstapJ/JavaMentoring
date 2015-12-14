package com.epam.mentoring.creationalpatterns.abstractfactory;

public class TextFileManager extends FileManager {

    @Override
    public TextFileHandler getFileHandler() {
        return new TextFileHandler();
    }

    @Override
    public TextDBHandler getDBHandler() {
        return new TextDBHandler();
    }

}
