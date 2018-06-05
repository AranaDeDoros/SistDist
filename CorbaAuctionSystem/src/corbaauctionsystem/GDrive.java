package corbaauctionsystem;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

/*
DASDSADASDAS
 */
public class GDrive {

    public GDrive(ServerPanel sp) {
        this.sp = sp;
    }

    public GDrive(ClientPanel cp) {
        this.cp = cp;
    }

    public GDrive() {

    }

    ServerPanel sp;
    ClientPanel cp;
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FOLDER = "credentials"; // Directory to store user credentials.

    /**
     * Global instance of the scopes required by this quickstart. If modifying
     * these scopes, delete your previously saved credentials/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CLIENT_SECRET_DIR = "client_secret.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If there is no client_secret.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GDrive.class.getResourceAsStream(CLIENT_SECRET_DIR);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(CREDENTIALS_FOLDER)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    public void connect() throws IOException, GeneralSecurityException {
// Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        //log
        String fileID = "1zy0BW0OqP_En3Myb0DzfdzfERNtToVYE";
        //reloj
        String fileR = "1-gwmxXic8TWYmDZmB_kPZgzh5o8cKSa6";
        try {
            // First retrieve the file from the API.
            File file = service.files().get("").execute();

            // File's new metadata.
            file.setName("log.txt");
            file.setDescription("logfile");
            file.setMimeType("text/plain");

            // File's new content.
            java.io.File fileContent = new java.io.File("./log.txt");
            FileContent mediaContent = new FileContent("text/plain", fileContent);
            // Send the request to the API.
            File updatedFile = service.files().update(fileID, file, mediaContent).execute();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }

        System.out.println("//////////////////////////////////////////////////////////////////////////////////");

        System.out.println("//////////////////////////////////////////////////////////////////////////////////");
    }

    public static InputStream downloadFile() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        //reloj
        String fileR = "1-gwmxXic8TWYmDZmB_kPZgzh5o8cKSa6";

        File file = service.files().get(fileR).execute();

        System.out.println(file.getWebViewLink());
        if (file.getWebViewLink() != null && file.getWebContentLink().length() > 0) {
            try {
                HttpResponse resp
                        = service.getRequestFactory().buildGetRequest(new GenericUrl(""))
                                .execute();
                return resp.getContent();
            } catch (IOException e) {
                // An error occurred.
                e.printStackTrace();
                return null;
            }
        } else {
            // The file doesn't have any content stored on Drive.
            return null;
        }
    }

    public void upload() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        File fileMetadata = new File();
        fileMetadata.setName("reloj.jpg");
        java.io.File filePath = new java.io.File("./src/img/reloj.jpg");
        FileContent mediaContent = new FileContent("text/plain", filePath);
        File filez = service.files().create(fileMetadata, mediaContent).setFields("id").execute();
        System.out.println("Archivo subido con el ID: " + filez.getId());
    }
}
