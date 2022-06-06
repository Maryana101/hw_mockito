package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
  
  FilmManager managerFiveLimit = new FilmManager(5);
  FilmManager managerDefaultLimit = new FilmManager();
  
  
  @Test
  public void shouldAddNewFilms() {
    managerFiveLimit.add(first);
    managerFiveLimit.add(second);
    managerFiveLimit.add(seventh);
    Film[] actual = managerFiveLimit.findAll();
    Film[] expected = {first, second, seventh};
    
    assertArrayEquals(expected, actual);
  }
  
  @Test
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
    assertArrayEquals(expected, actual);
  }
  
  @Test
  public void findFilms() {
    managerFiveLimit.add(first);
    managerFiveLimit.add(second);
    
    Film[] actual = managerFiveLimit.findAll();
    Film[] expected = {first, second};
    assertArrayEquals(expected, actual);
    
  }
  
}