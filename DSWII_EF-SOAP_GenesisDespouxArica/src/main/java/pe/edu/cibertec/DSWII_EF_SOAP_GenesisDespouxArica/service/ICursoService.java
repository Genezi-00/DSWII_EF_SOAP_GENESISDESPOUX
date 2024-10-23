package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service;

import pe.edu.cibertec.ws.object.*;

public interface ICursoService {
    PostCursoResponse registrarCurso(PostCursoRequest request);
    PutCursoResponse actualizarCurso(PutCursoRequest request);
    GetCursosResponse buscarCursos();
    GetCursoResponse buscarCursoXId(Integer id);
}