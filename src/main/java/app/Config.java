package app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ModelConfig.class, SwaggerConfig.class})
public class Config {

}
