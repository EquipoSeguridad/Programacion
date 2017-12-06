package util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author md
 */
public class SHA1 {
    public static String cifrarContra(String contra) {
        return DigestUtils.sha1Hex(contra);
    }
}
