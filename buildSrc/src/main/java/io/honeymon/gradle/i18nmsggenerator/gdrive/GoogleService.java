package io.honeymon.gradle.i18nmsggenerator.gdrive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * <code>$USER_HOME/.credentials/client_secret.json</code> 파일을 생성한다.
 * <p>
 * <a href="https://developers.google.com/api-client-library/java/google-api-java-client/oauth2">Service accounts</a>
 */
public class GoogleService {
    private static final String APPLICATION_NAME = "SpreadSheet I18N Message Converter at Google Drive";
    private static final String ACCESS_TYPE_OFFLINE = "offline";
    private static final String CLIENT_SECRET_JSON = "client_secret.json";
    private static final String CREDENTIALS = ".credentials";
    private static final File DIR_CREDENTIALS = new File(System.getProperty("user.home"), CREDENTIALS);
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static HttpTransport HTTP_TRANSPORT;
    public static FileDataStoreFactory DATA_STORE_FACTORY;

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DIR_CREDENTIALS);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     *
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        GoogleClientSecrets clientSecrets = loadGoogleClientSecrets(getClientSecretJsonFile());

        GoogleAuthorizationCodeFlow flow = buildGoogleAuthorizationCodeFlow(clientSecrets);

        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");

        System.out.println(
                "Credentials saved to " + DIR_CREDENTIALS.getAbsolutePath());
        return credential;
    }

    /**
     * Build flow and trigger user authorization request.
     *
     * @param clientSecrets
     * @return
     * @throws IOException
     */
    private static GoogleAuthorizationCodeFlow buildGoogleAuthorizationCodeFlow(GoogleClientSecrets clientSecrets) throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType(ACCESS_TYPE_OFFLINE)
                .build();
    }

    /**
     * Load client secrets.
     *
     * @param clientSecretJsonFile
     * @return
     * @throws IOException
     */
    private static GoogleClientSecrets loadGoogleClientSecrets(File clientSecretJsonFile) throws IOException {
        GoogleClientSecrets clientSecrets;
        if (clientSecretJsonFile.exists()) {
            clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(new FileInputStream(clientSecretJsonFile)));
        } else {
            clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(GoogleService.class.getResourceAsStream("/" + CLIENT_SECRET_JSON)));
        }
        return clientSecrets;
    }

    /**
     * CLIENT_SECRET_JSON 파일을 읽어온다.
     *
     * @return
     */
    private static File getClientSecretJsonFile() {
        File clientSecretJsonFile = Paths.get("src/main/resources", CLIENT_SECRET_JSON).toFile();
        if (!clientSecretJsonFile.exists()) {
            clientSecretJsonFile = Paths.get(CLIENT_SECRET_JSON).toFile();
        }
        return clientSecretJsonFile;
    }

    /**
     * Build and return an authorized Sheets API client service.
     *
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();

        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }


}
