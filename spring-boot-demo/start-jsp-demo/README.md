# spring boot 使用jsp

##工程结构说明 
  src/main/java java源文件,注意启动类的位置在所有的包上层    
  src/main/resources 资源文件位置    
  src/main/resources/static 静态资源文件,例如图片/js文件    
  src/main/resources/templates 界面文件    
  src/test 测试类文件夹     
  src/main/webapp/WEB-INF/jsp 为jsp存放目录
  注意：Application启动类文件应该放在所有包的上层

## 具体步骤
* 1.添加依赖spring-boot-starter-web、spring-boot-starter-tomcat、tomcat-embed-jasper、jstl支持
* 2.增加jsp存放目录结构src/main/webapp/WEB-INF/jsp
* 3.配置文件中增加配置    
    spring.mvc.view.prefix: /WEB-INF/jsp/    
    spring.mvc.view.suffix: .jsp    
    application.message: Hello   
* 4.增加WelcomeController文件，使用注解@Controller标记类，书写welcome请求，方法标记@RequestMapping，方法范围welcome界面    
* 5.增加welcome.jsp文件  


