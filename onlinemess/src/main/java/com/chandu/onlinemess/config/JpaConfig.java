package com.chandu.onlinemess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
   @Bean
   public AuditorAware<String> auditorAware() {
      return  new AuditorAware<String>() {
         @Override
         public Optional<String> getCurrentAuditor() {
            return Optional.empty();
         }
      };
   }

}
