package test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import test.data.Person;
import test.repository.PersonRepository;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    public void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    public void testGetPersonSuccess() {
        Mockito.when(personRepository.selectById("budi"))
                .thenReturn(new Person("budi", "Budi"));

        Person person = personService.get("budi");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("budi", person.getId());
        Assertions.assertEquals("Budi", person.getName());
    }

    @Test
    public void testRegisterSuccess() {
        Person person = personService.register("Budi");

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Budi"));

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Budi", person.getName());
        Assertions.assertNotNull(person.getId());
    }
}
