package org.educa.madrid.app;

import org.educa.madrid.exception.FileWithoutExtensionException;
import org.educa.madrid.service.FileService;

public class Actividad2 {

    private static final String PATH = "C:\\temp\\ad\\ut2\\actividad1";

    public static void main(String[] args) throws FileWithoutExtensionException {
        FileService myServiceFile = new FileService();
        myServiceFile.renameFilesWithPermissions(PATH);

    }

}
