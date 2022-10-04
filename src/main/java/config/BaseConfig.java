package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config {

    String apiUrl();

    String apiUser();

    String uiUrl();

    String uiLogin();

    String uiPassword();

    String browserSize();
}
