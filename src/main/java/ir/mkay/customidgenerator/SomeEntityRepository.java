package ir.mkay.customidgenerator;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SomeEntityRepository extends JpaRepository<SomeEntity, Integer> {
}
