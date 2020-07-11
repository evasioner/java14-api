package newapi.newapi.models.types;

import lombok.Getter;

public enum RoleType implements Code<String> {
    ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER");
    @Getter
    private final String code;

    RoleType(String code) {
        this.code = code;
    }
}
