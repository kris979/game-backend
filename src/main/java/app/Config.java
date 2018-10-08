package app;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Import({ShortestPathConfig.class, ModelConfig.class, SwaggerConfig.class})
public class Config {
//
//    DataSource dataSource() throws SQLException {
//
//        OracleDataSource dataSource = new OracleDataSource();
//        dataSource.setUser("test");
//        dataSource.setPassword("test");
//        dataSource.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
//        dataSource.setImplicitCachingEnabled(true);
//        dataSource.setFastConnectionFailoverEnabled(true);
//        return dataSource;
//    }


}
