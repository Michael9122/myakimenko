package ru.job4j.tracker;

/**
 * @author Michael Yakimenko (Mixail912@gmail.com)
 * @since 24.02.2018
 * @version 1
 */
public class StartUI {
    /*
     * Константа меню для добавления новой заявки.

    private static final String ADD = "0";


     * Константа меню для поиска всех заявок.

    private static final String SHOWALL = "1";


     * Константа меню для редактирования заявки.

    private static final String EDIT = "2";


     * Константа меню для удаления заявки.

    private static final String DELETE = "3";


     * Константа меню для поиска заявки по id.

    private static final String FINDBYID = "4";


     * Константа меню для поиска заявки по имени.

    private static final String FINDBYNAME = "5";

     * Константа для выхода из цикла.

    private static final String EXIT = "6";

     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /*
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showItem();
            } else if (EDIT.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit? (y): ")));
    }

    /*
     * Метод реализует редактирование заявки.

    private void replaceItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите id старой заявки заявки :");
        String name = this.input.ask("Введите имя новой заявки :");
        String desc = this.input.ask("Введите описание новой заявки :");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
        System.out.println("------------ Новая заявка с Id : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует поиск заявки по имени.

    private void findByName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item item : items) {
            System.out.println("Заявка: " + item.getName());
        }
    }

    /**
     * Метод реализует поиск заявки по id.

    private void findById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        System.out.println("Заявка: " + item.getName());
    }

    /**
     * Метод реализует удаление заявки.

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = new Item();
        this.tracker.replace(id, item);
        System.out.println("------------ Заявка удалена -----------");
    }

    /**
     * Метод реализует поиск всех заявок.

    private void showItem() {
        System.out.println("------------ Показать все заявки --------------");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println("Заявка: " + item.getName());
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + " создана -----------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по id");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выход");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
