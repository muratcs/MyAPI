package translation;

public interface ITranslationService {

    String translate(String turkishText, String targetLanguage);

    String translateWithREST (String turkishText, String targetLanguage);
}
