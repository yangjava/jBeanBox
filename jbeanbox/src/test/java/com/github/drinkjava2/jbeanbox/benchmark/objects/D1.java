package com.github.drinkjava2.jbeanbox.benchmark.objects;

import javax.inject.Inject;

import com.github.drinkjava2.jbeanbox.annotation.PROTOTYPE;

@PROTOTYPE
public class D1 {
	public E e;

	@Inject
	public D1(E e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
