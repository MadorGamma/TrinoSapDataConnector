# TrinoSapDataConnector
This is code for a connector from sap to trino using the official sap jdbc.

## Connector installation
In order to install the connector we first need to build the project using maven, the trino packaging type creates a target directory in the project
and builds the connector files in there, after building you will find in the target directory a bunch of directories with 2 jars and a zip file,
in order to add the connector itself to trino you will need to take the TrinoSapHanaConnector-1.0 directory and add it to the catalogs directory in your trino installation.
if your trino is installed on VMs you will just need to copy the directory over with your preffered method, if however you are running trino on a container, either standalone
or using kubernetes/openshift you will have to update your image, the repository has an example Dockerfile just for that purpose, you can change the trino version and the 
directory location and run it locally to update the image.

## Connector configuration
The connector currently supports the basic jdbc configuration and everything included in it, the basic properties required to get it working as seen in this example are:
```
connector.name=sap_hana_jdbc
connection-url=jdbc:sap://example.net:5432/?databaseName=database&currentSchema=schema
connection-user=username
connection-password=password
```


## Connector capabilities and type mappings
This connector is capable of connecting to any sap hana DB and read/write data for most common data types without pushdown, the currently supported read types are:

| Sap Type  | Trino Type |
| ------------- | ------------- |
| SMALLINT  | SMALLINT  |
| INTEGER  | INTEGER  |
| BIGINT  | BIGINT  |
| REAL  | REAL  |
| DOUBLE  | DOUBLE  |
| CHAR  | CHAR  |
| NCHAR  | CHAR  |
| VARCHAR  | VARCHAR  |
| NVARCHAR  | VARCHAR  |
| BINARY  | VARBINARY  |
| VARBINARY  | VARBINARY  |
| LONGVARBINARY  | VARBINARY  |
| BLOB  | VARBINARY  |
| CLOB  | VARCHAR  |
| NCLOB  | VARCHAR  |
| TIMESTAMP  | TIMESTAMP  |

While most of these types are also supported for writing, not all of them are yet, the currently supported write types are:

| Trino Type  | Sap Type |
| ------------- | ------------- |
| SMALLINT  | SMALLINT |
| INTEGER  | INTEGER |
| BIGINT  | BIGINT |
| REAL  | REAL |
| DOUBLE  | DOUBLE |
| CHAR  | CHAR |
| CHAR  | NCHAR |
| VARCHAR  | VARCHAR |
| VARCHAR  | NVARCHAR |

