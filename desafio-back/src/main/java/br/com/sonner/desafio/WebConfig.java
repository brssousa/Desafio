package br.com.sonner.desafio;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig {
    @Configuration
    @EnableWebMvc
    public static class WebConfiguracao implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");// <- assim permite de qualquer origem, troque "/**" pelo seu dominio por exemplo "http://meudominio.com"
        }
    }
}
