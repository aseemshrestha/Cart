package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@ComponentScan( basePackages = "com.shop" )
@SpringBootApplication
public class ShoppingCartApplication extends SpringBootServletInitializer
{

    public static void main(String[] args)
    {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(ShoppingCartApplication.class);
    }

    /* tiles configuration */
    @Bean
    public UrlBasedViewResolver tilesViewResolver()
    {
        UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
        tilesViewResolver.setViewClass(TilesView.class);
        return tilesViewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer()
    {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        String[] defs = { "/WEB-INF/tiles.xml" };
        tilesConfigurer.setDefinitions(defs);
        return tilesConfigurer;
    }
}
