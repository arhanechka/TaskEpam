package ua.kpi.company;

/**
 * Created by Anya on 11.05.2017.
 */
public class Main {

        public static void main(String[] args) {
            Model model =new Model();
            View view =new View();
            Controller controller = new Controller(model,view);
            controller.processUser();
        }
    }

