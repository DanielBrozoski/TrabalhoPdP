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
        
        MobCache.loadCache("troll", 3);
        
        Troll clo = (Troll) MobCache.getMob(1);
        addObject(clo, 222,222);
        
         Troll clo3 = (Troll) MobCache.getMob(2);
         addObject(clo3, 222,222);
        
         Troll clo2 = (Troll) MobCache.getMob(0);
         addObject(clo2, 222,222);
    }
}
