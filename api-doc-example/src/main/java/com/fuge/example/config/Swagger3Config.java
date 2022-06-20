package com.fuge.example.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 描述： 单独定义 Swagger 配置类 profile 中包含 dev,sit,uat 任意一个时才会启动 Swagger （即生产环境不启动 Swagger） 环境变量
 * SPRING_PROFILES_ACTIVE=dev/sit/uat 才启用该配置
 */
@Configuration
@EnableOpenApi
@EnableSwaggerBootstrapUI
public class Swagger3Config {



    /**
     * @return Docket是swagger全局配置对象
     */
    @Bean
    public Docket createApi(SwaggerProperties properties) {
        return new Docket(properties.getDocumentationType().value)
                .apiInfo(createApiInfo(properties))
                .select()
                // 指定扫描的包，不指定会扫描出 spring 框架的接口，指定错误会导致接口扫描不出来
                .apis(RequestHandlerSelectors
                        .basePackage(properties.getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .globalRequestParameters(getGlobalRequestParameters())//加入通用入参
                .globalResponses(HttpMethod.POST, getGlobalResonseMessage());//post方法加入通用响应头
    }

    /**
     * API 文档基础信息，包括标题、联系人等
     * @return ApiInfo
     */
    private ApiInfo createApiInfo(SwaggerProperties properties) {
        SwaggerApiInfo apiInfoMeta = properties.getApiInfo();
        SwaggerApiInfoContact contactMeta = apiInfoMeta.getContact();
        Contact contact = new Contact(contactMeta.getName(), contactMeta.getUrl(), contactMeta.getEmail());
        return new ApiInfoBuilder()
                .title(apiInfoMeta.getTitle())
                .description(apiInfoMeta.getDescription())
                .contact(contact)
                .build();
    }

    //定义文档类型，配置文件配置
    public enum DocumentationTypeMode {
        /**
         * SWAGGER_12
         */
        SWAGGER_12(DocumentationType.SWAGGER_12),
        /**
         * SWAGGER_2
         */
        SWAGGER_2(DocumentationType.SWAGGER_2),
        /**
         * OAS_30
         */
        OAS_30(DocumentationType.OAS_30);

        private final DocumentationType value;

        DocumentationTypeMode(DocumentationType value) {
            this.value = value;
        }
    }

    @Component
    @PropertySource(value = "classpath:/config/swagger.properties", ignoreResourceNotFound = true, encoding = "UTF-8")
    @ConfigurationProperties(prefix = "swagger")
    public static class SwaggerProperties {

        private DocumentationTypeMode documentationType = DocumentationTypeMode.OAS_30;

        private String basePackage = "com.example.demo.db.controller";

        private SwaggerApiInfo apiInfo = new SwaggerApiInfo();

        public DocumentationTypeMode getDocumentationType() {
            return documentationType;
        }

        public void setDocumentationType(DocumentationTypeMode documentationType) {
            this.documentationType = documentationType;
        }

        public String getBasePackage() {
            return basePackage;
        }

        public void setBasePackage(String basePackage) {
            this.basePackage = basePackage;
        }

        public SwaggerApiInfo getApiInfo() {
            return apiInfo;
        }

        public void setApiInfo(SwaggerApiInfo apiInfo) {
            this.apiInfo = apiInfo;
        }
    }
    //文档信息联系人实体类
    public static class SwaggerApiInfoContact {
        private String name;

        private String url;

        private String email;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
    //文档信息联系人实体类
    public static class SwaggerApiInfo {

        private String title;

        private String description;

        @NestedConfigurationProperty
        private SwaggerApiInfoContact contact;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public SwaggerApiInfoContact getContact() {
            return contact;
        }

        public void setContact(SwaggerApiInfoContact contact) {
            this.contact = contact;
        }
    }

    //生产通过接口入参
    private List<RequestParameter> getGlobalRequestParameters() {
        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("appid")
                .description("平台id")
                .required(true)
                .in(ParameterType.QUERY)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
        parameters.add(new RequestParameterBuilder()
                .name("udid")
                .description("设备的唯一id")
                .required(true)
                .in(ParameterType.QUERY)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
        parameters.add(new RequestParameterBuilder()
                .name("version")
                .description("客户端的版本号")
                .required(true)
                .in(ParameterType.QUERY)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());
        return parameters;
    }

    //生成通用响应信息
    private List<Response> getGlobalResonseMessage() {
        List<Response> responseList = new ArrayList<>();
        responseList.add(new ResponseBuilder()
                .code("404")
                .description("找不到资源")
                .build());
        responseList.add(new ResponseBuilder()
                .code("0")
                .description("成功")
                .build());
        responseList.add(new ResponseBuilder()
                .code("10")
                .description("系统异常")
                .build());
        responseList.add(new ResponseBuilder()
                .code("20")
                .description("参数错误")
                .build());
        responseList.add(new ResponseBuilder()
                .code("30")
                .description("系统异常")
                .build());
        //或者通过枚举类添加
//        for (ResponseStatusEnum value:ResponseStatusEnum.values()) {
//            String code = String.valueOf(value.getCode());
//            String message =value.getMessage();
//                    responseList.add(new ResponseBuilder().code(code).description(message);
//        }

        return responseList;
    }
}