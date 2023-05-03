package lesson_19.repository;

import lesson_19.domain.FileMultipart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileMultipartRepository extends JpaRepository<FileMultipart, String> {
}
