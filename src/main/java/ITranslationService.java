import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface ITranslationService {

    String translate(String turkishText, String targetLanguage);

    String translateWithREST (String turkishText, String targetLanguage) throws IOException;
}
