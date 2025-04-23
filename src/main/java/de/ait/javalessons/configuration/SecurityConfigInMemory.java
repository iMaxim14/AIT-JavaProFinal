//package de.ait.javalessons.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfigInMemory {
//
//    // шифрование
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    //определение ролей
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder){
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("userpass"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("adminpass"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails customer = User.withUsername("customer")
//                .password(passwordEncoder.encode("customerpass"))
//                .roles("CUSTOMER")
//                .build();
//
//        UserDetails manager = User.withUsername("manager")
//                .password(passwordEncoder.encode("managerpass"))
//                .roles("MANAGER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin, customer, manager);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(("/employees/public/**")).permitAll()
//                        .requestMatchers(("/employees/user/**")).hasRole("USER")
//                        .requestMatchers(("/employees/admin/**")).hasRole("ADMIN")
//                        .requestMatchers(("/products/public/list**")).permitAll()
//                        .requestMatchers(("/products/customer/cart**")).hasRole("CUSTOMER")
//                        .requestMatchers(("/products/manager/add")).hasRole("MANAGER")
//                        .requestMatchers(("/h2-console")).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(withDefaults());
//        http.headers(headers -> headers.frameOptions().disable());
//        return http.build();
//    }
//
//}
