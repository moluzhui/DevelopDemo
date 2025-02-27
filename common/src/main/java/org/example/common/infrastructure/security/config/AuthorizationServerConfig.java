package org.example.common.infrastructure.security.config;

import com.google.common.base.Predicates;
import org.example.common.infrastructure.security.filter.JWTSecurityFilter;
import org.example.common.infrastructure.security.hander.AuthenticationEntryPointImpl;
import org.example.common.utils.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * .
 *
 * @since 2024/6/4 23:36
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthorizationServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTSecurityFilter jwtSecurityFilter;

    @Autowired
    private AccessDeniedHandler accessDeniedHandlerImpl;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPointImpl;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        // 大面积权限点配置
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/swagger-ui.html","/webjars/**","/swagger-ui.html/**",
                        "/swagger-resources/**","/v2/api-docs/**","/admin/login").anonymous()
//                .antMatchers("/admin/**").hasRole("")
                .anyRequest().authenticated().and().addFilterBefore(jwtSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPointImpl).accessDeniedHandler(accessDeniedHandlerImpl);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("webApi").apiInfo(webApiInfo()).select().paths(Predicates.not(PathSelectors.regex("/error*"))).build().globalOperationParameters(getParameterList());
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder().title("漆水河API中心").description("spring boot 从零开始").version("1.0").build();
    }

    private List<Parameter> getParameterList(){
        ParameterBuilder clientIdTickt = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        clientIdTickt.name(CommonConstant.TOKEN_STR).description("请求令牌").modelRef(new ModelRef("String"))
                .parameterType("header").required(false).build();
        parameters.add(clientIdTickt.build());
        return parameters;
    }

}
