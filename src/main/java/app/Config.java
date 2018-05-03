package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ShortestPathConfig.class, ModelConfig.class, SwaggerConfig.class})
public class Config {

}
