package com.example.somdiary.config;

import com.example.somdiary.jwt.JWTFilter;
import com.example.somdiary.jwt.JWTUtil;
import com.example.somdiary.oauth2.CustomSuccessHandler;
import com.example.somdiary.service.CustomOAuth2UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomSuccessHandler customSuccessHandler;
    private final JWTUtil jwtUtil;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService, CustomSuccessHandler customSuccessHandler,  JWTUtil jwtUtil) {

        this.customOAuth2UserService = customOAuth2UserService;
        // 핸들러 주입 (JWT 동작을 위함)
        this.customSuccessHandler = customSuccessHandler;
        this.jwtUtil = jwtUtil;
    }


    @Bean
    // SecurityFilterChain 인터페이스 리턴 메서드 (인자로 HttpSecurity 객체인자 받게됨)
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        log.info("시큐리티 설정");
        http
                .csrf((auth) -> auth.disable()); // 개발 단계 잠시 종료

        http
                .formLogin((auth) -> auth.disable());

        http
                .httpBasic((auth) -> auth.disable());

//        http
//                .addFilterBefore(new JWTFilter(jwtUtil), OAuth2LoginAuthenticationFilter.class);


//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                        .requestMatchers("/main/**", "/diary/**", "/search-location").authenticated()
//                        .anyRequest().permitAll());

        http
                .oauth2Login((oauth2) -> oauth2
                        .userInfoEndpoint((userInfoEndpointConfig) -> userInfoEndpointConfig
                                .userService(customOAuth2UserService))
//                        .successHandler(customSuccessHandler)
                );

        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build(); // 객체를 빌더타입으로 리턴
    }
}
