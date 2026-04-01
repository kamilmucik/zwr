package pl.estrix.zwroty.textextractor.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.estrix.zwroty.textextractor.domain.TextExtractorDomainService;

@Configuration
public class BeanRequestConfiguration {

    private final TextextractorServiceConfigProperties properties;

    public BeanRequestConfiguration(TextextractorServiceConfigProperties properties) {
        this.properties = properties;
    }

    @Bean
    public TextExtractorDomainService textExtractorDomainService() {
        return new TextExtractorDomainService(properties.getAwsAccessKeyId(), properties.getAwsSecretAccessKey());
    }
}
