import greenfoot.*;

public class PlayableFactory extends AbstractFactory{

    @Override
    public Actor getMob(String name){
        return null;
    }
    
    
    @Override
    public Personagem getPlayable(String playableName){
       if (playableName == null)
            return null;
        else if(playableName.equals("knight"))
            return new Knight();
        else if(playableName.equals("mage"))
            return new Mage();
        
        return null;
    }
}
