package my.homeprojects.springms.tests;

import my.homeprojects.springms.entities.Person;
import my.homeprojects.springms.repo.PersonRepo;
import my.homeprojects.springms.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TestData {

    @InjectMocks
    PersonService personServiceMock;

    @Mock
    PersonRepo personRepo;

    private List<Person> DB ;

    @Before
    public void setUp() {
        DB = new ArrayList<>();
        Person person1 = new Person(5L, "Lapte", "Batut", 44);
        Person person2 = new Person(11L, "John", "Smith", 32);
        Person person3 = new Person(25L, "Rocky", "Rambo", 24);
        DB.add(person1);
        DB.add(person2);
        DB.add(person3);
    }

    @Test
    public void getPersonTest(){
        when(personRepo.findById(5L)).thenReturn(java.util.Optional.of(new Person(5L, "Lapte", "Batut", 44)));
        Optional<Person> personTest = personServiceMock.getPerson(5L);

        Assert.assertEquals("Lapte", personTest.get().getFirstName());
        Assert.assertEquals("Batut", personTest.get().getLastName());
        Assert.assertEquals(Integer.valueOf(44), personTest.get().getAge());

    }

    @Test
    public void getAllPersonsTest(){
        when(personRepo.findAll()).thenReturn(DB);
        List <Person> personList = personServiceMock.getAllPersons();
        Assert.assertEquals(3,personList.size());
        verify(personRepo).findAll();
    }
}
