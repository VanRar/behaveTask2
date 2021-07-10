public class FrogCommands implements FrogCommand {
    Frog frog;
    int steps;

    public FrogCommands(Frog frog, int steps) {
        this.frog = frog;
        this.steps = steps;
    }

    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        // возвращаете объект команды, у которого
        // если вызвать .do(), то лягушка её выполнит,
        // если вызвать .undo(), то лягушка её отменит
        return new FrogCommand() {
            @Override
            public boolean doo() {
                frog.jump(steps);
                return true;
            }

            @Override
            public boolean undo() {
                frog.jump(-steps);
                return true;
            }
        };

    }

    public boolean undo() {

        return FrogCommands.jumpRightCommand(frog, steps).undo();
    }

    public boolean doo() {
        return FrogCommands.jumpRightCommand(frog, steps).doo();
    }
}