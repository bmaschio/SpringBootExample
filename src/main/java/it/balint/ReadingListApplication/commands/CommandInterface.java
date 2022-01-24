package it.balint.ReadingListApplication.commands;

public abstract class CommandInterface {
    protected boolean canExecute() throws ForbiddenException {
        return true;
    }

    
}
