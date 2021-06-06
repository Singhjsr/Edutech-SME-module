package edutech.sme;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import edutech.sme.dao.SmeRepository;
import edutech.sme.entities.Sme;
import edutech.sme.services.SmeService;

@SpringBootTest
class SmeModuleApplicationTests {
	@Autowired
	private SmeService smes;
	@MockBean
	private SmeRepository smer;

	@Test
	 void showAllTest() {
		Sme s = new Sme();
		s.setUsername("username1");
		s.setId(100);
		s.setEmail("gmail");
		s.setName("ram");
		s.setPhone("00000");
		s.setSubject("maths");

		Sme s1 = new Sme();
		s1.setUsername("username2");
		s1.setId(102);
		s1.setEmail("pmail");
		s1.setName("lakshman");
		s1.setPhone("00100");
		s1.setSubject("java");

		List<Sme> list = List.of(s, s1);

		when(smer.findAll()).thenReturn(list);
		assertEquals(list, smes.showAll());
	}

	@Test
	 void addTest() {
		Sme s = new Sme();
		s.setUsername("username1");
		s.setId(103);
		s.setEmail("gmails");
		s.setName("shyam");
		s.setPhone("10000");
		s.setSubject("jpa");

		smes.add(s);
		verify(smer, times(1)).save(s);

	}

	@Test
	 void deleteTest() {
		Sme s = new Sme();
		s.setUsername("username1");
		s.setId(103);
		s.setEmail("gmails");
		s.setName("shyam");
		s.setPhone("10000");
		s.setSubject("jpa");

		smes.add(s);
		verify(smer, times(1)).save(s);

	}

	@Test
	 void showById() {
		Sme s = new Sme();
		s.setUsername("username1");
		s.setId(100);
		s.setEmail("gmail");
		s.setName("ram");
		s.setPhone("00000");
		s.setSubject("maths");

		Sme s1 = new Sme();
		s1.setId(102);
		s1.setUsername("username2");
		s1.setEmail("pmail");
		s1.setName("lakshman");
		s1.setPhone("00100");
		s1.setSubject("java");

		when(smer.findById(102)).thenReturn(Optional.of(s1));
		assertEquals(s1, smes.byId(102));

	}

	@Test
	 void ModifyTest() {
		Sme s = new Sme();
		s.setUsername("username1");
		s.setId(103);
		s.setEmail("gmails");
		s.setName("shyam");
		s.setPhone("10000");
		s.setSubject("jpa");

		smes.update(s);
		verify(smer, times(1)).save(s);

	}
}
