package ru.vlapin.experiments.demo9.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.demo9.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
