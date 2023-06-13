package org.example;

import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import io.airlift.configuration.AbstractConfigurationAwareModule;
import io.trino.plugin.jdbc.BaseJdbcConfig;
import io.trino.plugin.jdbc.ConnectionFactory;
import io.trino.plugin.jdbc.DriverConnectionFactory;
import io.trino.plugin.jdbc.ForBaseJdbc;
import io.trino.plugin.jdbc.JdbcClient;
import io.trino.plugin.jdbc.credential.CredentialProvider;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SapHanaClientModule extends AbstractConfigurationAwareModule
{
    @Override
    public void setup(Binder binder)
    {
        binder.bind(JdbcClient.class).annotatedWith(ForBaseJdbc.class).to(SapHanaClient.class).in(Scopes.SINGLETON);
    }

    @Provides
    @Singleton
    @ForBaseJdbc
    public static ConnectionFactory getConnectionFactory(BaseJdbcConfig config, CredentialProvider credentialProvider)
             throws SQLException
    {
        Properties connectionProperties = new Properties();
        return new DriverConnectionFactory(DriverManager.getDriver(config.getConnectionUrl()), config.getConnectionUrl(), connectionProperties, credentialProvider);
    }
}
