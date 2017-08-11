package com.synphoo.java.test.designPattern.producerConsumer.demo2;

public class Test {

	public static void main(String[] args) {
		Product target=new Product();
		
		for (int i = 0; i < 10; i++) {
			Thread athread1=new Thread(new Producer(target), "第"+(i+1)+"个生产线程");
			athread1.start();
			Thread bthread1=new Thread(new Consumer(target), "第"+(i+1)+"个消费线程");
			bthread1.start();
		}
		
		
		
		//
		/*new Thread(new Producer(target),"第1个生产线程").start();//生产
		new Thread(new Consumer(target),"第1个消费线程").start();//消费
		
		new Thread(new Producer(target),"第2个生产线程").start();//生产2
		new Thread(new Consumer(target),"第2个消费线程").start();//消费2
		
		new Thread(new Producer(target),"第3个生产线程").start();//生产3
		new Thread(new Consumer(target),"第3个消费线程").start();//消费3
		*/		
		
		/*Thread athread1=new Thread(new Producer(target), "第1个生产线程");
		athread1.start();
		Thread bthread1=new Thread(new Consumer(target), "第1个消费线程");
		bthread1.start();
		
		Thread athread2=new Thread(new Producer(target), "第2个生产线程");
		athread2.start();
		Thread bthread2=new Thread(new Consumer(target), "第2个消费线程");
		bthread2.start();
		
		Thread athread3=new Thread(new Producer(target), "第3个生产线程");
		athread3.start();
		Thread bthread3=new Thread(new Consumer(target), "第3个消费线程");
		bthread3.start();*/
		
		
	}
}
