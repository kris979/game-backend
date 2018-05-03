package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class ModelConfig {

	@Value("#{new Boolean(\"${profile.active}\"==\"dev\")}")
	private Boolean isDev;
	
}
