package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service.ICursoService;
import pe.edu.cibertec.ws.object.GetCursoRequest;
import pe.edu.cibertec.ws.object.GetCursoResponse;
import pe.edu.cibertec.ws.object.GetCursosRequest;
import pe.edu.cibertec.ws.object.GetCursosResponse;


@Endpoint
public class CursoEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private ICursoService cursoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCursosRequest")
    @ResponsePayload
    public GetCursosResponse getCursos(@RequestPayload GetCursosRequest request) {
        return cursoService.buscarCursos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCursoRequest")
    @ResponsePayload
    public GetCursoResponse getCurso(@RequestPayload GetCursoRequest request) {
        return cursoService.buscarCursoXId(request.getId());
    }
}