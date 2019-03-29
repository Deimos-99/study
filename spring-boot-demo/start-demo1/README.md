# spring boot 实现rest请求demo

## 第一个demo
* 1.引入依赖spring-boot-starter-web、spring-boot-starter-test
* 2.工程结构   
  src/main/java java源文件,注意启动类的位置在所有的包上层    
  src/main/resources 资源文件位置    
  src/main/resources/static 静态资源文件,例如图片/js文件    
  src/main/resources/templates 界面文件    
  src/test 测试类文件夹     
  注意：Application启动类文件应该放在所有包的上层
* 3.增加controller包，增加HelloController   
    类标记@RestController、@RequestMapping    
    方法标记@GetMapping或者@RequestMapping   
* 4.增加测试类HelloControllerTest   


## restController demo
* 1.创建用户实体User   
* 2.增加UserController
* 3.增加对应的@GetMapping、@PostMapping、@PutMapping、@DeleteMapping方法
* 4.书写测试，参见UserControllerTest


## html界面处理 使用模版引擎thymeleaf
* 1.依赖增加spring-boot-starter-thymeleaf
* 2./resources/static 默认存放js/图片文件
* 3./resources/templates 默认存放html文件
* 4.增加ThymeleafController，增加index的请求，返回index显示界面的值，相关配置文件参考application.properties



## 增加swagger api文档
* 1.依赖增加springfox-swagger2、springfox-swagger-ui
* 2.增加配置类Swagger2  标记 @Configuration、@EnableSwagger2、新增Docket构建返回，参见Swagger2
* 3.参见UserController 进行修改   
    @Api 标记在类上    
    @ApiOperation 标记在方法上   
    @ApiResponses 标记在方法上 @ApiResponse(code=200, message = "正常返回"), 对应状态码和信息   
    @ApiImplicitParam 标记在方法上，描述对应参数，仅一个参数，例如：   
    @ApiImplicitParam(name = "user", value="用户详细信息实体", required = true, dataType = "User")   
    多个参数配合@ApiImplicitParams和@ApiImplicitParam 处理  
    @ApiModel(value = "用户实体") 标记在实体类上  
    @ApiModelProperty标记在实体类的属性上，例如：
    @ApiModelProperty(value="用户id", required = true, dataType = "String")       
    value 填充显示值 required 是否必须 dataType属性类型     



    
    