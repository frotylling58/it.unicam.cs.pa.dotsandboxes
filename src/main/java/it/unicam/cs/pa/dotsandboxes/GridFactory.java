package it.unicam.cs.pa.dotsandboxes;

@FunctionalInterface
public interface GridFactory {

	IGrid createNewInstance(int size);
}