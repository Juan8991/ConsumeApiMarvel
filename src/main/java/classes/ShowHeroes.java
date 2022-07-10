package classes;

public class ShowHeroes {
    public void printEveryHero(){
        String hero2="Captain%20America";
        String hero3="Thor";
        String hero4="Iron%20Man";
        String hero5="Hulk";
        try {
            ConectionHttp conectionHttp = new ConectionHttp();
            conectionHttp.response(hero2);
            conectionHttp.response(hero3);
            conectionHttp.response(hero4);
            conectionHttp.response(hero5);
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
