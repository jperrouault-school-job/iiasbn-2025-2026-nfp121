public class DbConfig {
    private String host;
    private String username;
    private String password;
    private int port;
    private String type;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DbConfig() { }

    public DbConfig(String host, String username, String password, int port, String type) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
        this.type = type;
    }

    public static DbConfigBuilderV1 builder() {
        return new DbConfigBuilderV1();
    }

    public static DbConfigBuilderV2 newBuilder() {
        return new DbConfigBuilderV2();
    }

    public static class DbConfigBuilderV1 {
        private String host;
        private String username;
        private String password;
        private int port;
        private String type;

        public DbConfigBuilderV1 mysql(String host) {
            this.host = host;
            this.type = "mysql";
            this.port = 3306;

            return this;
        }

        public DbConfigBuilderV1 host(String host) {
            this.host = host;
            return this;
        }

        public DbConfigBuilderV1 username(String username) {
            this.username = username;
            return this;
        }

        public DbConfigBuilderV1 password(String password) {
            this.password = password;
            return this;
        }

        public DbConfigBuilderV1 type(String type) {
            this.type = type;
            return this;
        }

        public DbConfigBuilderV1 port(int port) {
            this.port = port;
            return this;
        }

        public DbConfig build() {
            return new DbConfig(host, username, password, port, type);
        }
    }

    public static class DbConfigBuilderV2 {
        private DbConfig dbConfig = new DbConfig();

        public DbConfigBuilderV2 mysql(String host) {
            this.dbConfig.host = host;
            this.dbConfig.type = "mysql";
            this.dbConfig.port = 3306;

            return this;
        }

        public DbConfigBuilderV2 host(String host) {
            this.dbConfig.host = host;
            return this;
        }

        public DbConfigBuilderV2 username(String username) {
            this.dbConfig.username = username;
            return this;
        }

        public DbConfigBuilderV2 password(String password) {
            this.dbConfig.password = password;
            return this;
        }

        public DbConfigBuilderV2 type(String type) {
            this.dbConfig.type = type;
            return this;
        }

        public DbConfigBuilderV2 port(int port) {
            this.dbConfig.port = port;
            return this;
        }

        public DbConfig build() {
            return this.dbConfig;
        }
    }
}
