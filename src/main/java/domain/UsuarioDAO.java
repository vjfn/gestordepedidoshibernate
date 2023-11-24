package domain;

import clase.Usuario;

/**
 * La interfaz UsuarioDAO contiene los métodos para acceder a los datos de los elementos (Usuario).
 */
public interface UsuarioDAO {
    public Usuario loadUser(String mail, String password);
    public Usuario createUser(String mail, String password);
}
