import greenfoot.*;

public abstract class AbstractFactory  
{
    public abstract Personagem getMob(String name);
    public abstract Personagem getPlayable(String name);
}
