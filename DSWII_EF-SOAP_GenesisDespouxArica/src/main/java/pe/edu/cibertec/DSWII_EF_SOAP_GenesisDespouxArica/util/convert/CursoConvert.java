package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.model.Curso;
import pe.edu.cibertec.ws.object.Cursows;

import java.util.ArrayList;
import java.util.List;

@Component
public class CursoConvert {

    public Curso mapearACurso(Cursows cursows) {
        Curso curso = new Curso();
        curso.setId(cursows.getId());
        curso.setNombre(cursows.getNombre());
        curso.setCreditos(cursows.getCreditos());
        return curso;
    }

    public Cursows mapearACursows(Curso curso) {
        Cursows cursows = new Cursows();
        cursows.setId(curso.getId());
        cursows.setNombre(curso.getNombre());
        cursows.setCreditos(curso.getCreditos());
        return cursows;
    }

    public List<Curso> mapearACursoList(List<Cursows> cursowsList) {
        List<Curso> cursoList = new ArrayList<>();
        for (Cursows cursows : cursowsList) {
            cursoList.add(mapearACurso(cursows));
        }
        return cursoList;
    }

    public List<Cursows> mapearACursowsList(List<Curso> cursoList) {
        List<Cursows> cursowsList = new ArrayList<>();
        for (Curso curso : cursoList) {
            cursowsList.add(mapearACursows(curso));
        }
        return cursowsList;
    }
}