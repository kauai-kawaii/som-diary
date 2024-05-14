package com.example.somdiary.jwt;

import com.example.somdiary.dto.CustomOAuth2User;
import com.example.somdiary.dto.UserDTO;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;

    public JWTFilter(JWTUtil jwtUtil) {

        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestUri = request.getRequestURI();

        if (requestUri.matches("^\\/login(?:\\/.*)?$")) {

            filterChain.doFilter(request, response);
            return;
        }
        if (requestUri.matches("^\\/oauth2(?:\\/.*)?$")) {

            filterChain.doFilter(request, response);
            return;
        }

        //cookie들을 불러온 뒤 Authorization Key에 담긴 쿠키를 찾음
        String authorization = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {

            System.out.println(cookie.getName());
            if (cookie.getName().equals("Authorization")) {

                authorization = cookie.getValue();
            }
        }

        //Authorization 헤더 검증
        if (authorization == null) {

            System.out.println("token null");
            filterChain.doFilter(request, response);

            //조건이 해당되면 메소드 종료
            return;
        }
//
//        //토큰
//        String token = authorization;
//
//        //토큰 소멸 시간 검증
//        if (jwtUtil.isExpired(token)) {
//
//            System.out.println("token expired");
//            filterChain.doFilter(request, response);
//
//            //조건이 해당되면 메소드 종료
//            return;
//        }

        // 토큰 검증
        try {
            String token = authorization;
            if (jwtUtil.isExpired(token)) {
                // 토큰 만료 처리
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token expired. Please login again."); // 클라이언트에게 메시지 전송
                response.sendRedirect("http://localhost:8081/oauth2/authorization/google"); // 로그인 페이지로 리디렉션
                return;
            }

            // 토큰에서 userId와 role 추출
            String userId = jwtUtil.getUserId(token);
            String role = jwtUtil.getRole(token);

            // UserDTO 생성하여 값 설정
            UserDTO userDTO = new UserDTO();
            userDTO.setId(userId);
            userDTO.setRole(role);

            // UserDetails에 회원 정보 객체 담기
            CustomOAuth2User customOAuth2User = new CustomOAuth2User(userDTO);

            // 스프링 시큐리티 인증 토큰 생성
            Authentication authToken = new UsernamePasswordAuthenticationToken(customOAuth2User, null, customOAuth2User.getAuthorities());

            // 세션에 사용자 등록
            SecurityContextHolder.getContext().setAuthentication(authToken);

            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException ex) {
            // 토큰이 만료된 경우의 처리
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token expired. Please login again."); // 클라이언트에게 메시지 전송
            response.sendRedirect("http://localhost:8081/oauth2/authorization/google"); // 로그인 페이지로 리디렉션
        }
    }
}
