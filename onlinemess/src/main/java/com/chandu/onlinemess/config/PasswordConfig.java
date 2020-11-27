package com.chandu.onlinemess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordConfig {

   @Bean
   protected BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

}
