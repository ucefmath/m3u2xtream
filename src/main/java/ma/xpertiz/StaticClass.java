package ma.xpertiz;

import io.buji.pac4j.subject.Pac4jPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@Slf4j
public class StaticClass {


    public  static String getLoggedUserName() {
        final Subject subject = SecurityUtils.getSubject();
        if (subject != null) {

            Object principal = subject.getPrincipal();
            if (principal != null) {
                if (principal instanceof Pac4jPrincipal && !((Pac4jPrincipal) principal).getProfiles().isEmpty()) {
                    return ((Pac4jPrincipal) principal).getProfile().getUsername();
                } else {
                    return principal.toString();
                }
            }
        }
        return "";
    }
}
