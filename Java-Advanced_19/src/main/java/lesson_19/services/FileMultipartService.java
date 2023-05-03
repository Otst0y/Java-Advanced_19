package lesson_19.services;

import lesson_19.domain.FileMultipart;

import java.io.FileNotFoundException;

public interface FileMultipartService {

    FileMultipart save(FileMultipart file);
    FileMultipart getFile(String fileId) throws FileNotFoundException;
}
