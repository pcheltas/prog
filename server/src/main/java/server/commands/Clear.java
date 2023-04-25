package commands;

import static support.Loader.repo;


public class Clear implements Command {
    Loader loader;

    public Clear(Loader loader){
        this.loader = loader;
    }

    public Clear() {
    }

    @Override
    public void execute(String argument, Object commandObjectArgument) throws NullPointerException {
        try {
            repo.map.clear();
            System.out.println("Все элементы коллекции успешно удалены. Коллекция пуста");
        } catch (NullPointerException e) {
            System.out.println("Коллекция уже пуста");
        }
    }

    @Override
    public String toString(){
        return "clear: очистить коллекцию";
    }

}
