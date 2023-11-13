package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.Key;
import org.junit.jupiter.api.Test;

class JwtTokenProviderTest {

    @Test
    void generateKey_test() {
        // given
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String secretKey = "secretKey".repeat(10);

        // when
        Key key = jwtTokenProvider.generateKey(secretKey);

        // then
        assertThat(key).isNotNull();
    }

    @Test
    void generateToken_test() {
        // given
        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String secretKey = "secretKey".repeat(10);
        Key key = jwtTokenProvider.generateKey(secretKey);

        // when
        String token = jwtTokenProvider.generateToken("member", 10000L, key);

        // then
        assertThat(token).isNotNull();
    }
}
