package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.model.Docente;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
}