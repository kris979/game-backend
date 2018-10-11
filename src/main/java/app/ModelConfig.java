package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import javax.servlet.Filter;

@Configuration
@PropertySource("classpath:/application.properties")
public class ModelConfig {

	@Value("#{new Boolean(\"${profile.active}\"==\"dev\")}")
	private Boolean isDev;

	@Bean
	public Filter filter(){
		ShallowEtagHeaderFilter filter=new ShallowEtagHeaderFilter();
		return filter;
	}

}
