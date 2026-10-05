package cibertec.pe.controller;

import cibertec.pe.model.Usuario;
import cibertec.pe.model.UsuarioRequest;
import cibertec.pe.service.IUsuarioService;
import cibertec.pe.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlller {
    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/crearUsuario")
    public String crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody UsuarioRequest usuarioRequest) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usuarioRequest.getEmail(), usuarioRequest.getPassword())
            );
            if (authenticate.isAuthenticated()) {
                return ResponseEntity.ok(jwtService.generateToken(usuarioRequest.getEmail()));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o Contraseña NO coinciden");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o Contraseña NO coinciden");
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
        try {
            jwtService.validateToken(token);
            return ResponseEntity.ok("Token válido");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        }
    }
}
