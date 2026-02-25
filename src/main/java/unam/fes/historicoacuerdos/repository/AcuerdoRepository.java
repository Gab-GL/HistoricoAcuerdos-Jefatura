package unam.fes.historicoacuerdos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unam.fes.historicoacuerdos.model.Acuerdo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unam.fes.historicoacuerdos.model.Acuerdo;

import java.time.LocalDate;
import java.util.List;

public interface AcuerdoRepository extends JpaRepository<Acuerdo, Integer> {

    @Query("""
        SELECT a FROM Acuerdo a
        WHERE (:persona IS NULL OR a.persona LIKE %:persona%)
        AND   (:area IS NULL OR a.area LIKE %:area%)
        AND   (:asunto IS NULL OR a.asunto LIKE %:asunto%)
        AND   (:fecha IS NULL OR a.fecha = :fecha)
    """)
    List<Acuerdo> buscar(
            @Param("persona") String persona,
            @Param("area") String area,
            @Param("asunto") String asunto,
            @Param("fecha") LocalDate fecha
    );
}

