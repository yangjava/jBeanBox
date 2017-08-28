package test.core_test.AopProxy;

import com.github.drinkjava2.jbeanbox.AopAround;
import com.github.drinkjava2.jbeanbox.BeanBox;

import test.test9_aop_annotation.AopInvokeAdvice;

/**
 * @author Yong 
 * @since 2.4.5
 */
public class NoConstructorTarget { 
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@AopAround(AopInvokeAdvice.class)
	public String getNameAndAge() {
		System.out.println("name=" + name + ", age=" + age);
		return "name=" + name + ", age=" + age;
	}

	public static class NoConstructorTargetBox extends BeanBox {
		{
			this.setClassOrValue(NoConstructorTarget.class);
			this.setProperty("name", "Jerry");
			this.setProperty("age", 4);
		}
	}
}