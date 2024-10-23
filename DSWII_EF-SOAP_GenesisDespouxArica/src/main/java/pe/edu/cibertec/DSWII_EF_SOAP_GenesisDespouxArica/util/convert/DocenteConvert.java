package pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.DSWII_EF_SOAP_GenesisDespouxArica.model.Docente;
import pe.edu.cibertec.ws.object.Docentews;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocenteConvert {
    public Docente mapearADocente(Docentews docentews) {
        Docente docente = new Docente();
        docente.setId(docentews.getId());
        docente.setNombres(docentews.getNombres());
        docente.setApellidos(docentews.getApellidos());
        docente.setDni(docentews.getDni());
        docente.setEmail(docentews.getEmail());
        return docente;
    }

    public Docentews mapearADocentews(Docente docente) {
        Docentews docentews = new Docentews();
        docentews.setId(docente.getId());
        docentews.setNombres(docente.getNombres());
        docentews.setApellidos(docente.getApellidos());
        docentews.setDni(docente.getDni());
        docentews.setEmail(docente.getEmail());
        return docentews;
    }

    public List<Docente> mapearADocenteList(List<Docentews> docentewsList) {
        List<Docente> docenteList = new ArrayList<>();
        for (Docentews docentews : docentewsList) {
            docenteList.add(mapearADocente(docentews));
        }
        return docenteList;
    }

    public List<Docentews> mapearADocentewsList(List<Docente> docenteList) {
        List<Docentews> docentewsList = new ArrayList<>();
        for (Docente docente : docenteList) {
            docentewsList.add(mapearADocentews(docente));
        }
        return docentewsList;
    }
}