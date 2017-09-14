package translation;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.apache.commons.text.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class TranslationService implements ITranslationService {

    private static final TranslationService instance = new TranslationService();

    private TranslationService(){}

    public static TranslationService getInstance(){
        return instance;
    }

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
    public String translateWithREST(String turkishText, String targetLanguage)  {

        String translateURL = "https://www.googleapis.com/language/translate/v2?key=";
        String apiKey = "AIzaSyC_ONbm2OtggexFbTERbf_bZnnS8K73s8s";
        String apiKeyENV = System.getenv("GOOGLE_API_KEY");
        String from = "&source=tr";
        String to = "&target=" + targetLanguage;
        String query = null;
        try {
            query = "&q=" + URLEncoder.encode(turkishText, "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String request = translateURL + apiKey + from + to + query;

        URL url = null;
        try {
            url = new URL(request);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            assert url != null;
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert connection != null;
            if (connection.getResponseCode() != 200) {
                throw new IOException(connection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader streamReader = null;
        try {
            streamReader = new InputStreamReader(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert streamReader != null;
        BufferedReader reader = new BufferedReader(streamReader);

        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }

        String raw = sb.toString();
        String rawTranslatedText = raw.substring(raw.indexOf(": \"") + 3, raw.lastIndexOf("\""));

        return StringEscapeUtils.unescapeHtml4(rawTranslatedText);
    }

}
