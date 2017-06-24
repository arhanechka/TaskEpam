package com.kpi.arkhipchuk.controller;

import javax.faces.context.FacesContext;
import java.util.Locale;

/**
 * Created by Anya on 24.06.2017.
 */
public class LocaleController {
    public static Locale LOCALE_UA = new Locale("ua");
    public static Locale LOCALE_EN = new Locale("en");
    private Locale locale = LOCALE_EN;

    public Locale getLocale() {
        return locale;
    }

    public String selectLanguage(String selectedLanguage) {
        locale = convert(selectedLanguage);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return FacesContext.getCurrentInstance().getViewRoot().getViewId() + "?faces-redirect=true";//перезагружаем страницу
    }

    public static Locale convert(String languageName) {
        if ("ua".equals(languageName)) {
            return LOCALE_UA;
        }

        return LOCALE_EN;
    }

    public boolean isUa() {
        return LOCALE_UA.equals(locale);
    }


}
