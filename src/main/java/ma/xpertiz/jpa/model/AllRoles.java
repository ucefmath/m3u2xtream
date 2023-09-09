package ma.xpertiz.jpa.model;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
@Slf4j
public enum AllRoles {
    ADMIN,  USER;

    public static List<AllRoles> getAllRoles() {
        return Arrays.asList(AllRoles.values());
    }
    public static String getAllRolesString() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String s = objectMapper.writeValueAsString(AllRoles.values());

            return s;
        } catch (JsonProcessingException e) {
            log.error(e.getMessage(),e);
        }

        return "";
    }

}