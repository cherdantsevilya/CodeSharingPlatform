package platform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.entity.Code;

import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<Code, String> {
    List<Code> findAll();
}
