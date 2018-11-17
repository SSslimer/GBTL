package dataStructures.trees;

import utils.Covering;

public interface Criterion
{
	Covering belongs(TreeCell<?> cell);
}