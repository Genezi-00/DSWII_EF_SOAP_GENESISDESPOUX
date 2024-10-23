package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.exception.NotFoundException;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.model.Curso;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.repository.CursoRepository;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.service.ICursoService;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.util.convert.CursoConvert;
import pe.edu.cibertec.ws.object.*;

@RequiredArgsConstructor
@Service
public class CursoService implements ICursoService {
    private final CursoRepository cursoRepository;
    private final CursoConvert cursoConvert;

    @Override
    public PostCursoResponse registrarCurso(PostCursoRequest request) {
        PostCursoResponse postCursoResponse = new PostCursoResponse();
        Curso nuevoCurso = cursoRepository.save(
                cursoConvert.mapearACurso(request.getCurso())
        );
        postCursoResponse.setCurso(
                cursoConvert.mapearACursows(nuevoCurso)
        );
        return postCursoResponse;
    }

    @Override
    public PutCursoResponse actualizarCurso(PutCursoRequest request) {
        PutCursoResponse putCursoResponse = new PutCursoResponse();
        Curso curso = cursoRepository.findById(request.getCurso().getId()).orElse(null);
        if (curso == null) {
            throw new NotFoundException("Curso con el ID " + request.getCurso().getId() + " no encontrado");
        } else {
            putCursoResponse.setCurso(
                    cursoConvert.mapearACursows(cursoRepository.save(
                            cursoConvert.mapearACurso(request.getCurso())
                    ))
            );
        }
        return putCursoResponse;
    }

    @Override
    public GetCursosResponse buscarCursos() {
        GetCursosResponse getCursosResponse = new GetCursosResponse();
        getCursosResponse.getCursos().addAll(
                cursoConvert.mapearACursowsList(cursoRepository.findAll())
        );
        return getCursosResponse;
    }

    @Override
    public GetCursoResponse buscarCursoXId(Integer id) {
        GetCursoResponse getCursoResponse = new GetCursoResponse();
        Curso curso = cursoRepository.findById(id).orElse(null);
        if (curso == null) {
            throw new NotFoundException("Curso con el ID " + id + " no encontrado");
        } else {
            getCursoResponse.setCurso(
                    cursoConvert.mapearACursows(curso)
            );
        }
        return getCursoResponse;
    }
}