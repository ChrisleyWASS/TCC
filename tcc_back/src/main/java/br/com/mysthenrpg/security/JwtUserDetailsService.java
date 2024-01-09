package br.com.mysthenrpg.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.repositories.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Usuario usuario = usuarioRepository.findByLogin(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        
		if ((usuario != null) && (usuario.getId() != 0))
			return new User(String.valueOf(usuario.getId()), encoder.encode(usuario.getSenha()), authorities);
		else
			throw new UsernameNotFoundException("Usuário não encontrado com o login: " + username);
        
	}
	
public UserDetails loadUserById(String id) throws UsernameNotFoundException {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Usuario usuario = usuarioRepository.findById(id);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        
		if ((usuario != null) && (usuario.getId() != 0))
			return new User(String.valueOf(usuario.getId()), encoder.encode(usuario.getSenha()), authorities);
		else
			throw new UsernameNotFoundException("Usuário não encontrado com o id: " + id);
        
	}
}
