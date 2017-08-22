import org.junit.Assert;
import org.junit.Test;

public class TestTranslationService {

    @Test
    public void testA(){

        ITranslationService translationService = new TranslationService();
        String result = translationService.translate("Merhaba dostum.","en");
        System.out.println(result);
        Assert.assertEquals("Hello my friend.", result);
    }
    @Test
    public void testB(){

        ITranslationService translationService = new TranslationService();
        String result = translationService.translate("Bir cisim yaklaşıyor efendim.","en");
        System.out.println(result);
        Assert.assertEquals("An object is approaching, sir.", result);
    }
    @Test
    public void testC(){

        ITranslationService translationService = new TranslationService();
        String result = translationService.translate("Dünyalı dostum, tam olarak anlamadın galiba, kaçırıldın.","en");
        System.out.println(result);
        Assert.assertEquals("My earthly friend, I think you do not understand exactly, you were kidnapped.", result);
    }
}
