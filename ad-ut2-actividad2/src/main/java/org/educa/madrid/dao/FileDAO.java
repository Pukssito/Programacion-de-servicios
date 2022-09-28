package org.educa.madrid.dao;

import java.io.File;

public interface FileDAO {

    public File[] listFiles(String directory);

    void rename(File file, String name);
}
