package lesson_19.services.impl;

import lesson_19.domain.FileMultipart;
import lesson_19.repository.FileMultipartRepository;
import lesson_19.services.FileMultipartService;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class FileMultipartServiceImpl implements FileMultipartService {

    private final FileMultipartRepository repository;

    public FileMultipartServiceImpl(FileMultipartRepository repository) {
        this.repository = repository;
    }

    @Override
    public FileMultipart save(FileMultipart file) {
        return repository.save(file);
    }

    @Override
    public FileMultipart getFile(String fileId) throws FileNotFoundException {
        return repository.findById(fileId).orElseThrow(FileNotFoundException::new);
    }


}
