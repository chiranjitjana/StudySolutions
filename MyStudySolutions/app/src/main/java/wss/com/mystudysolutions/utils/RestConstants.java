package wss.com.mystudysolutions.utils;

/**
 * Created by Chiranjit Jana on 04/11/2017.
 */

public class RestConstants {

    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final String COLON = ":";
    private static final String DOUBLE_SLASH = "//";
    private static final String IP = "192.168.0.10";
    private static final String APP_NAME = "ss";
    private static final String VERSION = "v1";
    private static final String SLASH = "/";
    public static String URL;

    static {
        URL = new StringBuilder().append(HTTP).append(COLON).append(DOUBLE_SLASH).
                append(IP).append(SLASH).
                append(APP_NAME).append(SLASH).append(VERSION).append(SLASH).toString();


    }

    public final static String ALLBLOGS = "blogs.php";
    public final static String ALL_BLOGS_HEADER="blogs_header.php";
}
