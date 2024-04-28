package com.example.kanjiscraper.record;

public record DatabaseConfig(
        String jdbcUrl,
        String username,
        String password,
        String[] tableName,
        String MYSQL_JDBC_DRIVER_CLASS
){
    private DatabaseConfig() {
        this(
                "jdbc:mysql://localhost:3307/dbjavacrud",
                "root",
                "",
                new String[]{"tbluseraccount", "tbluserprofile", "tbljapanesevocabulary"},
                "com.mysql.cj.jdbc.Driver"
        );
    }
    public static DatabaseConfig createWithDefaults() {
        return new DatabaseConfig();
    }
}
