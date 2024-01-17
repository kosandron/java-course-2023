package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public final class FileCloner {
    public final static String COPY_ENDING = " — копия";

    private FileCloner() {
    }

    public static void cloneFile(Path path) {
        String fileName = path.getFileName().toString();
        int extensionIndex = fileName.lastIndexOf('.');
        if (extensionIndex == -1) {
            extensionIndex = fileName.length();
        }
        String fileNameWithoutExtension = fileName.substring(0, extensionIndex);
        String extension = fileName.substring(extensionIndex);
        int copyNumber = getCopyNumber(path, fileNameWithoutExtension, extension);

        try {
            Files.copy(
                path,
                path.getParent().resolve(getCopyName(fileNameWithoutExtension, extension, copyNumber)),
                StandardCopyOption.REPLACE_EXISTING
            );
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static String getCopyName(String fileName, String extension, int copyNumber) {
        if (copyNumber == 0) {
            return fileName + COPY_ENDING + extension;
        }

        return fileName + COPY_ENDING + " (" + copyNumber + ')' + extension;
    }

    private static int getCopyNumber(Path path, String fileNameWithoutExtension, String extension) {
        int index = 0;
        while (Files.exists(path.getParent().resolve(getCopyName(fileNameWithoutExtension, extension, index)))) {
            index++;
        }

        return index;
    }
}
