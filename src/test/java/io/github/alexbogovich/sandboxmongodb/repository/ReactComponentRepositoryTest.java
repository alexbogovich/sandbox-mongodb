package io.github.alexbogovich.sandboxmongodb.repository;

import io.github.alexbogovich.sandboxmongodb.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ReactComponentRepositoryTest {

    private static String COMPONENT_NAME = "TestComponent";
    private static String TEST_EMPTY_ELEMENT = "TestComponent";
    private static String TEST_PROPS_ELEMENT = "TestPropsElement";

    @Autowired
    ReactComponentRepository reactComponentRepository;

    @Before
    public void setUp() throws Exception {
        reactComponentRepository.deleteAll();
    }

    @Test
    public void saveComponentWithoutContent() {
        reactComponentRepository.save(ReactComponent.builder().name(COMPONENT_NAME).build());

        assertEquals(1L, reactComponentRepository.count());
        Optional<ReactComponent> optComponent = reactComponentRepository.findByName(COMPONENT_NAME);
        assertTrue(optComponent.isPresent());
        ReactComponent component = optComponent.get();

        assertEquals(COMPONENT_NAME,component.getName());
        assertNull(component.getReactElements());
    }

    @Test
    public void saveComponentWithElement() {
        reactComponentRepository.save(ReactComponent.builder()
                .name(COMPONENT_NAME)
                .reactElements(List.of(ReactElement.builder().type(TEST_EMPTY_ELEMENT).build()))
                .build());

        assertEquals(1L, reactComponentRepository.count());
        Optional<ReactComponent> test = reactComponentRepository.findByName(COMPONENT_NAME);
        assertTrue(test.isPresent());
        ReactComponent component = test.get();
        assertEquals(COMPONENT_NAME,component.getName());
        assertEquals(1,  component.getReactElements().size());
        ReactElement element = component.getReactElements().stream().findFirst().get();
        assertEquals(TEST_EMPTY_ELEMENT,element.getType());
    }

    @Test
    public void saveComponentWithElementWhichContainsAllTypes() {
        reactComponentRepository.save(ReactComponent.builder()
                .name(COMPONENT_NAME)
                .reactElements(List.of(ReactElement.builder()
                        .props(Map.of("fun", new PropFunction(), "obj", new PropObject(), "value", new PropValue()))
                        .type(TEST_PROPS_ELEMENT)
                        .build()))
                .build());

        assertEquals(1L, reactComponentRepository.count());
        Optional<ReactComponent> test = reactComponentRepository.findByName(COMPONENT_NAME);
        assertTrue(test.isPresent());
        ReactComponent component = test.get();
        assertEquals(COMPONENT_NAME,component.getName());
        assertEquals(1,  component.getReactElements().size());
        ReactElement element = component.getReactElements().stream().findFirst().get();
        assertEquals(TEST_PROPS_ELEMENT,element.getType());
        assertEquals(3, element.getProps().size());

        assertTrue(element.getProps().containsKey("fun"));
        assertTrue(element.getProps().get("fun") instanceof PropFunction);
        assertTrue(element.getProps().containsKey("obj"));
        assertTrue(element.getProps().get("obj") instanceof PropObject);
        assertTrue(element.getProps().containsKey("value"));
        assertTrue(element.getProps().get("value") instanceof PropValue);
    }

}