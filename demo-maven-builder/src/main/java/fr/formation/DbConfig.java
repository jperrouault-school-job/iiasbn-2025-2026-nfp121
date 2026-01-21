package fr.formation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DbConfig {
    private String host;
    private String username;

    @Setter(value = AccessLevel.NONE)
    private String password;

    private int port;
    private String type;

    public static class DbConfigBuilder {
        public DbConfigBuilder mysql(String host) {
            this.host = host;
            this.type = "mysql";
            this.port = 3306;

            return this;
        }
    }
}
