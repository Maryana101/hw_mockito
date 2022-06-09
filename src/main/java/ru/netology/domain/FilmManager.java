package ru.netology.domain;

public class FilmManager {
  private FilmRepository repo = new FilmRepository();
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
    repo.setFilms(new Film[0]);
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
