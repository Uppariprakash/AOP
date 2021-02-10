package test;

import org.springframework.aop.framework.ProxyFactoryBean;

import business.Bank;
import service.LogBeforeService;

public class Client {

	public static void main(String[] args) {
		
		Bank b = new Bank();
		LogBeforeService lbs = new LogBeforeService();
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTarget(b);
		pfb.addAdvice(lbs);
		Bank bproxy = (Bank)pfb.getObject();
		int amount =bproxy.deposite("sbi123", 5000);
		System.out.println(amount);
	}
}
