package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.exception.NotFoundException;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.model.Docente;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.repository.DocenteRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service.IDocenteService;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.util.convert.DocenteConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class DocenteService implements IDocenteService {
    private final DocenteRepository docenteRepository;
    private final DocenteConvert docenteConvert;

    @Override
    public PostDocenteResponse registrarDocente(PostDocenteRequest request) {
        PostDocenteResponse postDocenteResponse = new PostDocenteResponse();
        Docente nuevoDocente = docenteRepository.save(
                docenteConvert.mapearADocente(request.getDocente())
        );
        postDocenteResponse.setDocente(
                docenteConvert.mapearADocentews(nuevoDocente)
        );
        return postDocenteResponse;
    }

    @Override
    public PutDocenteResponse actualizarDocente(PutDocenteRequest request) {
        PutDocenteResponse putDocenteResponse = new PutDocenteResponse();
        Docente docente = docenteRepository.findById(request.getDocente().getId()).orElse(null);
        if (docente == null) {
            throw new NotFoundException("Docente con el ID " + request.getDocente().getId() + " no encontrado");
        } else {
            putDocenteResponse.setDocente(
                    docenteConvert.mapearADocentews(docenteRepository.save(
                            docenteConvert.mapearADocente(request.getDocente())
                    ))
            );
        }
        return putDocenteResponse;
    }

    @Override
    public GetDocentesResponse buscarDocentes() {
        GetDocentesResponse getDocentesResponse = new GetDocentesResponse();
        getDocentesResponse.getDocentes().addAll(
                docenteConvert.mapearADocentewsList(docenteRepository.findAll())
        );
        return getDocentesResponse;
    }

    @Override
    public GetDocenteResponse buscarDocenteXId(Integer id) {
        GetDocenteResponse getDocenteResponse = new GetDocenteResponse();
        Docente docente = docenteRepository.findById(id).orElse(null);
        if (docente == null) {
            throw new NotFoundException("Docente con el ID " + id + " no encontrado");
        } else {
            getDocenteResponse.setDocente(
                    docenteConvert.mapearADocentews(docente)
            );
        }
        return getDocenteResponse;
    }
}