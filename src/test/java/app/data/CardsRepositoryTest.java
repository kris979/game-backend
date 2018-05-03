package app.data;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.model.Card;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CardsRepositoryTest {

	@Autowired
	private CardsRepository repository;
	
	@Test
	public void testMinions() {
		List<Card> minions = repository.getMinions();
		assertThat(minions, is(notNullValue()));
		assertThat(minions.size(), is(greaterThan(100)));
	}

}
