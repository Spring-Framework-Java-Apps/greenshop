package org.woehlke.greenshop.conf;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Slf4j
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Validated
@Component
@ConfigurationProperties(prefix="org.woehlke.greenshop")
public class GreenshopProperties implements Serializable {

    private static final long serialVersionUID = 4480323170764476017L;

    @NotNull
    private Boolean devTesting;

    @NotNull
    private Integer testDataHowManyTestData;

    @Valid
    @NotNull
    public UserConfig userConfig;

    @Valid
    @NotNull
    public WebConfig webConfig;

    @Valid
    @NotNull
    public WebSecurity webSecurity;

    @ToString
    @Getter
    @Setter
    @Validated
    public static class UserConfig {

        @Email
        @NotBlank
        private String userEmail;

        @NotBlank
        private String userPassword;

        @NotBlank
        private String userFullname;
    }

    @ToString
    @Getter
    @Setter
    @Validated
    public static class WebConfig {

        @NotBlank
        private String exportFilename;

        @NotBlank
        private String exportFilenameSeparator;

        @NotNull
        private String[] webAddResourceHandlers;

        @NotNull
        private String[] webAddResourceHandlersStatic;
    }


    @ToString
    @Getter
    @Setter
    @Validated
    public static class WebSecurity {

        @NotNull
        private Boolean invalidateHttpSession;

        @NotBlank
        private String loginProcessingUrl;

        @NotBlank
        private String failureForwardUrl;

        @NotBlank
        private String defaultSuccessUrl;

        @NotBlank
        private String logoutUrl;

        @NotBlank
        private String loginPage;

        @NotBlank
        private String deleteCookies;

        @NotBlank
        private String antMatchersFullyAuthenticated;

        @NotNull
        private String[] antMatchersPermitAll;

        @NotBlank
        private String usernameParameter;

        @NotBlank
        private String passwordParameter;

        @NotBlank
        private String secret;

        @NotNull
        private Integer iterations;

        @NotNull
        private Integer hashWidth;
    }
}
