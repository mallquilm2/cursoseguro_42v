package edu.cibertec.cursoseguro.security;

import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.UsuarioEntity;
import edu.cibertec.cursoseguro.edu.cibertec.cursoseguro.dao.entity.edu.cibertec.cursoseguro.dao.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UsuarioRepository urepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity ue = urepo.findById(username).get();
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        UserDetails udet = new User(ue.getUsuario(), ue.getClave(), roles);
        return udet;
    }
}
