package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.net.ssl.HttpsURLConnection;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class ${entity}Manager {

    public static final String AUTH = "basicAuth";

    public static void main(String[] args) {
        SpringApplication.run(${entity}Manager.class, args);
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Collections.singletonList(new BasicAuth(AUTH)))
                .securityContexts(
                        Collections.singletonList(
                                SecurityContext
                                        .builder()
                                        .securityReferences(Collections.singletonList(new SecurityReference(AUTH, new AuthorizationScope[0])))
                                        .build())
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("${package}.ws"))
                .build();
    }

    static {
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> hostname.equals("localhost"));
    }
}
