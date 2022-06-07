package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

class FilmManagerTest {
  Film first = new Film(1, "Воображариум доктора Парнаса");
  Film second = new Film(2, "Джей и молчаливый Боб");
  Film third = new Film(3, "Новые парни турбо");
  Film fourth = new Film(4, "Мученицы");
  Film fifth = new Film(5, "Темные воды");
  Film sixth = new Film(6, "Елена");
  Film seventh = new Film(7, "Дом, который посторил Джек");
  Film eighth = new Film(8, "Лабиринт Фавна");
  Film ninth = new Film(9, "Мальчик в полосатой пижаме");
  Film tenth = new Film(10, "Догвилль");
  
  
  private FilmRepository mockRepo = Mockito.mock(FilmRepository.class);
  private FilmManager manager = new FilmManager(mockRepo);
  
  @Test
  public void shouldRemoveFilmById() {
    Film[] returned = {first, second, seventh, third};
    doReturn(returned).when(mockRepo).getFilms();
    
    manager.removeById(7);
    
    Film[] actual = manager.findAll();
    Film[] expected = {first, second, third};
  
  
  
  @Test
  public void shouldAddNewFilms() {
    managerFiveLimit.add(first);
    managerFiveLimit.add(second);
    managerFiveLimit.add(seventh);
    Film[] actual = managerFiveLimit.findAll();
    Film[] expected = {first, second, seventh};
    
  }
  
  
  @Test

  public void findLastFilms() {
    Film[] returned = {first, second, fourth, seventh};
    doReturn(returned).when(mockRepo).getFilms();
    
    Film[] actual = manager.findLast();
    Film[] expected = {seventh, fourth, second, first};
    
  public void findLastFilmsInFiveLimitLess() {
    managerFiveLimit.add(first);
    managerFiveLimit.add(second);
    managerFiveLimit.add(fourth);
    managerFiveLimit.add(seventh);
    Film[] actual = managerFiveLimit.findLast();
    Film[] expected = {seventh, fourth, second, first};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void findLastFilmsInFiveLimitMore() {
    managerFiveLimit.add(first);
    managerFiveLimit.add(first);
    managerFiveLimit.add(second);
    managerFiveLimit.add(fourth);
    managerFiveLimit.add(seventh);
    managerFiveLimit.add(fifth);
    managerFiveLimit.add(second);
    managerFiveLimit.add(tenth);
    Film[] actual = managerFiveLimit.findLast();
    Film[] expected = {tenth, second, fifth, seventh, fourth};
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void findLastFilmsInDefaultLimitLess() {
    managerDefaultLimit.add(first);
    managerDefaultLimit.add(second);
    managerDefaultLimit.add(third);
    managerDefaultLimit.add(fourth);
    managerDefaultLimit.add(fifth);
    managerDefaultLimit.add(sixth);
    managerDefaultLimit.add(seventh);
    managerDefaultLimit.add(eighth);
    
    Film[] actual = managerDefaultLimit.findLast();
    Film[] expected = {eighth, seventh, sixth, fifth, fourth, third, second, first};
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void findLastFilmsInDefaultLimit() {
    managerDefaultLimit.add(first);
    managerDefaultLimit.add(second);
    managerDefaultLimit.add(third);
    managerDefaultLimit.add(fourth);
    managerDefaultLimit.add(fifth);
    managerDefaultLimit.add(sixth);
    managerDefaultLimit.add(seventh);
    managerDefaultLimit.add(eighth);
    managerDefaultLimit.add(ninth);
    managerDefaultLimit.add(tenth);
    Film[] actual = managerDefaultLimit.findLast();
    Film[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

  }
  
  @Test

  public void addFilm() {
    Film eleventh = new Film(11, "Дюна");
    Film[] returned = {eighth, ninth, tenth, eleventh};
    doReturn(returned).when(mockRepo).getFilms();
    
    manager.add(eleventh);
    Film[] actual = manager.findAll();
    Film[] expected = {eighth, ninth, tenth, eleventh};

  public void findFilms() {
    managerFiveLimit.add(first);
    managerFiveLimit.add(second);
    
    Film[] actual = managerFiveLimit.findAll();
    Film[] expected = {first, second};

    
  }
  
}