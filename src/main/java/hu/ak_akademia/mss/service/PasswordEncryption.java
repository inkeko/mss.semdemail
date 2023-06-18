package hu.ak_akademia.mss.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordEncryption implements PasswordEncoder {

    private static final String ALGORITHM = "MD5";
    private String password;

    public PasswordEncryption() {
    }

    public PasswordEncryption(String password) {
        this.password = password;
    }

    public String encryptWithMD5() {
        try {
            var md = MessageDigest.getInstance(ALGORITHM);
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return getReferenceBytes(digest).stream() //
                    .map(b -> Integer.toString((b & 0xff) + 0x100, 16)) //
                    .collect(Collectors.joining());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Byte> getReferenceBytes(byte[] digest) {
        List<Byte> bytes = new ArrayList<>();
        for (var b : digest) {
            bytes.add(b);
        }
        return bytes;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        this.password = String.valueOf(rawPassword);
        return encryptWithMD5();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
