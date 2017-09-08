

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.http.client.*;
import org.apache.http.client.methods.HttpGet;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class TranslationService implements ITranslationService {
    @Override
    public String translate(String turkishText, String targetLanguage) {

        TranslateOptions.Builder builder = TranslateOptions.getDefaultInstance().toBuilder();
        Translate translate = builder.build().getService();
        Translate.TranslateOption sourceLanguageOption = Translate.TranslateOption.sourceLanguage("tr");
        Translate.TranslateOption targetLanguageOption = Translate.TranslateOption.targetLanguage(targetLanguage);
        Translation translation = translate.translate(turkishText, sourceLanguageOption, targetLanguageOption);

        return translation.getTranslatedText();
    }

    @Override
    public String translateWithREST(String turkishText, String targetLanguage) throws IOException {

        String translateURL = "https://www.googleapis.com/language/translate/v2?key=";
        String apiKey = "AIzaSyC_ONbm2OtggexFbTERbf_bZnnS8K73s8s";
        String apiKeyENV = System.getenv("GOOGLE_API_KEY");
        String from = "&source=tr";
        String to = "&target=" + targetLanguage;
        String query = "&q=" + URLEncoder.encode(turkishText, "UTF-8").replace("+", "%20");

        String request = translateURL + apiKey + from + to + query;

        URL url = new URL(request);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() != 200) {
            throw new IOException(connection.getResponseMessage());
        }

        InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(streamReader);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();

        String raw = sb.toString();
        String rawTranslatedText = raw.substring(raw.indexOf(": \"") + 3, raw.lastIndexOf("\""));

        return StringEscapeUtils.unescapeHtml4(rawTranslatedText);
    }

}
