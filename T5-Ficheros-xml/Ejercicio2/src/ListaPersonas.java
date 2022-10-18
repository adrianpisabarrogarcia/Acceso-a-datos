import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {

    private List<Persona> lista = new ArrayList<Persona>();

    public ListaPersonas() {
    }

    public List<Persona> getLista() {
        return lista;
    }

    public void add(Persona persona) {
        lista.add(persona);
    }


}
