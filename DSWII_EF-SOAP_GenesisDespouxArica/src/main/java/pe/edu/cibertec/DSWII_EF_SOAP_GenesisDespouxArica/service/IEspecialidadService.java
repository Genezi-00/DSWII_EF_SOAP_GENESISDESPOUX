package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service;

import pe.edu.cibertec.ws.object.*;

public interface IEspecialidadService {
    PostEspecialidadResponse registrarEspecialidad(PostEspecialidadRequest request);
    PutEspecialidadResponse actualizarEspecilidad(PutEspecialidadRequest request);
    GetEspecialidadesResponse buscarEspecialidades();
    GetEspecialidadResponse buscarEspecialidadXId(Integer id);
}