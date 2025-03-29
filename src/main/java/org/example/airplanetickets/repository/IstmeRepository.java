package org.example.airplanetickets.repository;
import org.example.airplanetickets.model.Istekohad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IstmeRepository extends JpaRepository<Istekohad, Long> {
    List<Istekohad> findBylennud_id(Integer lennud_id);


}
