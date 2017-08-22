

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;


public class TranslationService implements ITranslationService {
    @Override
    public String translate(String turkishText, String targetLanguage) {

//        String GOOGLE_API_KEY = "AIzaSyC_ONbm2OtggexFbTERbf_bZnnS8K73s8s";
//        Translate translate = TranslateOptions.getDefaultInstance().getService();
//        String defaultApiKey = TranslateOptions.getDefaultApiKey();
//        TranslateOptions.Builder asd = TranslateOptions.getDefaultInstance().toBuilder() ; asd.setApiKey("AIzaSyC_ONbm2OtggexFbTERbf_bZnnS8K73s8s");
//        System.out.println(defaultApiKey); translate = asd.build().getService();
//        Translation translation = translate.translate(turkishText, Translate.TranslateOption.sourceLanguage("tr"), Translate.TranslateOption.targetLanguage(targetLanguage));

        TranslateOptions.Builder builder = TranslateOptions.getDefaultInstance().toBuilder();
        //builder.setApiKey("AIzaSyC_ONbm2OtggexFbTERbf_bZnnS8K73s8s");
        //System.out.println(System.getenv("GOOGLE_API_KEY"));
        Translate translate = builder.build().getService();
        Translate.TranslateOption sourceLanguageOption = Translate.TranslateOption.sourceLanguage("tr");
        Translate.TranslateOption targetLanguageOption = Translate.TranslateOption.targetLanguage(targetLanguage);
        Translation translation = translate.translate(turkishText, sourceLanguageOption, targetLanguageOption);


        return translation.getTranslatedText();
    }


}
