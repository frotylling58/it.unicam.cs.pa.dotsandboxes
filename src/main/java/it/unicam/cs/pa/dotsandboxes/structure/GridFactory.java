package it.unicam.cs.pa.dotsandboxes.structure;

/**
 * @param
 *
 */
@FunctionalInterface
public interface GridFactory {
	IGrid createNewInstance(int size);
}