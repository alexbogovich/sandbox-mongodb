package io.github.alexbogovich.sandboxmongodb.repository;

import io.github.alexbogovich.sandboxmongodb.model.ReactComponent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReactComponentRepository extends MongoRepository<ReactComponent, String> {
    Optional<ReactComponent> findByName(String name);
}
