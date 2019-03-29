# spring boot 使用JdbcTemplate


* 1.增加spring-boot-starter、spring-boot-starter-jdbc、mysql-connector-java依赖  
* 2.配置数据源信息： application.properties 文件中增加配置    
   spring.datasource.url=jdbc:mysql://localhost:3306/test?serverTimezone=GMT&useUnicode=true&characterEncoding=UTF-8&rewriteBatchedStatements=true&useSSL=false    
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
   spring.datasource.username=      
   spring.datasource.password=     
* 3.书写一个UserService接口
* 4.书写UserServiceImpl实现类，增加自动注入的JdbcTemplate，增加对应的查询、修改方法  
* 5.增加  UserServiceImplTest 类，注意：类上加注解@SpringBootTest 






