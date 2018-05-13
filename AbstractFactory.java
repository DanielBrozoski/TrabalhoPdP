import greenfoot.*;

public abstract class AbstractFactory  
{
    public abstract Actor getMob(String name);
    public abstract Personagem getPlayable(String name);
}
