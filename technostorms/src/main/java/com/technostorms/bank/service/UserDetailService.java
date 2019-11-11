/*
 * package com.technostorms.bank.service;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.technostorms.bank.repository.UserRepository; import
 * com.tecnostorms.bank.model.User; import
 * com.tecnostorms.bank.model.UserPrincipal;
 * 
 * @Service public class UserDetailService implements UserDetailsService {
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { User user =
 * userRepository.findByfirstName(username); if(user==null) { throw new
 * UsernameNotFoundException("User not found."); }else { return new
 * UserPrincipal(user); } }
 * 
 * }
 */