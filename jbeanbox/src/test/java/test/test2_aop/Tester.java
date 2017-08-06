package test.test2_aop;

import org.junit.Before;
import org.junit.Test;

import com.github.drinkjava2.jbeanbox.BeanBox;

import test.test2_aop.advices.AOPLogAdvice;

/**
 * @author Yong Zhu
 * @since 2.4
 */
public class Tester {
	@Before
	public void beforeTest() {
		System.out.println("========= AOP & AspectJ Test =========");
	}

	private Iitem item;

	public void setItem(Iitem item) {
		this.item = item;
	}

	public void doPrintItem() {
		item.doPrint();
	}

	@Test
	public void doTest() {
		BeanBox advice = new BeanBox(AOPLogAdvice.class).setProperty("name", "AOP Logger"); 
		BeanBox.defaultContext.setAOPAround("test.test2_aop.\\w*", "doPrint\\w*", advice, "doAround");
		BeanBox.defaultContext.setAOPBefore("test.test2_aop.\\w*", "doPrint\\w*", advice, "doBefore");
		BeanBox.defaultContext.setAOPAfterReturning("test.test2_aop.\\w*", "doPrint\\w*", advice, "doAfterReturning");
		BeanBox.defaultContext.setAOPAfterThrowing("test.test2_aop.\\w*", "doPrint\\w*", advice, "doAfterThrowing");
		
  		Tester t = new BeanBox(Tester.class) {
		}.setProperty("item", ItemImpl.class).getBean();
		t.doPrintItem();
	}

	public static void main(String[] args) {
		new Tester().doTest();
	}
}
