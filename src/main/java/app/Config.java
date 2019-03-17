package app;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Import({ModelConfig.class, SwaggerConfig.class})
public class Config {
}
