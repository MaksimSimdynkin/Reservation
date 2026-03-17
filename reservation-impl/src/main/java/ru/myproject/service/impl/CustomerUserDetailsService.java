package ru.myproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.myproject.exeption.TransactionNotFoundExeption;
import ru.myproject.repository.RepositoryAppUsers;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final RepositoryAppUsers repositoryAppUsers;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return repositoryAppUsers.findByEmail(userName).orElseThrow(() -> new TransactionNotFoundExeption("Такого пользователя нет"));
    }
}
