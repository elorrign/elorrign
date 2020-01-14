package com.darecode.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.darecode.employees.api.exceptions.GenericException;
import com.darecode.employees.dto.GoogleUser;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class GoogleTokenVerifier {

	private static final String JWT_ITEM_FIRST_NAME = "given_name";
	private static final String JWT_ITEM_SURNAME = "family_name";
	private static final String JWT_ITEM_LOCALE = "locale";
	private static final String JWT_ITEM_PICTURE = "picture";
	private static final String JWT_ITEM_NAME = "name";
	private static final String JWT_ITEM_SUB = "sub";

	@Value("${google.client_id}")
	private String CLIENT_ID;
	
	public GoogleUser readUserInformation(final String idTokenString) {
		
		GoogleIdToken token = verify(idTokenString);

		if (token == null) {
			log.error("Invalid ID token {}", token);
			return null;
		}
		Payload payload = token.getPayload();

	
		String userId = payload.getSubject();
		log.info("User ID: {} ", userId);

		return convertData(payload);

	}

	private GoogleUser convertData(Payload payload) {
		return GoogleUser.builder()
				.email(payload.getEmail()).emailVerified(Boolean.valueOf(payload.getEmailVerified()))
				.familyName((String) payload.get(JWT_ITEM_SURNAME)).givenName((String) payload.get(JWT_ITEM_FIRST_NAME))
				.locale((String) payload.get(JWT_ITEM_LOCALE)).name((String) payload.get(JWT_ITEM_NAME)).idGoogle((String)payload.get(JWT_ITEM_SUB))
				.pictureUrl((String) payload.get(JWT_ITEM_PICTURE)).build();
	}

	private GoogleIdToken verify(String idTokenString) {
		JacksonFactory jacksonFactory = new JacksonFactory();
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), jacksonFactory)
				// Specify the CLIENT_ID of the app that accesses the backend
				.setAudience(Collections.singletonList(CLIENT_ID))
				// Or, if multiple clients access the backend:
				// .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
				.build();

		// (Receive idTokenString by HTTPS POST)

		try {
			return verifier.verify(idTokenString);
		} catch (GeneralSecurityException | IOException e) {
			log.error("error GeneralSecurityException | IOException el token", e);
			throw new GenericException(e);
		}

	}
}
