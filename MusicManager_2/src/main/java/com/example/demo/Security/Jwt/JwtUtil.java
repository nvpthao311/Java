package com.example.demo.Security.Jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET;

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // thông tin chính trong token (ở đây là username)
                .setIssuedAt(new Date(System.currentTimeMillis())) // thời gian tạo token
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 giờ sau hết hạn
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256) // ký token bằng thuật toán HS256
                .compact(); // tạo ra token dạng String
    }

    //Lấy thông tin từ token
    public String extractUsername(String token) {
        return Jwts.parser() //Tạo một JWT parser — đối tượng dùng để phân tích và xác thực token
                .setSigningKey(SECRET.getBytes()) // Gán secret key để parser có thể kiểm tra chữ ký (signature) của token.
                .build() //Tạo một parser thực sự từ builder.
                .parseClaimsJws(token) // Phân tích token (JWS = JWT có chữ ký) và trả về phần payload nếu token hợp lệ.
                .getBody()
                .getSubject(); // lấy username từ phần "subject"
    }

    //Kiểm tra token hợp lệ
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token); // lấy username từ token
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token); // so sánh username và kiểm tra hạn token
    }

    //Kiểm tra token hết hạn
    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date()); // nếu thời gian hết hạn < thời gian hiện tại → đã hết hạn
    }



}
