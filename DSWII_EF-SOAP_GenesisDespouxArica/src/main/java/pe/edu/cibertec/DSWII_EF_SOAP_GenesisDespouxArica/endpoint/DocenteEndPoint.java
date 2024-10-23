package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service.IDocenteService;
import pe.edu.cibertec.ws.object.*;

@Endpoint
public class DocenteEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/object";

    @Autowired
    private IDocenteService docenteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDocentesRequest")
    @ResponsePayload
    public GetDocentesResponse getDocentes(@RequestPayload GetDocentesRequest request) {
        return docenteService.buscarDocentes();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDocenteRequest")
    @ResponsePayload
    public GetDocenteResponse getDocente(@RequestPayload GetDocenteRequest request) {
        return docenteService.buscarDocenteXId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putDocenteRequest")
    @ResponsePayload
    public PutDocenteResponse actualizarDocente(@RequestPayload PutDocenteRequest request) {
        return docenteService.actualizarDocente(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postDocenteRequest")
    @ResponsePayload
    public PostDocenteResponse saveDocente(@RequestPayload PostDocenteRequest request) {
        return docenteService.registrarDocente(request);
    }
}