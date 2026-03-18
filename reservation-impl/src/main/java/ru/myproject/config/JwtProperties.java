package ru.myproject.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Validated
@Getter
@Setter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    @NotBlank(message = "поле secret не должно быть пустым")
    @Size(min = 32, message = "jwt.secret must contain at least 32 characters")
    private String secret;

    @NotNull(message = "поле expiration не должно быть пустым")
    private Duration expiration =  Duration.ofMinutes(10);
}
