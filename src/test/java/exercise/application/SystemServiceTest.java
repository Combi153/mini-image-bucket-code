package exercise.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
class SystemServiceTest {

    @Autowired
    private SystemService systemService;

    @Test
    void 메모리_사용량을_반환한다() {
        // when
        String message = systemService.calculateMemoryUsage();

        // then
        assertThat(message).contains("total(byte) : ", "free(byte) : ", "total - free(byte) : ");
    }
}
