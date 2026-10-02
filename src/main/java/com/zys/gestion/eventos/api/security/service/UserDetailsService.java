package com.zys.gestion.eventos.api.security.service;

import com.zys.gestion.eventos.api.domain.Role;
import com.zys.gestion.eventos.api.domain.User;
import com.zys.gestion.eventos.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements  org.springframework.security.core.userdetails.UserDetailsService{

    private  final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Usuario no encontra con nombre "+ username));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),mapRolesToAuthoriies(user.getRoles())
        );
    }


    private Collection<? extends GrantedAuthority> mapRolesToAuthoriies(Set<Role> roles){

        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
