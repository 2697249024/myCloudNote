package com.lyy.note.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/***
 * Swagger2配置类 
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	/***
	 * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.lyy.note.controller"))
                .paths(PathSelectors.any()).build();
	}

	 /**
     * @Description: 构建 api文档的信息
     */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
		// 设置页面标题
		.title("使用swagger2构建笔记小屋后端api接口文档")
		//设置联系人
		.contact(new Contact("给ni的流年", "http://www.yueyangcloud.cn", "2697249024@qq.com"))
		  // 描述
        .description("欢迎笔记小屋api接口文档，这里是描述信息")
        // 定义版本号
        .version("1.0").build();
	}
	
	
}
