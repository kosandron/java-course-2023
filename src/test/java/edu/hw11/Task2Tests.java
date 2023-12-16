package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Tests {
    @Test
    @DisplayName("Redefine methode")
    void redefineMethode() {
        int a = 12;
        int b = 2;
        assertThat(ArithmeticUtils.sum(a, b)).isEqualTo(a + b);
        ByteBuddyAgent.install();

        new ByteBuddy()
            .redefine(
                ArithmeticUtils.class,
                ClassFileLocator.ForInstrumentation.fromInstalledAgent(ArithmeticUtils.class.getClassLoader())
            )
            .method(named("sum").and(ElementMatchers.returns(int.class)))
            .intercept(MethodDelegation.to(NewArithmeticUtils.class))
            .make()
            .load(ArithmeticUtils.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

        assertThat(ArithmeticUtils.sum(a, b)).isEqualTo(a * b);
    }
}
