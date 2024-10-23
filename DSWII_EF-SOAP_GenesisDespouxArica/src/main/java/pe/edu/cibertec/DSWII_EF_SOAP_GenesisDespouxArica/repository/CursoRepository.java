package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}