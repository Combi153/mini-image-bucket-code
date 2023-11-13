package exercise;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    public String generateToken(String subject, Long expirationTime, Key key) {
        final Date now = new Date();
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationTime))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public Key generateKey(String secret) {
        byte[] accessKeyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(accessKeyBytes);
    }
}
