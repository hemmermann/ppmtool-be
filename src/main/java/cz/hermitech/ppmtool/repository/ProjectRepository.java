package cz.hermitech.ppmtool.repository;

import cz.hermitech.ppmtool.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    @Override
    List<Project> findAllById(Iterable<String> strings);
}
