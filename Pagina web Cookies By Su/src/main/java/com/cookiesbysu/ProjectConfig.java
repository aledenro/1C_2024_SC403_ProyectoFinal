package com.cookiesbysu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");

        return slr;
    }

    @Bean
    public LocaleChangeInterceptor changeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");

        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(changeInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests((request) 
                -> request.requestMatchers("/", "/login", "/js/**", "/webjars/**", "/producto/ver/**", "/producto/info", 
                        "/registro/**","/personalizado/verForm", "/personalizado/form", "/nosotros/**", "/contacto/**").permitAll()
                .requestMatchers("/producto/guardar", "/producto/modificar/**", "/producto/modifica", "/producto/agregarProducto", 
                        "/producto/agregar", "producto/eliminar/**","/personalizado/listado", "/personalizado/eliminar/**").hasRole("ADMIN")
                .requestMatchers("/facturar/carrito").hasRole("USER"))
                .formLogin((form) -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.logoutSuccessUrl("/").permitAll());

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService users() {
//        UserDetails admin = User.builder().username("admin").password("{noop}123").roles("USER", "ADMIN").build();
//        UserDetails user = User.builder().username("test").password("{noop}789").roles("USER").build();
//
//        return new InMemoryUserDetailsManager(admin, user);
//    }
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
