package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class FilmManagerTest {
  private Film first;
  private Film second;
  private Film third;
  private FilmRepository mockRepo;
  private FilmManager manager;
  
  @BeforeEach
  public void setUp(){
    first = new Film(1, "First film");
    second = new Film(2, "Second film");
    third = new Film(3, "Third film");
  
    mockRepo = Mockito.mock(FilmRepository.class);
    manager= new FilmManager(mockRepo);
  }
 
  @Test
  public void shouldFindFilmById(){
    Film returned=first;
    doReturn(returned).when(mockRepo).findById(any(Integer.class));
    
    Film actual=manager.find(1);
    Film expected=first;
    assertEquals(expected,actual);
  }
  @Test
  public void shouldFindLastFilms() {
    Film[] returned = {first, second, third};
    doReturn(returned).when(mockRepo).getFilms();
    
    Film[] actual = manager.findLast();
    Film[] expected = {third, second, first};
    
    assertArrayEquals(expected, actual);
  }
  @Test
  public void shouldCallMethodSaveForAddFilm() {
    Film[] films={first, second};
    mockRepo.setFilms(films);
    manager.add(third);
    verify(mockRepo, times(1)).save(third);
  }

  
}