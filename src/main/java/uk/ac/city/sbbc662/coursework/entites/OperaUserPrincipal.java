package uk.ac.city.sbbc662.coursework.entites;

import javax.security.auth.Subject;
import java.nio.file.attribute.UserPrincipal;

/**
 * An OperaUserPricipal represents the current user in the user details service.
 */
public class OperaUserPrincipal implements UserPrincipal {

    private OperaUser operaUser;

    public OperaUserPrincipal(OperaUser operaUser){
        this.operaUser = operaUser;
    }

    @Override
    public String getName() {
        return operaUser.getEmail();
    }


}
