package quipux.co.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println(" dependencia creada a partir de una interfaz: hola ComponentImplement");
    }
}
