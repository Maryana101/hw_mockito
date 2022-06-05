import ru.netology.domain.*;

public class Main {
  public static void main(String[] args) {
    Film first= new Film(1, "Воображариум доктора Парнаса");
    Film second=new Film(2, "Джей и молчаливый Боб");
    Film third=new Film(3, "Новые парни турбо");
    Film fourth=new Film(4,"Мученицы");
    Film fifth=new Film(5,"Темные воды");
    Film sixth=new Film(6,"Назови меня своим именем");
    Film seventh=new Film(7,"Дом, который посторил Джек");
    Film eighth=new Film(8,"Лабиринт Фавна");
    Film ninth=new Film(9,"Мальчик в полосатой пижаме");
    Film tenth=new Film(10,"Догвилль");
  
  
  
    //Film[] films={first, second, third, fourth};
    FilmManager manager = new FilmManager(5);
    manager.add(first);
    manager.add(second);
    manager.add(fourth);
    manager.add(seventh);
    manager.add(fifth);
    manager.add(second);
    //Film[] films=manager.getFilms();
    
    int length=manager.findLast().length;
    for (int i = 0; i < length; i++) {
      System.out.println(manager.findLast()[i].getId()+ " --- "+ manager.findLast()[i].getName());
      System.out.println();
      
    }
    
    
  }
}
