package quipux.co.Bean;

public class MyBeanWithPropertiesImplements implements MyBeanWithProperties {

    private String name;
    private String apellido;


    public MyBeanWithPropertiesImplements(String nombre, String apellido) {
        this.name = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return name + " - " + apellido;
    }
}
