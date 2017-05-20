package ua.kpi.training.controller;

import ua.kpi.training.model.Reflection;
import ua.kpi.training.view.TextConstants;

/**
 * Created by Anya on 20.05.2017.
 */
public class Controller {
    Reflection reflection;
    Object object;

    public Controller(Reflection reflection, Object object) {
        this.reflection = reflection;
        this.object = object;
    }

    public void processUser() {
        reflection.getConstructors(TextConstants.CONSTRACTOR_ANNOTATION);
        reflection.getModificator(TextConstants.MODIFICACTOR_ANNOTATION);
        reflection.getMethods(TextConstants.METHOD_ANNOTATION);
        reflection.getPackageAndClassName(TextConstants.PACKAGE_ANNOTATION, TextConstants.CLASS_ANNOTATION, TextConstants.SUPER_CLASS_ANNOTATION);
        reflection.getFields(TextConstants.FIELDS_ANNOTATION);
        reflection.getAnnotations(TextConstants.ANNOTATION);
        reflection.getInterfaces(TextConstants.INTERFACES_ANNOTATION);
    }

}
