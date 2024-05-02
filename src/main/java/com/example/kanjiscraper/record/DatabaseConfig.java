package com.example.kanjiscraper.record;

public class DatabaseConfig {
    private String jdbcUrl;
    private String username;
    private String password;
    private String[] tableName;
    private String MYSQL_JDBC_DRIVER_CLASS;

    private DatabaseConfig(String jdbcUrl, String username, String password, String[] tableName, String mysqlJdbcDriverClass) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        this.tableName = tableName;
        this.MYSQL_JDBC_DRIVER_CLASS = mysqlJdbcDriverClass;
    }

    public static DatabaseConfig createWithDefaults() {
        return new DatabaseConfig(
                "jdbc:mysql://localhost:3307/dbjavacrud",
                "root",
                "",
                new String[]{"tbluseraccount", "tbluserprofile", "tbljapanesevocabulary"},
                "com.mysql.cj.jdbc.Driver"
        );
    }

    // Getters for each field
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String[] getTableName() {
        return tableName;
    }

    public String getMYSQL_JDBC_DRIVER_CLASS() {
        return MYSQL_JDBC_DRIVER_CLASS;
    }
}
