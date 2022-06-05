package ru.netology.domain;

public class FilmManager {
  private Film[] films=new Film[0];
  private int limit=10;
  
  public FilmManager() {
  }
  
  public FilmManager(int limit) {
    this.limit = limit;
  }
  
  public void add (Film newFilm){
    int length= films.length+1;
    int lastIndex=length-1;
    Film[] tmp=new Film[length];
    for (int i = 0; i < films.length; i++) {
      tmp[i] = films[i];
    }
    tmp[lastIndex] = newFilm;
    films=tmp;
  }
  
  
  public Film[] findAll() {
    return films;
  }
  
  public Film[] findLast(){
    int length=films.length;
    int resultLength;
    if (films.length<limit) {
      resultLength = films.length;
    } else {
      resultLength=limit;
    }
    Film[] tmp=new Film[resultLength];
    for (int i = 0; i < resultLength; i++) {
      tmp[i]=films[length-1-i];
    }
    return tmp;
    
    
  }
  
  public void setFilms(Film[] films) {
    this.films = films;
  }
  
  public int getLimit() {
    return limit;
  }
  
  public void setLimit(int limit) {
    this.limit = limit;
  }
}
