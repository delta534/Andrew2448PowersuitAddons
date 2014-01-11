/*package andrew.powersuits.common;

import com.google.common.base.Charsets;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;




import andrew.powersuits.common.AddonLogger;
import andrew.powersuits.common.ModularPowersuitsAddons;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;

import java.io.InputStreamReader;

public class Localization {
    public static final String LANG_PATH = "/assets/powersuitaddons/lang/";
    public static String extractedLanguage = "";

    public static String getCurrentLanguage() {
        return Minecraft.getMinecraft().gameSettings.language;
    }

    public static void loadCurrentLanguage() {
        if (getCurrentLanguage() != extractedLanguage) {
            extractedLanguage = getCurrentLanguage();
        }
        try {
            InputStream inputStream = ModularPowersuitsAddons.INSTANCE.getClass().getResourceAsStream(LANG_PATH + extractedLanguage + ".lang");
            Properties langPack = new Properties();
            langPack.load(new InputStreamReader(inputStream, Charsets.UTF_8));
            LanguageRegistry.instance().addStringLocalization(langPack, extractedLanguage);
        } catch (Exception e) {
            e.printStackTrace();
            AddonLogger.logError("Couldn't read MPSA localizations for language " + extractedLanguage + " :(");
        }
    }

    public static String translate(String str) {
        loadCurrentLanguage();
        return StatCollector.translateToLocal(str);
    }
}
*/