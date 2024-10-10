import javax.sql.DataSource;


@Configuration
public class DatabaseConfiguration {

    @Qualifier("jdbcProductService")
    @Autowired
    JdbcTemplate jdbcProductTemplate;

    @Qualifier("jdbcUserService")
    @Autowired
    JdbcTemplate jdbcUserTemplate;

    @Bean(name="dbProductService")
    @ConfigurationProperties(prefix="spring.dbProductService")
    @Primary
    public DataSource createProductServiceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="dbUserService")
    @ConfigurationProperties(prefix="spring.dbUserService")
    public DataSource createUserServiceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="jdbcProductService")
    @Autowired
    public JdbcTemplate createJdbcTemplate_ProductService(
            @Qualifier("dbProductService") DataSource productServiceDS
    ) {
        return new JdbcTemplate(productServiceDS);
    }

    @Bean(name="jdbcUserService")
    @Autowired
    public JdbcTemplate createJdbcTemplate_UserService(
            @Qualifier("dbUserService") DataSource userServiceDS
    ) {
        return new JdbcTemplate(userServiceDS);
    }

}