package unam.fes.historicoacuerdos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import unam.fes.historicoacuerdos.model.Oficio;

import java.time.LocalDate;
import java.util.List;

public interface OficioRepository extends JpaRepository<Oficio, Integer> {
    @Query("""
SELECT o FROM Oficio o
WHERE (:persona IS NULL OR o.persona LIKE %:persona%)
AND   (:area IS NULL OR o.area LIKE %:area%)
AND   (:asunto IS NULL OR o.asunto LIKE %:asunto%)
AND   (:fecha IS NULL OR o.fecha = :fecha)
""")
    List<Oficio> buscar(
            @Param("persona") String persona,
            @Param("area") String area,
            @Param("asunto") String asunto,
            @Param("fecha") LocalDate fecha
    );

}
