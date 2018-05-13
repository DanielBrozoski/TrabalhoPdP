import greenfoot.*;

public class MobFactory extends AbstractFactory {

    @Override
    public Actor getMob(String mobName){
        if (mobName == null)
            return null;
        else if(mobName.equals("rat"))
            return new Rat();
        else if(mobName.equals("troll"))
            return new Troll();
        
        return null;
    }
    
    @Override
    public Personagem getPlayable(String playableName){
        return null;
    }
    
}
