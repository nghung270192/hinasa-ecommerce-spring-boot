package com.angularspringbootecommerce.backend;

import com.angularspringbootecommerce.backend.dtos.UserRoleDto;
import com.angularspringbootecommerce.backend.repository.UserRepository;
import com.angularspringbootecommerce.backend.repository.UserRoleRepository;
import com.angularspringbootecommerce.backend.services.ApplicationInstallService;
import com.angularspringbootecommerce.backend.services.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class BackenApplicationInstall {


    public static void main(String[] args) {
        try {
            SpringApplication application = new SpringApplication(BackenApplicationInstall.class);
            application.setAdditionalProfiles("install");

            ConfigurableApplicationContext context = application.run(updateArguments(args));
            context.getBean(ApplicationInstallService.class).performInstall();
        } catch (Exception e) {
            log.error(e.getMessage());
            System.exit(1);
        }
    }

    private static String[] updateArguments(String[] args) {
        /*if (Arrays.stream(args).noneMatch(arg -> arg.startsWith(SPRING_CONFIG_NAME_KEY))) {
            String[] modifiedArgs = new String[args.length + 1];
            System.arraycopy(args, 0, modifiedArgs, 0, args.length);
            modifiedArgs[args.length] = DEFAULT_SPRING_CONFIG_PARAM;
            return modifiedArgs;
        }*/
        return args;
    }
}

