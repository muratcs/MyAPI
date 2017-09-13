import org.junit.Assert;
import org.junit.Test;
import translation.ITranslationService;
import translation.TranslationService;

import java.io.IOException;

public class TestTranslationService {

    @Test
    public void testTranslate_1(){

        ITranslationService translationService = TranslationService.getInstance();
        String result = translationService.translate("Merhaba dostum.","en");
        System.out.println(result);
        Assert.assertEquals("Hello my friend.", result);
    }
    @Test
    public void testTranslate_2(){

        ITranslationService translationService = TranslationService.getInstance();
        String result = translationService.translate("Bir cisim yaklaşıyor efendim.","en");
        System.out.println(result);
        Assert.assertEquals("An object is approaching, sir.", result);
    }
    @Test
    public void testTranslate_3() {

        ITranslationService translationService = TranslationService.getInstance();
        String result = translationService.translate("Dünyalı dostum, tam olarak anlamadın galiba, kaçırıldın.","en");
        System.out.println(result);
        Assert.assertEquals("My earthly friend, I think you do not understand exactly, you were kidnapped.", result);
    }

    @Test
    public void testTranslateREST_1() throws IOException {

        ITranslationService translationService = TranslationService.getInstance();
        String result = translationService.translateWithREST("Merhaba dostum.","en");
        System.out.println(result);
        Assert.assertEquals("Hello my friend.", result);
    }
    @Test
    public void testTranslateREST_2() throws IOException {

        ITranslationService translationService = TranslationService.getInstance();
        String result = translationService.translateWithREST("Bir cisim yaklaşıyor efendim.","en");
        System.out.println(result);
        Assert.assertEquals("An object is approaching, sir.", result);
    }
    @Test
    public void testTranslateREST_3() throws IOException {

        ITranslationService translationService = TranslationService.getInstance();
        String result = translationService.translateWithREST("Dünyalı dostum, tam olarak anlamadın galiba, kaçırıldın.","en");
        System.out.println(result);
        Assert.assertEquals("My earthly friend, I think you do not understand exactly, you were kidnapped.", result);
    }

}
