package ru.netology.domain;

public class FilmRepository {
  private Film[] films=new Film[0];
  
  public FilmRepository() {
  }
  
  
  public void save(Film newFilm){
    int length=films.length+1;
    int lastIndex=length-1;
    Film[] tmp=new Film[length];
    System.arraycopy(films,0,tmp,0,films.length);
    tmp[lastIndex]=newFilm;
    films=tmp;
  }
  
  public Film findById(int id){
    Film resultFilm=null;
    for (int i = 0; i < films.length; i++) {
      if (films[i].getId()==id){
        resultFilm= films[i];
      }
    }
    return resultFilm;
  }
  
  public void removeById(int id){
    int length=films.length-1;
    Film[] tmp=new Film[length];
    int index=0;
    for (Film film:films) {
      if (id!=film.getId()){
        tmp[index]=film;
        index++;
      }
    }
    films=tmp;
  }
  
  public Film[] getFilms() {
    return films;
  }
  
  public void setFilms(Film[] films) {
    this.films = films;
  }
}
