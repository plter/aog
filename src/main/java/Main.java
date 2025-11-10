import org.graalvm.polyglot.Context;

public class Main {


    public static void main(String[] args) {
        try (var context = Context.create()) {
            context.eval("js", "console.log('Hello from GraalJS!')");
        }
    }
}
