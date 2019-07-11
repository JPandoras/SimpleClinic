package app.springboot.simpleclinic.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/doctor").setViewName("doctor");
        registry.addViewController("/pharmacy").setViewName("pharmacy");
        registry.addViewController("/clinicadm").setViewName("clinicadm");
    }

}
