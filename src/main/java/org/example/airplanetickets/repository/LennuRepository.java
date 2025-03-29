package org.example.airplanetickets.repository;
import org.example.airplanetickets.model.Lennud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LennuRepository extends JpaRepository<Lennud, Long>, JpaSpecificationExecutor<Lennud> {
    List<Lennud> findBySihtkoht(String sihtkoht);
    @Query("SELECT l FROM Lennud l WHERE " +
            "(:kuupaev is null or l.kuupäev = :kuupaev) and " +
            "(:lennuaeg is null or l.lennuaeg = :lennuaeg) and " +
            "(:sihtkoht is null or l.sihtkoht = :sihtkoht)")
    List<Lennud> findFilteredLennud(
            @Param("kuupaev") LocalDate kuupaev,
            @Param("lennuaeg") Time lennuaeg,
            @Param("sihtkoht") String sihtkoht
    );

}
