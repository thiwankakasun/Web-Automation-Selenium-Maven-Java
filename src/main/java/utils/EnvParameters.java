package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EnvParameters {

    //General Config
    private static final String PROP_FILE = "config.properties";

    public static String CONTENT_TYPE = "";
    public static String CUSTOM_CONTENT_TYPE_PAYLOAD;
    public static String ENV;
    public static String GRAPHQL_SCHEMA_FOLDER;
    public static String GRAPHQL_INPUT_FOLDER = "";
    public static String TEST_ROOT_DIR;
    public static String AWS_REGION;
    private static final Properties properties = new Properties();

    static {

        // Loading General Configurations
        TEST_ROOT_DIR = System.getProperty("user.dir");
        FileInputStream in = null;
        try {
            in = new FileInputStream(TEST_ROOT_DIR + File.separator + PROP_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //throw new CustomException(PROP_FILE + " -> Config file not found, Please specify the correct config file");
        }

        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            //throw new CustomException("Failure loading property file -> " + e.getMessage());
        }

        // Load CONTENT_TYPE
        if (System.getProperty("ContentType") != null && !(System.getProperty("ContentType").equalsIgnoreCase(""))) {
            CONTENT_TYPE = System.getProperty("ContentType");
        } else if (properties.getProperty("ContentType") != null
                && !(properties.getProperty("ContentType").equalsIgnoreCase(""))) {
            CONTENT_TYPE = properties.getProperty("ContentType");
        }
//        } else {
//            throw new CustomException(
//                    "ContentType property not set, " + "it is mandate to define the ContentType property");
//        }

        // Load CUSTOM_CONTENT_TYPE_PAYLOAD
        if (System.getProperty("CustomContentTypePayload") != null && !(System.getProperty("CustomContentTypePayload").equalsIgnoreCase(""))) {
            CUSTOM_CONTENT_TYPE_PAYLOAD = System.getProperty("CustomContentTypePayload");
        } else if (properties.getProperty("CustomContentTypePayload") != null
                && !(properties.getProperty("CustomContentTypePayload").equalsIgnoreCase(""))) {
            CUSTOM_CONTENT_TYPE_PAYLOAD = properties.getProperty("CustomContentTypePayload");
        }
//        else {
//            // If custom content type is undefined, we will just log an informational message and set it to a default value of "JSON"
//            LoggerUtil.log("CustomContentTypePayload property not set - setting to a default value of \"JSON\"");
//            CUSTOM_CONTENT_TYPE_PAYLOAD = "JSON";
//        }

        // Load GRAPHQL_SCHEMA_FOLDER
        if (System.getProperty("graphql.schema.folder") != null
                && !(System.getProperty("graphql.schema.folder").equalsIgnoreCase(""))) {
            GRAPHQL_SCHEMA_FOLDER = System.getProperty("graphql.schema.folder");
        } else if (properties.getProperty("graphql.schema.folder") != null
                && !(properties.getProperty("graphql.schema.folder").equalsIgnoreCase(""))) {
            GRAPHQL_SCHEMA_FOLDER = properties.getProperty("graphql.schema.folder");
        } else {
            GRAPHQL_SCHEMA_FOLDER = "graphql" + File.separator + "schema";
        }

        // Load GRAPHQL_INPUT_FOLDER
        if (System.getProperty("graphql.input.folder") != null
                && !(System.getProperty("graphql.input.folder").equalsIgnoreCase(""))) {
            GRAPHQL_INPUT_FOLDER = System.getProperty("graphql.input.folder");
        } else if (properties.getProperty("graphql.input.folder") != null
                && !(properties.getProperty("graphql.input.folder").equalsIgnoreCase(""))) {
            GRAPHQL_INPUT_FOLDER = properties.getProperty("graphql.input.folder");
        } else {
            GRAPHQL_INPUT_FOLDER = "graphql" + File.separator + "input";
        }

        // Load ENV from Env property
        if (System.getProperty("Env") != null && !(System.getProperty("Env").equalsIgnoreCase(""))) {
            ENV = System.getProperty("Env");
        } else if (properties.getProperty("Env") != null && !(properties.getProperty("Env").equalsIgnoreCase(""))) {
            ENV = properties.getProperty("Env");
        }
//        else {
//            throw new CustomException("Environment property not set, " + "it is mandatory to set the Environment");
//        }

        if (System.getProperty("aws.region") != null
                && !(System.getProperty("aws.region").equalsIgnoreCase(""))) {
            AWS_REGION = System.getProperty("aws.region");
        } else if (properties.getProperty("aws.region") != null
                && !(properties.getProperty("aws.region").equalsIgnoreCase(""))) {
            AWS_REGION = properties.getProperty("aws.region");
        } else {

            AWS_REGION = null;
            System.err.println("Region property not set in the config properties");
        }
    }
}
