public class FactoryProducer  {
   public static AbstractFactory getFactory(String choice){
       if(choice.equalsIgnoreCase("MOBFACTORY"))
            return new MobFactory();
       else if(choice.equalsIgnoreCase("PLAYABLEFACTORY"))
            return new PlayableFactory();
            
       return null;
   }
    
}
