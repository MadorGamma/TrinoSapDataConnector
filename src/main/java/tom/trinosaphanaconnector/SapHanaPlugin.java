package tom.trinosaphanaconnector;

import io.trino.plugin.jdbc.JdbcPlugin;

public class SapHanaPlugin extends JdbcPlugin {
    public SapHanaPlugin()
    {
        super("sap_hana_jdbc", new SapHanaClientModule());
    }
}
