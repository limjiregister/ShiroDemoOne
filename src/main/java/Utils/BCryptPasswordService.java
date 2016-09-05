package Utils;

import org.apache.shiro.authc.credential.PasswordService;

/**
 * Created on 2016/8/7 20:04
 */
public class BCryptPasswordService implements PasswordService {

	@Override
	public String encryptPassword(Object plaintextPassword) throws IllegalArgumentException {
		final String str;
		if (plaintextPassword instanceof char[]) {
			str = new String((char[]) plaintextPassword);
		} else if (plaintextPassword instanceof String) {
			str = (String) plaintextPassword;
		} else {
			throw new SecurityException("Unsupported password type: " + plaintextPassword.getClass().getName());
		}
		return BCrypt.hashpw(str, BCrypt.gensalt());
	}

	@Override
	public boolean passwordsMatch(Object submittedPlaintext, String encrypted) {
		return BCrypt.checkpw(new String((char[]) submittedPlaintext), encrypted);
	}


}
