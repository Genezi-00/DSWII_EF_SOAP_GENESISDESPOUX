package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service;

import pe.edu.cibertec.ws.object.*;

public interface IDocenteService {
    PostDocenteResponse registrarDocente(PostDocenteRequest request);
    PutDocenteResponse actualizarDocente(PutDocenteRequest request);
    GetDocentesResponse buscarDocentes();
    GetDocenteResponse buscarDocenteXId(Integer id);
}