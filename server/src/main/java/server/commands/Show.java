package commands;


import static support.Loader.repo;
/**

 The Save class  represents a command to display all elements of the collection.
 */
public class Show implements Command{

    /**

     Executes the "show" command by displaying all elements of the collection.
     @throws NullPointerException if collection is empty.
     */
    @Override
    public void execute() {
        try{
            if (repo.map.size() ==0) throw new NullPointerException("Коллекция пуста");
            for (int i : repo.map.keySet()){
                System.out.println(repo.map.get(i).toString());
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }
    /**
     Returns a String representation of the command, including its name and purpose.
     @return a String representation of the command
     */
    @Override
    public String toString(){
        return "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}

