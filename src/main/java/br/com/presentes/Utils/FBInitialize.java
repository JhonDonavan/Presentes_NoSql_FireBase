package br.com.presentes.Utils;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FBInitialize {

	@PostConstruct
	public void initialize() {
		try {
			FileInputStream serviceAccount = new FileInputStream("C:\\FireBase\\presentes-f05df-firebase-adminsdk-o0vz0-2273c444c8.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://presentes-f05df.firebaseio.com/").build();

			FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
