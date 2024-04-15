// Abstract Product: Button
interface Button {
    void render();
}

// Concrete Product: WindowsButton
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a button in Windows style.");
    }
}

// Concrete Product: MacOSButton
class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a button in MacOS style.");
    }
}

// Abstract Product: Checkbox
interface Checkbox {
    void render();
}

// Concrete Product: WindowsCheckbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a checkbox in Windows style.");
    }
}

// Concrete Product: MacOSCheckbox
class MacOSCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a checkbox in MacOS style.");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory for Windows
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory for MacOS
class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// --------- Client Code -----------
public class AbstractFactoryExample {
    private static GUIFactory createOSFactory() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            return new WindowsFactory();
        } else if (os.contains("mac")) {
            return new MacOSFactory();
        } else {
            throw new UnsupportedOperationException("Unsupported operating system.");
        }
    }

    public static void main(String[] args) {
        GUIFactory factory = createOSFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Render GUI components
        button.render();
        checkbox.render();
    }
}