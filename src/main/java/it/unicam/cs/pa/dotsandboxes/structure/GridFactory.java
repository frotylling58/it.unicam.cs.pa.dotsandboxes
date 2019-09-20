package it.unicam.cs.pa.dotsandboxes.structure;

/**
 * @param
 * @author Donoval Candolfi - Mattia Incoronato
 */
@FunctionalInterface
public interface GridFactory {
	IGrid createNewInstance(int size);
}
