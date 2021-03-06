import java.util.*;
import greenfoot.*;

public class MobCache{
     
    private static Hashtable<Integer, Personagem> map = new Hashtable<Integer, Personagem>();
    static AbstractFactory  mobFactory = FactoryProducer.getFactory("MOBFACTORY");
    
    public static Personagem getMob(int mobID){
        Personagem cachedMod = map.get(mobID);
        return (Personagem) cachedMod.clone();       
    
    }
    public static int getSize(){
        return map.size();
    }
    
        public static void loadCache(String mo, int quant){
            Troll mob = (Troll)mobFactory.getMob(mo);
            
            for(int i = 0; i < quant; i++)
               map.put(i, (Personagem) mob.clone());
            
      
        }
        
  
  
    }
    
    
    
   

