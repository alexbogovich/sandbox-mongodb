package io.github.alexbogovich.sandboxmongodb;

import io.github.alexbogovich.sandboxmongodb.model.*;
import io.github.alexbogovich.sandboxmongodb.repository.ReactComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final ReactComponentRepository reactComponentRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        reactComponentRepository.deleteAll();
        reactComponentRepository.save(ReactComponent.builder()
                .name("COMPONENT_NAME")
                .reactElements(List.of(ReactElement.builder()
                        .props(Map.of("fun", new PropFunction("fun"), "obj", new PropObject(null,"obj"), "value", new PropValue("value")))
                        .type("TEST_PROPS_ELEMENT")
                        .build()))
                .build());
    }
}
