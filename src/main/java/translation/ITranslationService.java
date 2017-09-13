package translation;

import java.io.IOException;

public interface ITranslationService {

    String translate(String turkishText, String targetLanguage);

    String translateWithREST (String turkishText, String targetLanguage) throws IOException;
}
