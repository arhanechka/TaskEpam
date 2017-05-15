package ua.kpi.training.controller.services;

import ua.kpi.training.model.Model;
import ua.kpi.training.model.entity.*;
import ua.kpi.training.view.TextConstants;
import ua.kpi.training.view.View;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Anya on 14.05.2017.
 */
public class UserInputData {
    private Scanner sc;
    private View view;
    public Model model;
    DataBase dataBase;

    public UserInputData(Scanner sc, View view) {
        this.sc = sc;
        this.view = view;
        this.model = new Model();
        dataBase = DataBase.getInstance();
    }

    public void createNote() {
        view.printMessage(view.GREETITNG_MESSAGE);
        addGlobalInformation();
        addCommentInformation();
        addGroup();
        addComunicationInformation();
        addAddress();
        addDateOfAdding();
    }

    private void addGlobalInformation() {

        GlobalInformation globalInformation = new GlobalInformation();
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.NICKNAME);
        globalInformation.setNickName(InputNickNameAndCheck(RegExExpressions.NICKNAME_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.LASTNAME);
        globalInformation.setLastName(InputAndCheckData(RegExExpressions.ALL_NAMES_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.FIRSTNAME);
        globalInformation.setFirstName(InputAndCheckData(RegExExpressions.ALL_NAMES_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.MIDDLENAME);
        globalInformation.setMiddleName(InputAndCheckData(RegExExpressions.ALL_NAMES_REGEX));


        model.setGlobalInformation(globalInformation);
    }

    private void addCommentInformation() {
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.COMMENT);
        model.setComment(sc.nextLine());
    }

    private void addGroup() {
        Groups groups = Groups.None;
        view.printFewMessages(view.GROUP_CHECKING_MESSAGE, Groups.Friends.toString(), Groups.Family.toString(), Groups.Work.toString(), Groups.Services.toString(), Groups.None.toString());
        groups = Groups.valueOf(InputAndCheckData(RegExExpressions.GROUP_REGEX));
        model.setGroup(groups);
    }

    private void addComunicationInformation() {
        Communications communications = new Communications();
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.HOME_PHONE_NUMBER);
        communications.setPhoneNumberHome(InputAndCheckData(RegExExpressions.PHONE_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.MOBILE_PHONE_NUMBER);
        communications.setPhoneNumberMobileFirst(InputAndCheckData(RegExExpressions.PHONE_REGEX));
        view.printFewMessages(view.IS_SECOND_MOBILE_EXIST, TextConstants.SECOND_MOBILE_PHONE_NUMBER);
        communications.setPhoneNumberMobileSecond(InputAndCheckData(RegExExpressions.SECOND_MOBILE));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.EMAIL);
        communications.setEmailAddress(InputAndCheckData(RegExExpressions.EMAIL_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.SKYPE);
        communications.setSkypeNickName(InputAndCheckData(RegExExpressions.NICKNAME_REGEX));
        model.setCommunications(communications);
    }

    private void addAddress() {
        Address address = new Address();
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.POSTAL_INDEX);
        address.setIndex(InputAndCheckData(RegExExpressions.INDEX_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.TOWN);
        address.setTown(InputAndCheckData(RegExExpressions.CITY_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.STREET);
        address.setStreet(InputAndCheckData(RegExExpressions.ALL_NAMES_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.HOUSE_NUMBER);
        address.setHomeNumber(InputAndCheckData(RegExExpressions.HOUSE_REGEX));
        view.printFewMessages(view.INPUT_INFORMATION_MESSAGE, TextConstants.FLAT_NUMBER);
        address.setAppartmentNumber(InputAndCheckData(RegExExpressions.NUMBER_REGEX));
        model.setAddress(address);
    }

        private void addDateOfAdding(){
        LocalDate localDate = LocalDate.now();
        model.setDateAdding(localDate);
    }

    private String InputNickNameAndCheck(String pattern) {
        String inputData = "";
        while (!(sc.hasNext() && (inputData = sc.next()).matches(pattern) && dataBase.checkNickName(inputData))) {
            view.printFewMessages(view.BUSY_NICK_NAME);
        }
        return inputData;

    }

    private String InputAndCheckData(String pattern) {
        String inputData = "";
        while (!(sc.hasNext() && (inputData = sc.next()).matches(pattern)))
            view.printFewMessages(view.WRONG_INFORMATION_MESSAGE);
        return inputData;
    }
}
