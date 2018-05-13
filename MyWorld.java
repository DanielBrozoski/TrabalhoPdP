import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{


    public MyWorld()
    {    
        super(600, 400, 1); 
        init();
    }
    
    private void init(){
        AbstractFactory playerFactory = FactoryProducer.getFactory("PLAYABLEFACTORY");
        AbstractFactory mobFactory = FactoryProducer.getFactory("MOBFACTORY");
        
        Actor p = Personagem.getInstance("knight");
        addObject(p, 345,444);
        
        Actor mob = mobFactory.getMob("rat");
        addObject(mob, 222,222);
        
        Actor mob1 = mobFactory.getMob("troll");
        addObject(mob1, 222,222);
        
    }
}
