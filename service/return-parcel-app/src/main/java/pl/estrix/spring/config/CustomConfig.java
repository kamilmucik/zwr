package pl.estrix.spring.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource("file:${catalina.base}/conf/custom.properties")
public class CustomConfig {

    @Value( "${textextractor.url}" )
    private String textextractorUrl;

}
