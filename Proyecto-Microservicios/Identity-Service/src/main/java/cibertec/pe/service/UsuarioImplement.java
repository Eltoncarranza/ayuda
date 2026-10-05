package cibertec.pe.service;

import cibertec.pe.model.Usuario;
import cibertec.pe.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String createUsuario(Usuario usuario) {
        String encryptedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encryptedPassword);

        userRepo.save(usuario);
        return "Usuario Creado";
    }
}
