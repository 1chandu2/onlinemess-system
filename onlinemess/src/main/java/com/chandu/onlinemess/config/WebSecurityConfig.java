package com.chandu.onlinemess.config;

import com.chandu.onlinemess.security.CustomCorsFilter;
import com.chandu.onlinemess.security.RestAuthenticationEntryPoint;
import com.chandu.onlinemess.security.basicAuth.BasicAuthLoginProcessingFilter;
import com.chandu.onlinemess.security.basicAuth.BasicAuthenticationProvider;
import com.chandu.onlinemess.security.jwt.TokenExtractor;
import com.chandu.onlinemess.security.tokenAuth.SkipPathRequestMatcher;
import com.chandu.onlinemess.security.tokenAuth.TokenAuthenticationProcessingFilter;
import com.chandu.onlinemess.security.tokenAuth.TokenAuthenticationProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String AUTHENTICATION_HEADER_NAME = "Authorization";
    public static final String AUTHENTICATION_URL = "/api/v1/auth/login";
    public static final String SIGNUP_URL = "/api/v1/auth/signup";
    public static final String REFRESH_TOKEN_URL = "/api/v1/auth/token";
    public static final String API_ROOT_URL = "/api/v1/**";

    public static final String STUDENT_API_BASE_URL = "/api/v1/student/**";
    public static final String SECY_API_BASE_URL = "/api/v1/secy/**";
    public static final String MANAGER_API_BASE_URL = "/api/v1/manager/**";
    public static final String MESS_COUNTER_BASE_URL = "/api/v1/counter/**";
   public static final String ADMIN_BASE_URL = "/api/v1/admin/**";

    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    private BasicAuthenticationProvider basicAuthenticationProvider;
    @Autowired
    private TokenAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private TokenExtractor tokenExtractor;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ObjectMapper objectMapper;

    protected BasicAuthLoginProcessingFilter buildAjaxLoginProcessingFilter(String loginEntryPoint) throws Exception {
        BasicAuthLoginProcessingFilter filter = new BasicAuthLoginProcessingFilter(loginEntryPoint, successHandler, failureHandler, objectMapper);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    protected TokenAuthenticationProcessingFilter buildJwtTokenAuthenticationProcessingFilter(List<String> pathsToSkip, String pattern) throws Exception {
        SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, pattern);
        TokenAuthenticationProcessingFilter filter
            = new TokenAuthenticationProcessingFilter(failureHandler, tokenExtractor, matcher);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(basicAuthenticationProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);
    }

   @Bean
   public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
      StrictHttpFirewall firewall = new StrictHttpFirewall();
      firewall.setAllowUrlEncodedSlash(true);
      return firewall;
   }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<String> permitAllEndpointList = Arrays.asList(
            AUTHENTICATION_URL,
            REFRESH_TOKEN_URL,
            SIGNUP_URL,
            "/console"
        );

        http
            .csrf().disable() // We don't need CSRF for JWT based authentication
            .exceptionHandling()
            .authenticationEntryPoint(this.authenticationEntryPoint)

            .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
                .authorizeRequests()
                .antMatchers(permitAllEndpointList.toArray(new String[permitAllEndpointList.size()]))
                .permitAll()
            .and()
                .authorizeRequests()
                .antMatchers(STUDENT_API_BASE_URL).hasAuthority("STUDENT")
                .antMatchers(SECY_API_BASE_URL).hasAuthority("SECY")
                .antMatchers(MANAGER_API_BASE_URL).hasAuthority("MANAGER")
                .antMatchers(MESS_COUNTER_BASE_URL).hasAuthority("COUNTER")
                .antMatchers(ADMIN_BASE_URL).hasAuthority("ADMIN")
                .anyRequest().authenticated() // Protected API End-points
            .and()
                .addFilterBefore(new CustomCorsFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildAjaxLoginProcessingFilter(AUTHENTICATION_URL), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(buildJwtTokenAuthenticationProcessingFilter(permitAllEndpointList,
                API_ROOT_URL), UsernamePasswordAuthenticationFilter.class);

    }

   @Override
   public void configure(WebSecurity web) throws Exception {
      super.configure(web);
      web.httpFirewall(new DefaultHttpFirewall());

   }


}
