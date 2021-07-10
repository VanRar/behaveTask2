import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Frog frog = new Frog();
        List<FrogCommands> commands = new ArrayList<>();
        int curCommand = -1;

        while (true) {
            System.out.println();
            System.out.println("Позиция лягушки");
            frog.print();
            System.out.println();
            System.out.println("Введите команду:\n" +
                    "+N - прыгни на N шагов направо\n" +
                    "-N - прыгни на N шагов налево\n" +
                    "<< - Undo (отмени последнюю команду)\n" +
                    ">> - Redo (повтори отменённую команду)\n" +
                    "!! - повтори последнюю команду\n" +
                    "0 - выход");
            //считываем ввод и конструируем комманду, если
            //пользователь не хотел выйти
            String command = scanner.nextLine();

            if ("0".equals(command)) break;

            /*пользователь хочет отменить действие*/
            if ("<<".equals(command)) {
                if (curCommand < 0) {
                    System.out.println("Нечего отменять!");
                } else {
                    commands.get(curCommand).undo();
                    curCommand--;
                }
                /*пользователь хочет повторить действие*/
            } else if (">>".equals(command)) {
                if (curCommand == commands.size() - 1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    commands.get(curCommand).doo();
                }

            } else if ("!!".equals(command)) {
                if (curCommand == -1) {
                    System.out.println("Нечего повторять!");
                } else {
                    curCommand++;
                    commands.get(commands.size() - 1).doo();
                    commands.add(commands.get(commands.size() - 1));
                }

            } else { //пользователь ввёл новое движение для лягушки
                if (curCommand != commands.size() - 1) {
                    //удаляем все команды которые были отменены
                    commands.remove(commands.size() - 1);

                }
                FrogCommands cmd = new FrogCommands(frog, Integer.parseInt(command));
                curCommand++;
                commands.add(cmd);
                cmd.doo();
            }
            frog.print();
        }
    }
}