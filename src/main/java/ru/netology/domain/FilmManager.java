package ru.netology.domain;

public class FilmManager {
  private FilmRepository repo = new FilmRepository();
  private Film[] films = new Film[0];
  private int limit = 10;
  
  public FilmManager(FilmRepository repo) {
    this.repo = repo;
  }
  
  public FilmManager(FilmRepository repo, int limit) {
    this.repo = repo;
    this.limit = limit;
  }
  
  public void add(Film newFilm) {
    repo.save(newFilm);
    int length = films.length + 1;
    int lastIndex = length - 1;
    Film[] tmp = new Film[length];
    for (int i = 0; i < films.length; i++) {
      tmp[i] = films[i];
    }
    tmp[lastIndex] = newFilm;
    films = tmp;
  }
  
  public Film[] findAll() {
    return repo.getFilms();
  }
  
  public Film[] findLast() {
    Film[] films = repo.getFilms();
    int length = films.length;
    int resultLength;
    if (films.length < limit) {
      resultLength = films.length;
    } else {
      resultLength = limit;
    }
    Film[] tmp = new Film[resultLength];
    for (int i = 0; i < resultLength; i++) {
      tmp[i] = films[length - 1 - i];
    }
    return tmp;
  }
  
  public void removeById(int id) {
    repo.removeById(id);
  }
  
  public void removeAll() {
    repo.removeAll();
  }
  
  public Film find(int id) {
    return repo.findById(id);
  }
  
  public int getLimit() {
    return limit;
  }
  
  public void setLimit(int limit) {
    this.limit = limit;
  }
}
